package application;

import models.LoginState;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;

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
	public static Result index() {
		if (LoginState.isValidlyLoggedIn()) return newsfeed.Newsfeed.index();
		return frontpage();
	}

	public static Result frontpage() {
		if (!LoginState.isValidlyLoggedIn() && request().path().equals(routes.Application.frontpage().toString()))
			return redirect(routes.Application.index());
		return ok(views.html.layout.render("Hybrida", application.views.html.index.render()));
	}

	/**
	* Useful functions to use to return standard messages to the client.
	* @return
	*/
	public static Result showUnauthorizedAccess() {
		return unauthorized(
			views.html.layoutBoxPage.render(
				"Unauthorized",
				application.views.html.showUnauthorizedAccess.render(),
				null));
	}

	public static Result show404(String get_value) {
		return notFound(
			views.html.layoutBoxPage.render(
				"404",
				application.views.html.show404.render(get_value),
				null));
	}

	public static Result show400(String get_value) {
		return badRequest(
			views.html.layoutBoxPage.render(
							"400",
							application.views.html.show400.render(get_value),
							null));
	}

	/**
		\brief Check if the user has the ability to edit; if not: it returns a non-null Result.
	*/
	public static Result checkEditPrivilege(User user) {
		if (user.isDefault()) {
			return show400("Du må logge inn for å endre arrangement.");
		} if (!user.canCreateNewArticle()) {
			return show400("Du har ikke rettighetene til å endre på arrangementer.");
		}
		return null;
	}

}
