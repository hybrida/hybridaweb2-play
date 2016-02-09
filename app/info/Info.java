package info;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

/**
 * Created by Kia on 16.10.14.
 */
public class Info extends Controller {
	static public Result index() {
		return ok(views.html.layoutWithHead.render(
				"Hybrida - Om Hybrida",
				info.views.html.index.render(),
				info.views.html.head.render()));
	}
	static public Result styret() {
		return ok(layout.render(
				"Hybrida - Styret",
				info.views.html.styret.render()));
	}
}
