package redaksjonen;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by ivar on 15.11.2015.
 */
public class Redaksjonen extends Controller {
	public static Result index() {
		return ok(views.html.layout.render("Hybrida - Redaksjonen", redaksjonen.views.html.index.render()));
	}
}
