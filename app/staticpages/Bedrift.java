package staticpages;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;
import views.html.layoutWithHead;

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
