package controllers;

import models.LoginState;
import models.User;
import play.data.Form;
import play.data.validation.ValidationError;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;
import views.html.layoutWithHead;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Ivar on 21.10.2014.
 */
public class Profile extends Controller {

    final static Form<User> userForm = Form.form(User.class);

    public static ArrayList<Html> messages = new ArrayList<>();
    public static Html message(boolean error, String content) {
        return views.html.Profile.message.render(error, content);
    }

    public static Result index(String username) {

        User user = User.find.where().eq("username", username).findUnique();
        if(user == null) {
            return Application.show404(request().path());
        }
        return ok(layoutWithHead.render(user.getName(), views.html.Profile.index.render(user, authorizedToEditUser(username), messages), views.html.Profile.head.render()));
    }

    public static Result update(String username) {
        if (!authorizedToEditUser(username)) return Application.showUnauthorizedAccess();
        if (User.find.where().eq("username", username).findRowCount() == 0) return Application.show404(request().path());
        Form<User> filledForm =  userForm.bindFromRequest();

        messages = new ArrayList<>();
        if(filledForm.hasErrors()) {
            Map<String, List<ValidationError>> errors = filledForm.errors();
            for(String key : errors.keySet()) {
                messages.add(message(true, key + ": " + errors.get(key).toString()));
            }
        } else {
            long userId = User.find.where().eq("username", username).findUnique().getId();
            filledForm.get().update(userId);
            messages.add(message(false, "Din brukerinformasjon er oppdatert!"));
            messages.add(message(true, "Din brukerinformasjon er oppdatert!"));
            messages.add(message(false, "Din brukerinformasjon er oppdatert!"));
            messages.add(message(true, "Din brukerinformasjon er oppdatert!"));
            messages.add(message(true, "Din brukerinformasjon er oppdatert!"));
        }
        return index(username);
    }

    public static boolean authorizedToEditUser(String username) {
        User loggedInUser = LoginState.getUser();
        return username.equals(loggedInUser.getUsername()) || loggedInUser.admin || !loggedInUser.root;
    }

    public static Result edit(String username) {
        if (!authorizedToEditUser(username)) return Application.showUnauthorizedAccess();
        User user = User.find.where().eq("username", username).findUnique();
        if (user == null) return Application.show404(request().path());
        messages = new ArrayList<>();
        userForm.fill(user);
        return ok(layoutWithHead.render("Rediger " + user.getName(), views.html.Profile.edit.render(user, messages), views.html.Profile.head.render()));
    }
}