package staticpages;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Andreas on 13/10/2015.
 */
public class Ringen extends Controller {
	public static Result index() {
		return ok(views.html.layoutWithHead.render(
				"I&IKT-Ringen",
				staticpages.views.html.ringen.render(),
				staticpages.views.html.ringenHead.render()));
	}
	public static play.mvc.Result about() {
		return ok(views.html.layoutWithHead.render(
				"Om I&IKT-Ringen",
				staticpages.views.html.aboutRingen.render(),
				staticpages.views.html.aboutRingenHead.render()));
	}
}
