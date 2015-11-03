package application;

import com.google.common.collect.Lists;
import models.LoginState;
import models.Renders;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;

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
		java.util.List<Renders> articles = models.Renders.getVisibleRenderables();
		String concatenation = "";
		int count = 0;
		for (Renders renderable : Lists.reverse(articles)) {
			Html curcatenation = Html.apply("");
			models.Article art = renderable.articleReference;
			models.Event evt = renderable.eventReference;
			if (renderable.articleReference != null) {
				curcatenation = application.views.html.articleRenderFrontPageSample.render(art);
			} else if (renderable.eventReference != null) {
				art = evt.getArticle();
				curcatenation = application.views.html.eventRenderFrontPageSample.render(art, evt);
			}

			if (++count < 2) {
				concatenation += application.views.html.bigthumbnail.render(curcatenation);
			} else {
				concatenation += application.views.html.smallthumbnail.render(curcatenation);
			}
		}
		//Example for user access check:
		System.out.println(User.hasAccess(LoginState.getUser(), true, User.Access.BEDKOM, User.Access.ADMIN));
		return ok(views.html.layout.render(
			"Hybrida",
			application.views.html.index.render(views.html.utils.toHtml.render(concatenation))));
    }

	/**
	* Useful functions to use to return standard messages to the client.
	* @return
	*/
	public static Result showUnauthorizedAccess() {
		return unauthorized(
			views.html.layout.render(
				"Unauthorized",
				application.views.html.showUnauthorizedAccess.render()));
	}

	public static Result show404(String get_value) {
		return notFound(views.html.layout.render(
			"404",
			application.views.html.show404.render(get_value)));
	}

	public static Result show400(String get_value) {
		return badRequest(views.html.layout.render(
		"400",
		application.views.html.show400.render(get_value)));
	}

	/**
		\brief Check if the user has the ability to edit; if not: it returns a non-null Result.
	*/
	public static Result checkEditPrivilege(User user) {
		if (user.isDefault()) {
			return show400("Du må logge inn for å endre arransjement.");
		} if (!user.canCreateNewArticle()) {
			return show400("Du har ikke rettighetene til å endre på arransjementer.");
		}
		return null;
	}

}
