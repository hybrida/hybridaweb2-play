package newstudent;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layoutWithHead;

//TODO: Move to staticpages
/**
 * Created by Torsten on
 */
public class NewStudent extends Controller {
	final static public Result index() {
		return ok(layoutWithHead.render(
			"Hybrida - Ny student",
			newstudent.views.html.NyStudentHead.render(),
			newstudent.views.html.NyStudentBody.render()));
	}
}
