package controllers;
import models.FeedForm;
import play.mvc.Result;
import views.html.feed;
import views.html.layoutHtml;
import java.sql.*;
import java.util.ArrayList;

import play.db.*;
import play.data.Form;

import static controllers.Lol.toHtml;
import static play.data.Form.form;
import static play.mvc.Results.ok;
import static play.mvc.Results.redirect;

/**
 * Created by eliasbragstadhagen on 23.09.14.
 */
public class Feed {

    final static Form<FeedForm> feedForm = form(FeedForm.class);


    public static Result index() throws SQLException{

        return ok(layoutHtml.render("NewsFeed", feed.render(toHtml(getArticleData()))));
    }

    public static Result save() throws SQLException{
        String title;
        String article;
        int id;

        Form<FeedForm> input = feedForm.bindFromRequest();

        if(input.hasErrors() == false) {
            title = input.get().title;
            article = input.get().article;


            javax.sql.DataSource ds = DB.getDataSource();
            java.sql.Connection connection = ds.getConnection("sa", "");
            java.sql.Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT COUNT(*) FROM feed");
            result.absolute(1);
            int length = result.getInt(1);
            int val = length + 1;

            statement.executeUpdate("INSERT INTO feed VALUES('" + val + "','" + title + "','" + article + "')");


        }
    return index();
    }
    public static String getArticleData() throws SQLException{
        javax.sql.DataSource ds = DB.getDataSource();
        java.sql.Connection connection = ds.getConnection("sa", "");
        java.sql.Statement statement = connection.createStatement();

        ResultSet result = statement.executeQuery("SELECT COUNT(*) FROM feed");
        result.absolute(1);
        int length = result.getInt(1);
        result = statement.executeQuery("SELECT * FROM feed ORDER BY id DESC");

        String finalPost = "";
        for (int i = 1; i <= length; ++i) {
            result.absolute(i);
            finalPost +=  "<div class=\"content2\"><h1><img src=\"/assets/images/favicon.ico\" alt=\"rect\"/>" +
                    result.getString(2) + "</h1>" + "<h2><div class=\"content3\">" +
                    result.getString(3) + "</div></div></h2>";
        }

        return finalPost;
    }
}
