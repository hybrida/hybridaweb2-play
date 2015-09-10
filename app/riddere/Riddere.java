package riddere;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layoutWithHead;

/**
 * Created by Torsten on a tuesday
 */
public class Riddere extends Controller {
	final static public Result index() {
		return ok(
			layoutWithHead.render(
				"Griffens Orden",
				riddere.views.html.Ridderebody.render(),
				views.html.griffensOrdenhead.render()
			)
		);
	}
}
