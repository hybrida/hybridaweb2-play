package contactforuser;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

public class ContactForUser extends Controller {
	public static Result index() {
		return ok(layout.render(
			"Kontakt oss",
			contactforuser.views.html.index.render()));
	}
}
