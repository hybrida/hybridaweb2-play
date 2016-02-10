package staticpages;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;
import views.html.layoutWithHead;

/**
 * Created by Ivar on 10.02.2016.
 */
public class Bedrift extends Controller {
	public static Result index() {
		return ok(
				layoutWithHead.render(
						"Bedrift",
						staticpages.views.html.bedrift.render(),
						staticpages.views.html.staticPageHead.render()
				)
		);
	}
}
