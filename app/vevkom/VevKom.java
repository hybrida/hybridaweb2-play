package vevkom;

/**
 * Created by Jonas on 13.10.2015.
 */
public class VevKom extends play.mvc.Controller {
	public static play.mvc.Result index() {
		return ok(
			views.html.layoutWithHead.render(
				"Vevkom",
				vevkom.views.html.index.render(),
				vevkom.views.html.head.render()
			)
		);
	}
}
