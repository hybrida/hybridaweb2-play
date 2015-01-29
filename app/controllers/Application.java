package controllers;

import play.mvc.*;
import views.html.*;
import models.*;
import views.html.Application.showUnauthorizedAccess;

import static controllers.Feed.getArticleData;
import static trash.controllers.Lol.toHtml;

public class Application extends Controller {

    /**
     * \brief Application class, handles basic site functionality.
     *
     * Handles basic functionality and responses. Handles index site,
     * unauthorized access requests, 404 and 400 results, etc.
     *
     */

    public static Result index() throws java.sql.SQLException {
        return ok(views.html.Application.index.render(toHtml(getArticleData())));
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

}

