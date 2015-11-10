package contactforuser;

import play.mvc.Controller;
import play.mvc.Result;

public class ContactForUser extends Controller {
	public static Result index() {
		return ok(views.html.layoutBoxPage.render(
			"Kontakt oss",
			contactforuser.views.html.index.render()));
	}
}
