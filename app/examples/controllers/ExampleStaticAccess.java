package examples.controllers;

import models.LoginState;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layoutBoxPage;

/**
 * Created by ivar on 28.10.2015.
 */
public class ExampleStaticAccess extends Controller {

    static public Result index() {
        if(!LoginState.isValidlyLoggedIn()) return redirect(sso.routes.SSOLogin.login(request().path()));
        if(!LoginState.getUser().loggedInUserHasAccess(true, User.Access.ADMIN)) return application.Application.showUnauthorizedAccess();
        return ok(layoutBoxPage.render(
                "Example Access",
                examples.views.html.exampleStaticAccess.render()));
    }
}
