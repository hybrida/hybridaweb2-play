package staticpages;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;
import views.html.layoutWithHead;

/**
 * Created by Kia on 16.10.14.
 */
public class About extends Controller {
	public static Result index() {
		return ok(
				layoutWithHead.render(
						"Om Hybrida",
						staticpages.views.html.index.render(),
						staticpages.views.html.indexHead.render()
				)
		);
	}

	public static Result styret() {
		return ok(
				layout.render(
						"Styret",
						staticpages.views.html.styret.render()
				)
		);
	}

	public static Result arrkom() {
		return ok(
				layoutWithHead.render(
						"Arrangementkomitéen",
						staticpages.views.html.arrkom.render(),
						staticpages.views.html.staticPageHead.render()
				)
		);
	}

	public static Result vevkom() {
		return ok(
				layoutWithHead.render(
						"Vevkom",
						staticpages.views.html.vevkom.render(),
						staticpages.views.html.staticPageHead.render()
				)
		);
	}

	public static Result bedkom() {
		return ok(
				layoutWithHead.render(
						"Bedkom",
						staticpages.views.html.bedkom.render(),
						staticpages.views.html.staticPageHead.render()
				)
		);
	}

	public static Result jentekom() {
		return ok(
				layoutWithHead.render(
						"Jentekom",
						staticpages.views.html.jentekom.render(),
						staticpages.views.html.staticPageHead.render()
				)
		);
	}

	public static Result redaksjonen() {
		return ok(
				layout.render(
						"Redaksjonen",
						staticpages.views.html.redaksjonen.render()
				)
		);
	}

	public static Result newStudent() {
		return ok(layoutWithHead.render(
				"Hybrida - Ny student",
				staticpages.views.html.newStudentHead.render(),
				staticpages.views.html.newStudent.render()));
	}
}
