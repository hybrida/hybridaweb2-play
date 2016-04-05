package staticpages;

import models.LoginState;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

/**
 * Created by Bendik on 28.10.2015.
 */
public class Statutter extends Controller {

	public static Result index() {
		if(!LoginState.isValidlyLoggedIn()) {return redirect(sso.routes.SSOLogin.login(play.mvc.Http.Context.current().request().path()));}
		else {
			return ok(
					views.html.layout.render(
							"Satutter",
							staticpages.views.html.statutter.render()
					)
			);
	}
	}
}