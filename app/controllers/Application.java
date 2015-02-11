package controllers;

import play.mvc.*;
import views.html.*;
import models.*;
import views.html.Article.articleRender;

import static models.Article.getArticleData;

public class Application extends Controller {

    /**
     * \brief Application class, handles basic site functionality.
     *
     * Handles basic functionality and responses. Handles index site,
     * unauthorized access requests, 404 and 400 results, etc.
     *
     */

    /**
     * \brief Index entry point of the website.
     */
    public static Result index() throws java.sql.SQLException {
        java.util.List<models.Article> articles = models.Renders.getVisibleArticles();
        String concatenation = "";
        for (models.Article article : articles) {
            concatenation += articleRender.render(article);
        }
        if (true)
            return ok(views.html.Application.index.render(play.twirl.api.Html.apply(concatenation)));
        return ok(views.html.Application.index.render(play.twirl.api.Html.apply(getArticleData())));
    }

    public static Result showUnauthorizedAccess() {
        return unauthorized(layoutHtml.render("Unauthorized", views.html.Application.showUnauthorizedAccess.render()));
    }

    public static Result show404(String get_value) {
    	return notFound(layoutHtml.render("404", views.html.Application.show404.render(get_value)));
    }

    public static Result show400(String get_value) {
        return badRequest(layoutHtml.render("400", views.html.Application.show400.render(get_value)));
    }

    public static Result proto()  throws java.sql.SQLException {
        java.util.List<models.Article> articles = models.Renders.getVisibleArticles();
        String concatenation = "";
        for (models.Article article : articles) {
            concatenation += articleRender.render(article);
        }
        if (true)
            return ok(views.html.protoFrontPage.render(play.twirl.api.Html.apply(concatenation)));
        return ok(views.html.protoFrontPage.render(play.twirl.api.Html.apply(getArticleData())));

        //return ok(views.html.Application.index.render(play.twirl.api.Html.apply("This is some stuff")));
    }
}