package examples.controllers;

import play.db.DB;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExampleDatabase extends Controller {

    public static Result index() throws SQLException {

        javax.sql.DataSource ds = DB.getDataSource();
        java.sql.Connection connection = ds.getConnection("hybrid", "");
        java.sql.Statement statement = connection.createStatement();

        ResultSet result = statement.executeQuery("SELECT COUNT(*) FROM company");
        result.absolute(1);
        int p = result.getInt(1);
        result = statement.executeQuery("SELECT * FROM company");
        String x = "";
        for (int i = 1; i <= p; ++i) {
            result.absolute(i);
            x += result.getString(2) + "<br>";
        }
        return ok(layout.render("Hybrida", play.twirl.api.Html.apply(x)));
    }

}
