package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;
import views.html.layoutHtml;
import views.html.lolContent;
import java.sql.*;
import play.db.*;
import play.mvc.*;


import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by eliasbragstadhagen on 06.09.14.
 */
public class Lol extends Controller{

    public static Result index(String name) throws SQLException{
        ArrayList<String> content = new ArrayList<String>();
        if (name != null){
            setNameData(name);
        }
        content.add(getNameData());
        return ok(layoutHtml.render("Hybrida MLG professional LoL team: ", lolContent.render(toHtml(getNameData()))));
    }
        public static Result noindex() throws SQLException{
            ArrayList<String> content = new ArrayList<String>();
            content.add(getNameData());

            return ok(layoutHtml.render("Hybrida MLG professional LoL team: ", lolContent.render(toHtml(getNameData()))));
        }

    public static Html toHtml(String string){
        return play.twirl.api.Html.apply(string);
    }

    public static String getNameData() throws SQLException{
        javax.sql.DataSource ds = DB.getDataSource();
        java.sql.Connection connection = ds.getConnection("sa", "");
        java.sql.Statement statement = connection.createStatement();

        ResultSet result = statement.executeQuery("SELECT COUNT(*) FROM names");
        result.absolute(1);
        int length = result.getInt(1);
        result = statement.executeQuery("SELECT * FROM names");
        String lolNames = "";
        for (int i = 1; i <= length; ++i) {
            result.absolute(i);
            lolNames += "<p><h1>" + result.getString(2) + "</h1></p>";
        }

       return lolNames;
    }

    public static void setNameData(String name) throws SQLException{
        javax.sql.DataSource ds = DB.getDataSource();
        java.sql.Connection connection = ds.getConnection("sa", "");
        java.sql.Statement statement = connection.createStatement();

        ResultSet result = statement.executeQuery("SELECT COUNT(*) FROM names");
        result.absolute(1);
        int length = result.getInt(1);
        int val = length + 1;

        statement.executeUpdate("INSERT INTO names VALUES('" + val + "','" + name + "')");
                //VALUES('" + name + "')");
    }

}


