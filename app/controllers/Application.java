package controllers;

import com.avaje.ebean.Page;
import play.mvc.*;
import views.html.*;
import models.*;


/**
 * \brief Application class, handles basic site functionality.
 *
 * Handles basic functionality and responses. Handles index site,
 * unauthorized access requests, 404 requests, etc.
 *
 */
public class Application extends Controller {

	final static play.data.Form<SearchForm> userForm = play.data.Form.form(SearchForm.class);

    public static Result index() throws java.sql.SQLException {
        String login = session("user");
        if (login != null)
            System.out.println(login);

        try {
            if (login != null) {
                login = play.api.libs.Crypto.decryptAES(login);

                login = login.split(",")[0];
                if (login != null) {
                    return ok(layoutHtml.render("Hybrida", escapeText.render("Welcome " + login)));
                } else {
                    return ok(layoutHtml.render("Hybrida", escapeText.render("Your sign is invalid, must implement auto-logout now...")));
                }
            }
        } catch (Exception exc) {
            session().clear();
        }
        return ok(layoutHtml.render("Hybrida", escapeText.render("<p><h1>Vælkømmen tell Hybrida! </h1></p>")));
    }

    public static Result showUnauthorizedAccess() {
        return unauthorized(layoutHtml.render("Unauthorized", unauthorizedAccess.render()));

    }

    public static Result show404(String get_value) {
    	return notFound(layoutHtml.render("404", notFoundErrorPage.render(get_value)));
    }


}

