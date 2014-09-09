package controllers;

import play.mvc.*;
import views.html.*;
import java.sql.*;
import play.db.*;

public class ExampleDatabase extends Controller {

    public static Result index() throws SQLException {

        javax.sql.DataSource ds = DB.getDataSource();
        java.sql.Connection connection = ds.getConnection("sa", "");
        java.sql.Statement statement = connection.createStatement();
        /*statement.executeUpdate(
                "INSERT INTO company VALUES (0, 'Hybrida');" +
                "INSERT INTO company VALUES (1, 'Something');" +
                "INSERT INTO company VALUES (2, 'Nothing');");
        */

        ResultSet result = statement.executeQuery("SELECT COUNT(*) FROM company");
        result.absolute(1);
        int p = result.getInt(1);
        result = statement.executeQuery("SELECT * FROM company");
        String x = "";
        for (int i = 1; i <= p; ++i) {
            result.absolute(i);
            x += result.getString(2) + "<br>";
        }
        return ok(layoutHtml.render("Hybrida", play.twirl.api.Html.apply(x)));
        //ResultSet result = statement.executeQuery("SELECT * FROM company");

        //result.absolute(1);
        //return ok(layoutHtml.render("Hybrida", play.twirl.api.Html.apply("<h1>" + result.getString(2) + "</h1>")));
    }

}
