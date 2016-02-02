package ringen;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Andreas on 13/10/2015.
 */
public class Ringen extends Controller {
	public static Result index() {
		return ok(views.html.layoutWithHead.render(
				"I&IKT-Ringen",
				ringen.views.html.index.render(),
				ringen.views.html.indexHead.render()));
	}
	public static play.mvc.Result about() {
		return ok(views.html.layoutWithHead.render(
				"Om I&IKT-Ringen",
				ringen.views.html.about.render(),
				ringen.views.html.aboutHead.render()));
	}
}
