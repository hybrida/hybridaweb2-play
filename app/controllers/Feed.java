package controllers;
import models.*;
import org.apache.commons.io.FileUtils;
import play.mvc.Http;
import play.mvc.Result;
import views.html.*;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import play.db.*;
import play.data.Form;

import static controllers.Lol.toHtml;
import static play.data.Form.form;
import static play.mvc.Controller.request;
import static play.mvc.Results.ok;
import static play.mvc.Results.redirect;
import static play.mvc.Http.Request;
import static play.mvc.Results.unauthorized;


public class Feed {

    final static Form<FeedForm> feedForm = form(FeedForm.class);


    public static Result index() throws SQLException{
        if (LoginState.getUser().canCreateNewArticle() == false)
            return redirect(routes.Application.showUnauthorizedAccess());

        return ok(layoutHtml.render("NewsFeed", centerBlock.render(articleWriter.render("feed"))));
    }

    public static Result save() throws SQLException{
        if (LoginState.getUser().canCreateNewArticle() == false)
            return redirect(routes.Application.showUnauthorizedAccess());

        String title;
        String ingress;
        String article;
        String imageTitle;
        int id;//TODO Legge til Dato for Sortering

        Form<FeedForm> input = feedForm.bindFromRequest();

        if(input.hasErrors() == false) {
            title = input.get().title;
            ingress = input.get().ingress;
            article = input.get().article;

                Http.MultipartFormData body = request().body().asMultipartFormData();
                Http.MultipartFormData.FilePart picture = body.getFile("picture");
                if (picture != null) {
                    String fileName = picture.getFilename();
                    String contentType = picture.getContentType();
                    File file = picture.getFile();
                    try {
                        FileUtils.moveFile(file, new File("public/Upload", fileName));
                    } catch (IOException ioe) {
                        System.out.println("Problem operating on filesystem");
                    }
                    imageTitle = fileName;
                } else {
                    imageTitle = null;
                }


                javax.sql.DataSource ds = DB.getDataSource();
                java.sql.Connection connection = ds.getConnection("hybrid", "");
                java.sql.Statement statement = connection.createStatement();

                ResultSet result = statement.executeQuery("SELECT COUNT(*) FROM feed");
                result.absolute(1);
                int length = result.getInt(1);
                int val = length + 1;

                statement.executeUpdate("INSERT INTO feed VALUES('" + val + "','" + title + "','" + imageTitle + "','" + article + "','" + ingress + "')");
        }
        return redirect(routes.Application.index().absoluteURL(request()));
    }

    public static String getArticleData() throws SQLException{
        javax.sql.DataSource ds = DB.getDataSource();
        java.sql.Connection connection = ds.getConnection("hybrid", "");
        java.sql.Statement statement = connection.createStatement();

        ResultSet result = statement.executeQuery("SELECT COUNT(*) FROM feed");
        List<models.FeedEntity> entities = FeedEntity.find.all();
        result.absolute(1);
        int length = result.getInt(1);
        result = statement.executeQuery("SELECT * FROM feed ORDER BY id DESC");

        String finalPost = "";
        for (int i = 1; i <= length; ++i) {
            result.absolute(i);
            String check = result.getString(3);
            String url = routes.Feed.generateArticle(result.getString(1).replace(" ", "_")).absoluteURL(request());
            if (!check.equalsIgnoreCase("null")) {
                finalPost += "<a href=" + url +"><div class=\"content2\">" +
                        "<div style=\"border-bottom: 2px solid  #9e9d98 \">" +
                        "<img src=\"/assets/Upload/" + result.getString(3) + "\" alt=\"rect\" width=50% height=50%/><br>" +

                        escapeText.apply(result.getString(2).toUpperCase()).toString().replace("\n", "<br />") + "</div></a><br>" +
                        escapeText.apply(result.getString(5)).toString().replace("\n", "<br />") + "</div>";
            }
            else{
                finalPost += "<a href=" + url +"><div class=\"content2\">" +
                        "<div style=\"border-bottom: 2px solid  #9e9d98 \">" +
                        "<img src=\"/assets/images/favicon.ico\" alt=\"rect\"/><br>" +

                        escapeText.apply(result.getString(2).toUpperCase()).toString().replace("\n", "<br />") + "</a></div><br>" +
                        escapeText.apply(result.getString(5)).toString().replace("\n", "<br />") + "</div>";

            }
        }

        return finalPost;
    }

    public static Result clearAll() throws SQLException{
        javax.sql.DataSource ds = DB.getDataSource();
        java.sql.Connection connection = ds.getConnection("hybrid", "");
        java.sql.Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM feed");
        return redirect(routes.Application.index().absoluteURL(request()));
    }

    public static Result generateArticle(String newsTitle) throws SQLException{
        javax.sql.DataSource ds = DB.getDataSource();
        java.sql.Connection connection = ds.getConnection("hybrid", "");
        java.sql.Statement statement = connection.createStatement();

        String sqlStatement = "SELECT * FROM feed WHERE id = '" + newsTitle +"'";

        ResultSet result = statement.executeQuery(sqlStatement);
        result.absolute(1);
        String finalPost = "";

        String check = result.getString(3);

        if (!check.equalsIgnoreCase("null")) {
            finalPost += "<div class=\"content2\">" +
                    "<div style=\"border-bottom: 2px solid  #9e9d98 \">" +
                    "<img src=\"/assets/Upload/" + result.getString(3) + "\" alt=\"rect\" width=50% height=50%/><br>" +
                    escapeText.apply(result.getString(2).toUpperCase()).toString().replace("\n", "<br />") + "</div><br>" +
                    "<i>" + escapeText.apply(result.getString(5)).toString().replace("\n", "<br />") + "</i><br />" +
                    result.getString(4) + "</div></a>";
        }
        else{
            finalPost += "<div class=\"content2\">" +
                    "<div style=\"border-bottom: 2px solid  #9e9d98 \">" +
                    "<img src=\"/assets/images/favicon.ico\" alt=\"rect\"/><br>" +
                    "<i>" + escapeText.apply(result.getString(2).toUpperCase()).toString().replace("\n", "<br />") + "</i></div><br>" +
                    escapeText.apply(result.getString(5)).toString().replace("\n", "<br />") + "<br />" +
                    result.getString(4) + "</div>";
        }
        return ok(layoutHtml.render("NewsFeed", generateArticle.render(toHtml(finalPost))));

    }
}

/*TODO:  Funksjonalitet som skal dekkes av denne klassen, Admin for å ha tilgang, mulighet for å opprette hendelse,
 *TODO: Bredere mulighet for å redigere artikkelen ( flere bilder, med ulik plassering osv..)
* TODO: Innstillingsfelt for artikkelen etter opprettelse, med mulighet til å pinne, slette osv */
