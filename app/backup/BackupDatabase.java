package backup;

import models.LoginState;
import play.Configuration;
import play.db.DB;
import play.mvc.Result;
import play.mvc.Results;
import profile.models.User;

import java.io.*;
import java.nio.charset.Charset;
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
		User user = LoginState.getUser();
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

		BufferedReader stdInput = new BufferedReader(new InputStreamReader(
				proc.getInputStream(),
				Charset.forName("UTF-8").newDecoder()
		));
		return stdInput.lines();
	}

	private static Boolean backup() {
		Stream<String> expressions = null;
		StringBuilder ups = new StringBuilder("# --- !Ups");
		ups.append(System.lineSeparator());
		int upsTopSize = ups.length();
		StringBuilder downs = new StringBuilder("# --- !Downs");
		downs.append(System.lineSeparator());
		downs.append("SET FOREIGN_KEY_CHECKS = 0;");
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
					} else if (character == '\\') {
						everything += "\\";
					} else if (character == ';') {
						everything += ';'; //everything.substring(0,everything.length()-1) + ";";
						//FIXME: So if character == ';', everything now ends with ';;'? Why?
					}
				}
				reader.close();
			}
			Pattern insertPattern = Pattern.compile("^INSERT INTO `?([a-z0-9_.]+)`?( ?(\\(|V))", Pattern.CASE_INSENSITIVE);
			Pattern stringDecodePattern = Pattern.compile("STRINGDECODE\\(('(\\\\'|[^'])*[^\\\\]')\\)");
			Pattern escapeCharPattern = Pattern.compile("\\\\\\\\u[0-9a-f]{4}");

			int h = 0, i = 0, j = 0;
			for (String line : lines) {
				Matcher insert = insertPattern.matcher(line);
				String table;
				if (insert.find() && !(table = insert.group(1).toLowerCase()).matches(".*(system_lob_stream|play_evolutions)")) {

					Matcher stringDecode = stringDecodePattern.matcher(line);
					while (stringDecode.find()) {
						String oldStringDecode = stringDecode.group(0);
						String newStringDecode = stringDecode.group(1);
						Matcher escapeChar = escapeCharPattern.matcher(oldStringDecode);
						while (escapeChar.find()) {
							String escape = escapeChar.group(0);
							String unescape = ""+(char)Integer.parseInt(escape.substring(3), 16);
							newStringDecode = newStringDecode.replace(escape, unescape);
						}
						line = line.replace(oldStringDecode, newStringDecode);
					}

					if (table.startsWith("public")) table = table.substring(7);
					line = line.replace(insert.group(0), "INSERT INTO " + table + insert.group(2));
					line = line.replace("VALUES ", "VALUES" + System.lineSeparator() + "\t");
					line = line.replace("),(", ")," + System.lineSeparator() + "\t(");
					if (table.endsWith("user")) ups.insert(upsTopSize, line); // Make sure users are at the top
					else ups.append(line);
					if (!tables.contains(table)) {
						tables.add(table);
						downs.append("TRUNCATE TABLE ");
						downs.append(table);
						downs.append(";");
						downs.append(System.lineSeparator());
					}
				}
			}
			downs.append("SET FOREIGN_KEY_CHECKS = 1;");


			String now = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String[] fileNames = {now + ".sql", "current_backup.sql"};
			for(String fileName : fileNames) {
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream("./conf/evolutions/default/backup/" + fileName),
						Charset.forName("UTF-8").newEncoder()
				));
				writer.write(ups + System.lineSeparator() + downs);
				writer.flush();
				writer.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
		return true;
	}

}
