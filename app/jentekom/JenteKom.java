package jentekom;

/**
 * Created by Jonas on 13.10.2015.
 */
public class JenteKom extends play.mvc.Controller {
	public static play.mvc.Result index() {
		return ok(
			views.html.layoutWithHead.render(
				"JenteKom",
				jentekom.views.html.index.render(),
				jentekom.views.html.head.render()
			)
		);
	}
}
