package styret;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

/**
 * Created by Kia on 30.09.14.
 */
public class Styret extends Controller {
		final static public Result index() {
		return ok(layout.render(
			"",
			styret.views.html.index.render()));
	}
}
