package application;

import com.google.common.collect.Lists;
import models.*;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

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
	public static Result index() {
		java.util.List<Renders> articles = models.Renders.getVisibleRenderables();
		String concatenation = "";
		int count = 0;
		for (Renders renderable : Lists.reverse(articles)) {
			++count;
			play.twirl.api.Html curcatenation = play.twirl.api.Html.apply("");
			if (renderable.articleId != null) {
				models.Article inarticle = models.Article.find.byId(renderable.articleId);
				curcatenation = application.views.html.articleRenderFrontPageSample.render(inarticle);
			} else if (renderable.eventId != null) {
				models.Article inarticle = models.Article.find.byId(renderable.articleId);
				curcatenation = application.views.html.articleRenderFrontPageSample.render(inarticle);
			}

			if (count < 2) {
				concatenation += application.views.html.bigthumbnail.render(curcatenation);
			} else {
				concatenation += application.views.html.smallthumbnail.render(curcatenation);
			}
		}
		return ok(layout.render(
			"Hybrida",
			application.views.html.index.render(
				views.html.utils.toHtml.render(concatenation))));
	}

	/**
	* Useful functions to use to return standard messages to the client.
	* @return
	*/
	public static Result showUnauthorizedAccess() {
		return unauthorized(
			layout.render(
				"Unauthorized",
				application.views.html.showUnauthorizedAccess.render()));
	}

	public static Result show404(String get_value) {
		return notFound(layout.render(
			"404",
			application.views.html.show404.render(get_value)));
	}

	public static Result show400(String get_value) {
		return badRequest(layout.render(
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
