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

    public static Result editUserData() {
        models.HttpRequestData data = new models.HttpRequestData();
        if (LoginState.getUser().username == data.get("username")) {
            User user = LoginState.getUser();
            
            user.first_name = data.get("first_name");
            user.surname = data.get("surname");
            user.middle_name = data.get("middle_name");
            user.email = data.get("email");
            user.website_url = data.get("website_url");
            user.phone = data.get("phone");
            user.title = data.get("title"); // Ph.D., Civ.Eng., Stud., Chief, Commander, General, Lord, Admiral, Vevsjef,...
            user.profile_image_file_name = data.get("profile_image_file_name");
            //  int         graduation_year = 0;

            // Privilege status
            /*user.student = data.get("student") == "true" ? true : false;    // No special privileges.
            user.bedkom = data.get("bedkom") == "true" ? true : false;     // Control over bedpress.
            
            user.admin = data.get("admin") == "true" ? true : false;      // For control over the entire page. Check your privilege
            user.root = data.get("root") == "true" ? true : false;       // Powers too great for mere mortals.
            user.sex = data.get("sex") == "true" ? true : false;         // For specific events.

            user.enrolled = data.get("enrolled");    // For specific bedpresses requiring a year number.
            user.date_of_birth = data.get("date_of_birth");
            */
            user.save();
        }
        return ok();
    }

    public static boolean authorized(String username) {
        User loggedInUser = LoginState.getUser();
        return username.equals(loggedInUser.getUsername()) || loggedInUser.admin || !loggedInUser.root;
    }

    public static Result edit(String username) {
        if (!authorized(username)) return Application.showUnauthorizedAccess();
        User user = User.find.where().eq("username", username).findUnique();
        if (user == null) return Application.show404("profil/" + username + "/edit");
        userForm.fill(user);
        return ok(layoutHtml.render("Rediger " + user.getName(), profileEdit.render(user)));
    }

    public static Result submit() {
        User user = userForm.bindFromRequest().get();
        if (!authorized(user.getUsername())) return Application.showUnauthorizedAccess();
        user.update();
        return redirect(routes.Profile.edit(user.getUsername()));
    }
}