package controllers;

import play.mvc.*;
import views.html.*;

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
        return ok(frontPage.render(play.twirl.api.Html.apply(getArticleData())));
    }

    public static Result showUnauthorizedAccess() {
        return unauthorized(layoutHtml.render("Unauthorized", unauthorizedAccess.render()));
    }

    public static Result show404(String get_value) {
    	return notFound(layoutHtml.render("404", notFoundErrorPage.render(get_value)));
    }

    public static Result show400(String get_value) {
        return badRequest(layoutHtml.render("400", methodFailureErrorPage.render(get_value)));
    }

}

