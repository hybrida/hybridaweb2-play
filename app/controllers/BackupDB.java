package controllers;

import play.db.DB;
import play.libs.F;
import play.mvc.Result;
import play.mvc.Results;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Tormod on 04.11.2014.
 */
public class BackupDB {
    public static F.Promise<Result> index() {
        F.Promise<Boolean> promiseOfBool = F.Promise.promise(
                new F.Function0<Boolean>() {
                    public Boolean apply() {
                        return backup();
                    }
                }
        );
        return promiseOfBool.map(
                new F.Function<Boolean, Result>() {
                    public Result apply(Boolean i) {
                        if (i) return Results.ok("Database backup successful!");
                        return Results.internalServerError("Couldn't backup database!");
                    }
                }
        );
    }

    private static Boolean backup() {
        javax.sql.DataSource ds = DB.getDataSource();
        String str = "# --- !Ups\r\n";
        try {
            java.sql.Connection connection = ds.getConnection("hybrid", "");
            java.sql.Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SCRIPT");
            while (result.next()) {
                Reader reader = new InputStreamReader(result.getAsciiStream(1));
                String everything = "";
                while (reader.ready()) {
                    char character = (char) reader.read();
                    everything += character;
                }
                for (String line : everything.split(";")) {
                    if (line.toUpperCase().startsWith("INSERT") && !line.toUpperCase().startsWith("INSERT INTO PUBLIC.PLAY_EVOLUTIONS")) str += "\r\n" + line + ";";
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
