package controllers;

import play.mvc.*;
import views.html.*;
import models.*;

import static controllers.Feed.getArticleData;
import static controllers.Lol.toHtml;

public class Application extends Controller {

    /**
     * \brief Application class, handles basic site functionality.
     *
     * Handles basic functionality and responses. Handles index site,
     * unauthorized access requests, 404 requests, etc.
     *
     */

	final static play.data.Form<SearchForm> userForm = play.data.Form.form(SearchForm.class);

    public static Result index() throws java.sql.SQLException {
        return ok(frontPage.render(toHtml(getArticleData())));
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

