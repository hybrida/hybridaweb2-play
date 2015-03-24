package controllers;

import models.LoginState;
import play.db.DB;
import play.libs.F;
import play.mvc.Result;
import play.mvc.Results;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tormod on 04.11.2014.
 */
public class BackupDatabase {

    public static Result index() {
        models.User user = LoginState.getUser();
        if (!(!user.isDefault() && (user.admin || user.root))) {
            return Application.showUnauthorizedAccess();
        }

        if (backup())
            return Results.ok("Database backup successful!");
        return Results.internalServerError("Couldn't backup database!");
    }

    private static Boolean backup() {
        javax.sql.DataSource ds = DB.getDataSource();
        String str = "# --- !Ups" + System.lineSeparator();
        try {
            java.sql.Connection connection = ds.getConnection("hybrid", "");
            java.sql.Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SCRIPT SIMPLE NOSETTINGS"); // TO 'conf\\evolutions\\default\\2.sql'");
            while (result.next()) {
                Reader reader = new InputStreamReader(result.getAsciiStream(1));
                String everything = "";
                List<String> lines = new ArrayList<>();
                int count_of_qout = 0;
                while (reader.ready()) {
                    char character = (char) reader.read();
                    everything += character;
                    if (character == '\'') count_of_qout++;
                    else if (character == ';' && count_of_qout%2 == 0) {
                        lines.add(everything + System.lineSeparator());
                        everything = "";
                    } else if (character == ';') {
                        everything += ';'; //everything.substring(0,everything.length()-1) + ";";
                    }
                }
                str += everything;
                for (String line : lines) {
                    String upper_line = line.toUpperCase();
                    if (upper_line.startsWith("INSERT") && !upper_line.startsWith("INSERT INTO SYSTEM_LOB_STREAM") && !upper_line.startsWith("INSERT INTO PUBLIC.PLAY_EVOLUTIONS")) {
                        str += line;
                    }
                }
                reader.close();
            }
            result.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("conf\\evolutions\\default\\backup.sql")); //When it's going to be used, call it 2.sql or something
            writer.write(str);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
