package application;

import models.LoginState;
import profile.models.User;
import play.mvc.Controller;
import play.mvc.Result;
import renders.Renders;

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
		if (LoginState.isValidlyLoggedIn()) return Renders.newsfeed();
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
				application.views.html.showUnauthorizedAccess.render()));
	}

	public static Result show401() {
		return showUnauthorizedAccess();
	}

	public static Result showForbidden() {
		return forbidden(
				views.html.layoutBoxPage.render(
						"Unauthorized",
						application.views.html.showUnauthorizedAccess.render()));
	}

	public static Result show403() {
		return showForbidden();
	}

	public static Result showNotFound(String get_value) {
		return notFound(
				views.html.layoutBoxPage.render(
						"404",
						application.views.html.show404.render(get_value)));
	}

	public static Result showNotFound() {
		return showNotFound(request().uri());
	}

	public static Result show404(String get_value) {
		return showNotFound(get_value);
	}

	public static Result show404() {
		return showNotFound();
	}

	public static Result showBadRequest(String get_value) {
		return badRequest(
				views.html.layoutBoxPage.render(
						"400",
						application.views.html.show400.render(get_value)));
	}

	public static Result showBadRequest() {
		return showBadRequest(request().uri());
	}

	public static Result show400(String get_value) {
		return showBadRequest(get_value);
	}

	public static Result show400() {
		return showBadRequest();
	}

	public static Result showInternalServerError() {
		return internalServerError(
				views.html.layoutBoxPage.render(
						"400",
						application.views.html.show500.render()));
	}

	public static Result show500() {
		return showInternalServerError();
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
