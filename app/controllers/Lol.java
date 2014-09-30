package controllers;

import models.LolForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;
import views.html.layoutHtml;
import views.html.lolContent;
import java.sql.*;
import play.db.*;
import play.mvc.*;
import models.LolForm;
import play.data.Form;
import static play.data.Form.form;


import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by eliasbragstadhagen on 06.09.14.
 */
public class Lol extends Controller{

    final static Form<LolForm> lolForm = form(LolForm.class);

    public static Result index() throws SQLException, IllegalStateException{
        String name = new String();
        Form<LolForm> input = lolForm.bindFromRequest();
        if(input.hasErrors() == false) {
            name = input.get().gamertag;
        }
        if (name != null) {
            setNameData(name);
        }
        return noindex();
    }
        public static Result noindex() throws SQLException{
            ArrayList<String> content = new ArrayList<String>();
            content.add(getNameData());

            return ok(layoutHtml.render("Anakonda Buns ", lolContent.render(toHtml(getNameData()))));
        }

    public static Html toHtml(String string){
        return play.twirl.api.Html.apply(string);
    }

    public static String getNameData() throws SQLException{
        javax.sql.DataSource ds = DB.getDataSource();
        java.sql.Connection connection = ds.getConnection("hybrid", "");
        java.sql.Statement statement = connection.createStatement();

        ResultSet result = statement.executeQuery("SELECT COUNT(*) FROM lol_name");
        result.absolute(1);
        int length = result.getInt(1);
        result = statement.executeQuery("SELECT * FROM lol_name");
        String lolNames = "";
        for (int i = 1; i <= length; ++i) {
            result.absolute(i);
            lolNames += "<p><h1><img src=\"/assets/images/favicon.ico\" alt=\"rect\"/>- " + result.getString(2) + "</h1></p>";
        }

       return lolNames;
    }

    public static void setNameData(String name) throws SQLException{
        javax.sql.DataSource ds = DB.getDataSource();
        java.sql.Connection connection = ds.getConnection("sa", "");
        java.sql.Statement statement = connection.createStatement();

        ResultSet result = statement.executeQuery("SELECT COUNT(*) FROM lol_name");
        result.absolute(1);
        int length = result.getInt(1);
        int val = length + 1;

        statement.executeUpdate("INSERT INTO lol_name VALUES('" + val + "','" + name + "')");
                //VALUES('" + name + "')");
    }

    public static Result clearNameData() throws SQLException {
        javax.sql.DataSource ds = DB.getDataSource();
        java.sql.Connection connection = ds.getConnection("sa", "");
        java.sql.Statement statement = connection.createStatement();
        System.out.println("Outputfdsfds");
        statement.executeUpdate("DELETE FROM lol_name");
        return redirect(routes.Lol.noindex().absoluteURL(request()));
    }

}


