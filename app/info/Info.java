package info;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

/**
 * Created by Kia on 16.10.14.
 */
public class Info extends Controller {
	public static Result index() {
		return ok(views.html.layoutWithHead.render(
				"Om Hybrida",
				info.views.html.index.render(),
				info.views.html.head.render()));
	}

	public static Result styret() {
		return ok(layout.render(
				"Styret",
				info.views.html.styret.render()));
	}

	public static Result arrkom() {
		return ok(layout.render(
				"Arrangementkomitéen", info.views.html.arrkom.render()));
	}

	public static play.mvc.Result vevkom() {
		return ok(
				views.html.layoutWithHead.render(
						"Vevkom",
						info.views.html.vevkom.render(),
						info.views.html.vevkomHead.render()
				)
		);
	}

	public static play.mvc.Result bedkom() {
		return ok(
				views.html.layoutWithHead.render(
						"Bedkom",
						info.views.html.bedkomHead.render(),
						info.views.html.bedkomBody.render()
				)
		);
	}

	public static play.mvc.Result jentekom() {
		return ok(
				views.html.layoutWithHead.render(
						"Jentekom",
						info.views.html.jentekom.render(),
						info.views.html.jentekomHead.render()
				)
		);
	}

	public static Result redaksjonen() {
		return ok(
				views.html.layout.render(
						"Hybrida - Redaksjonen",
						info.views.html.redaksjonen.render()
				)
		);
	}
}
