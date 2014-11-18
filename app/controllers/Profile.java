package controllers;

import models.LoginState;
import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layoutHtml;
import views.html.profile;
import views.html.profileEdit;

/**
 * Created by Ivar on 21.10.2014.
 */
public class Profile extends Controller {

    final static Form<User> userForm = Form.form(User.class);

    public static Result index(String username) {
        User user = User.find.where().eq("username", username).findUnique();
        if(user == null) {
            return Application.show404("profil/" + username);
        }
        return ok(layoutHtml.render(user.getName(), profile.render(user)));
    }

    public static boolean authorized(String username) {
        User loggedInUser = LoginState.getUser();
        return username == loggedInUser.getUsername() || loggedInUser.admin || !loggedInUser.root;
    }

    public static Result edit(String username) {
        if (!authorized(username)) return Application.showUnauthorizedAccess();
        User user = User.find.where().eq("username", username).findUnique();
        if (user == null) return Application.show404("profil/" + username + "/edit");
        userForm.fill(user);
        return ok(layoutHtml.render("Rediger "+user.getName(), profileEdit.render(userForm)));
    }

    public static Result submit() {
        User user = userForm.bindFromRequest().get();
        if (!authorized(user.getUsername())) return Application.showUnauthorizedAccess();
        user.update();
        return redirect(routes.Profile.edit(user.getUsername()));
    }
}