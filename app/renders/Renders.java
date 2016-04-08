package renders;

import java.util.*;

import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;
import renders.models.Renderable;

import static play.data.Form.form;

/**
 * Created by ivar on 29.10.2015.
 */
public class Renders extends Controller {

	public static List<Html> rendersHtml(List<? extends Renderable> renderables, boolean big) {
		List<Html> htmlList = new ArrayList<>();

		int count = 0;
		for (Renderable renderable : renderables) {
			if (count++ < 1 && big) htmlList.add(renders.views.html.renderBig.render(renderable.render()));
			else htmlList.add(renders.views.html.renderSmall.render(renderable.render()));
		}

		return htmlList;
	}

	public static Result showRenders(String title, List<? extends Renderable> renderables, boolean big) {
		return showRenders(title, renderables, big, 0, "");
	}

	public static Result showRenders(String title, List<? extends Renderable> renderables, boolean big, int page, String searchterm) {
		return ok(views.html.layoutWithHead.render(
				"Hybrida - " + title,
				renders.views.html.rendersBody.render(title, rendersHtml(renderables, big), page, searchterm),
				renders.views.html.rendersHead.render()));
	}

	public static Result newsfeed() {
		List<renders.models.Renders> articles = renders.models.Renders.getVisibleRenderables();
		return showRenders("Newsfeed", articles, true);
	}

}
