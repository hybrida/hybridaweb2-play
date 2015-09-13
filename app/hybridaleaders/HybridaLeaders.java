package hybridaleaders;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

/**
 * Created by Kia on 30.09.14.
 */
public class HybridaLeaders extends Controller {
		final static public Result index() {
		return ok(layout.render(
			"",
			hybridaleaders.views.html.index.render()));
	}
}
