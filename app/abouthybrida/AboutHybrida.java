package abouthybrida;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Kia on 16.10.14.
 */
public class AboutHybrida extends Controller {
	final static public Result index() {
		return ok(views.html.layoutWithHead.render(
				"Hybrida - Om Hybrida",
				abouthybrida.views.html.index.render(),
				abouthybrida.views.html.head.render()));
	}
}
