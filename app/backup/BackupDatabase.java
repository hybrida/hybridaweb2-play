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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	private static ArrayList<Reader> h2Readers(String user, String password) throws SQLException {
		javax.sql.DataSource ds = DB.getDataSource();
		java.sql.Connection connection = ds.getConnection(user, password);
		java.sql.Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("SCRIPT SIMPLE NOSETTINGS"); // TO 'conf\\evolutions\\default\\2.sql'");
		ArrayList<Reader> readers = new ArrayList<>();
		while (result.next()) readers.add(new InputStreamReader(result.getAsciiStream(1)));
		result.close();
		return readers;
	}

	private static ArrayList<Reader> mysqlReaders(String user, String password) throws IOException {
		Runtime rt = Runtime.getRuntime();
		String[] commands = {"mysqldump","-u "+user+" -p"+password+" hybrida"};
		Process proc = rt.exec(commands);

		BufferedReader stdInput = new BufferedReader(new
				InputStreamReader(proc.getInputStream()));

		BufferedReader stdError = new BufferedReader(new
				InputStreamReader(proc.getErrorStream()));

// read the output from the command
		System.out.println("Here is the standard output of the command:\n");
		String s = null;
		while ((s = stdInput.readLine()) != null) {
			System.out.println(s);
		}

// read any errors from the attempted command
		System.out.println("Here is the standard error of the command (if any):\n");
		while ((s = stdError.readLine()) != null) {
			System.out.println(s);
		}
		return null;
	}

	private static Boolean backup() {
		ArrayList<Reader> readers = new ArrayList<>();
		String ups = "";
		String downs = "";
		ArrayList<String> table_names = new ArrayList<>();
		String everything = "";
		List<String> lines = new ArrayList<>();
		try {
			Configuration conf = play.Play.application().configuration();
			String dbUser = conf.getString("db.default.user");
			String dbPassword = conf.getString("db.default.password");
			switch(conf.getString("db.default.name")){
				case "mysql":
					readers = mysqlReaders(dbUser, dbPassword);
					break;
				default:
					readers = h2Readers(dbUser, dbPassword);
					break;
			}
			int count_of_qout = 0;
			for(Reader reader : readers) {
				while (reader.ready()) {
					char character = (char) reader.read();
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
			for (String line : lines) {
				String upper_line = line.toUpperCase();
				if (upper_line.startsWith("INSERT") && !upper_line.startsWith("INSERT INTO SYSTEM_LOB_STREAM") && !upper_line.startsWith("INSERT INTO PUBLIC.PLAY_EVOLUTIONS")) {
					if (upper_line.startsWith("INSERT INTO PUBLIC.USER")) ups = line + ups;
					else ups += line;
					String table_name = line.substring(12, upper_line.indexOf("(", 12));
					if (!table_names.contains(table_name)) {
						table_names.add(table_name);
						downs += "TRUNCATE TABLE " + table_name + ";" + System.lineSeparator(); //18 is the location after INSERT INTO PUBLIC.
					}
				}
			}


			String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			BufferedWriter writer = new BufferedWriter(new FileWriter("./conf/evolutions/default/backup/" + now + ".sql")); //When it's going to be used, call it 2.sql or something
			ups = "# --- !Ups" + System.lineSeparator() + ups;
			downs = "# --- !Downs" + System.lineSeparator() + "SET FOREIGN_KEY_CHECKS = 0;" + System.lineSeparator() + downs + "SET FOREIGN_KEY_CHECKS = 1;";
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
