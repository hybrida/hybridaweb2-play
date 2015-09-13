package newstudent;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layoutWithHead;

/**
 * Created by Torsten on
 */
public class NewStudent extends Controller {
	final static public Result index() {
		return ok(layoutWithHead.render(
			"",
			newstudent.views.html.NyStudentHead.render(),
			newstudent.views.html.NyStudentBody.render()));
	}
}
