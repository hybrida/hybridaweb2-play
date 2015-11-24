package newsfeed;

import java.util.List;

import models.Renders;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;
import newsfeed.views.html.*;

/**
 * Created by ivar on 29.10.2015.
 */
public class Newsfeed extends Controller {

	public static Result index(List<Renders> renderables) {
		String concatenation = "";

		int count = 0;
		for (Renders renderable : renderables) {
			Html curcatenation = Html.apply("");
			models.Article art = renderable.articleReference;
			models.Event evt = renderable.eventReference;
			if (renderable.articleReference != null) {
				curcatenation = articleRenderFrontPageSample.render(art);
			} else if (renderable.eventReference != null) {
				art = evt.getArticle();
				curcatenation = eventRenderFrontPageSample.render(art, evt);
			}

			if (++count < 2) {
				concatenation += bigthumbnail.render(curcatenation);
			} else {
				concatenation += smallthumbnail.render(curcatenation);
			}
		}
		//Example for user access check:
		/* System.out.println(
			User.hasAccess(LoginState.getUser(),
				true, User.Access.BEDKOM, User.Access.ADMIN));
		*/
		return ok(views.html.layoutWithHead.render(
			"Hybrida - Newsfeed",
			newsfeedBody.render(views.html.utils.toHtml.render(concatenation)),
			newsfeedHead.render()));
	}

	public static Result index() {
		List<Renders> articles = models.Renders.getVisibleRenderables();
		return index(articles);
	}

}
