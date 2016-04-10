package examples.controllers;

import models.LoginState;
import profile.models.User;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layoutBoxPage;

public class ExampleStaticAccess extends Controller {

    static public Result index() {
        if(!LoginState.isValidlyLoggedIn()) return redirect(sso.routes.SSOLogin.login(""));
        if(!User.loggedInUserHasAccess(true, User.Access.ADMIN)) return application.Application.showUnauthorizedAccess();
        return ok(layoutBoxPage.render(
                "Example Access",
                examples.views.html.exampleStaticAccess.render()));
    }
}
