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
        ResultSet result = statement.executeQuery("SELECT * FROM company");
        result.absolute(1);
        return ok(layoutHtml.render("Hybrida", play.twirl.api.Html.apply("<h1>" + result.getString(2) + "</h1>")));
    }

}
