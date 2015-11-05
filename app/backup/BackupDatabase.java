package backup;

import models.LoginState;
import play.Configuration;
import play.db.DB;
import play.mvc.Result;
import play.mvc.Results;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Tormod on 04.11.2014.
 */
public class BackupDatabase {

	public static Result index() {
		models.User user = LoginState.getUser();
		if (!(!user.isDefault() && (user.admin || user.root))) {
			return application.Application.showUnauthorizedAccess();
		}

		if (backup())
			return Results.ok("Database backup successful!");
		return Results.internalServerError("Couldn't backup database!");
	}

	private static Stream<String> h2ExpressionStream(String user, String password) throws SQLException {
		javax.sql.DataSource ds = DB.getDataSource();
		java.sql.Connection connection = ds.getConnection(user, password);
		java.sql.Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("SCRIPT SIMPLE NOSETTINGS"); // TO 'conf\\evolutions\\default\\2.sql'");
		ArrayList<String> expressions = new ArrayList<>();
		while (result.next()) expressions.add(result.getString(1));
		result.close();
		return expressions.stream();
	}

	private static Stream<String> mysqlExpressionStream(String user, String password) throws Exception {
		Runtime rt = Runtime.getRuntime();
		String[] commands = {"mysqldump","-h127.0.0.1", "-u"+user, "-p"+password, "hybrida"};
		Process proc = rt.exec(commands);

		BufferedReader stdError = new BufferedReader(
				new InputStreamReader(proc.getErrorStream()));
		if ((stdError.ready())) throw new Exception(stdError.readLine());

		BufferedReader stdInput = new BufferedReader(new
				InputStreamReader(proc.getInputStream()));
		return stdInput.lines();
	}

	private static Boolean backup() {
		Stream<String> expressions = null;
		StringBuilder ups = new StringBuilder("# --- !Ups");
		ups.append(System.lineSeparator());
		int upsTopSize = ups.length();
		StringBuilder downs = new StringBuilder("# --- !Downs");
		downs.append(System.lineSeparator());
		downs.append("SET FOREIGN_KEY_CHEKCS = 0;");
		downs.append(System.lineSeparator());
		ArrayList<String> tables = new ArrayList<>();
		String everything = "";
		List<String> lines = new ArrayList<>();
		try {
			Configuration conf = play.Play.application().configuration();
			String dbUser = conf.getString("db.default.user");
			String dbPassword = conf.getString("db.default.password");
			switch(conf.getString("db.default.name")){
				case "mysql":
					expressions = mysqlExpressionStream(dbUser, dbPassword);
					break;
				default:
					expressions = h2ExpressionStream(dbUser, dbPassword);
					break;
			}
			int count_of_qout = 0;
			for(String expression : expressions.collect(Collectors.toList())) {
				Reader reader = new StringReader(expression);
				int read;
				while (reader.ready() && (read = reader.read()) != -1) {
					char character = (char) read;
					everything += character;
					if (character == '\'') count_of_qout++;
					else if (character == ';' && count_of_qout%2 == 0) {
						lines.add(everything + System.lineSeparator());
						everything = "";
					} else if (character == ';') {
						everything += ';'; //everything.substring(0,everything.length()-1) + ";";
						//FIXME: So if character == ';', everything now ends with ';;'? Why?
					}
				}
				reader.close();
			}
			Pattern insertPattern = Pattern.compile("^insert into `?([a-z0-9_]+)\\b", Pattern.CASE_INSENSITIVE);
			for (String line : lines) {
				Matcher insert = insertPattern.matcher(line);
				String table;
				if (insert.find() && !(table = insert.group(1).toLowerCase()).matches("system_lob_stream|play_evolutions")) {
					line = line.replaceAll(insert.group(0), "INSERT INTO `" + table);
					line = line.replaceAll("VALUES ", "VALUES" + System.lineSeparator() + "\t");
					line = line.replaceAll("\\),\\(", ")," + System.lineSeparator() + "\t(");
					if (table.equals("user")) ups.insert(upsTopSize, line); // Make sure users are at the top
					else ups.append(line);
					if (!tables.contains(table)) {
						tables.add(table);
						downs.append("TRUNCATE TABLE `");
						downs.append(table);
						downs.append("`;");
						downs.append(System.lineSeparator());
					}
				}
			}


			String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			BufferedWriter writer = new BufferedWriter(new FileWriter("./conf/evolutions/default/backup/" + now + ".sql"));
			downs.append("SET FOREIGN_KEY_CHECKS = 1;");
			writer.write(ups + System.lineSeparator() + downs);
			writer.flush();
			writer.close();

			writer = new BufferedWriter(new FileWriter(
					"./conf/evolutions/default/backup/current_backup.sql"));
			writer.write(ups + System.lineSeparator() + downs);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
		return true;
	}

}
