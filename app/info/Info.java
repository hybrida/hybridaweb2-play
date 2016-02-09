package info;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;
import views.html.layoutWithHead;

/**
 * Created by Kia on 16.10.14.
 */
public class Info extends Controller {
	public static Result index() {
		return ok(
				layoutWithHead.render(
						"Om Hybrida",
						info.views.html.index.render(),
						info.views.html.head.render()
				)
		);
	}

	public static Result styret() {
		return ok(
				layout.render(
						"Styret",
						info.views.html.styret.render()
				)
		);
	}

	public static Result arrkom() {
		return ok(
				layoutWithHead.render(
						"Arrangementkomitéen",
						info.views.html.arrkom.render(),
						info.views.html.staticpageHead.render()
				)
		);
	}

	public static play.mvc.Result vevkom() {
		return ok(
				layoutWithHead.render(
						"Vevkom",
						info.views.html.vevkom.render(),
						info.views.html.staticpageHead.render()
				)
		);
	}

	public static play.mvc.Result bedkom() {
		return ok(
				layoutWithHead.render(
						"Bedkom",
						info.views.html.bedkom.render(),
						info.views.html.staticpageHead.render()
				)
		);
	}

	public static play.mvc.Result jentekom() {
		return ok(
				layoutWithHead.render(
						"Jentekom",
						info.views.html.jentekom.render(),
						info.views.html.staticpageHead.render()
				)
		);
	}

	public static Result redaksjonen() {
		return ok(
				layout.render(
						"Redaksjonen",
						info.views.html.redaksjonen.render()
				)
		);
	}
}
