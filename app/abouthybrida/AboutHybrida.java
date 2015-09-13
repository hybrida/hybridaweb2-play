package abouthybrida;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

/**
 * Created by Kia on 16.10.14.
 */
public class AboutHybrida extends Controller {
	final static public Result index() {
		return ok(layout.render(
			"",
			abouthybrida.views.html.index.render()));
	}
}
