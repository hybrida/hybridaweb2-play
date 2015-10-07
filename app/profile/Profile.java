package profile;

import application.Application;
import com.google.common.collect.Iterables;
import models.LoginState;
import models.User;
import play.data.Form;
import play.data.validation.ValidationError;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ivar on 21.10.2014.
 */
public class Profile extends Controller {

	public static void addMessage(Map<String, String> messages, String key, String content) {
        if(messages.containsKey(key)) messages.put(key, messages.get(key) + "<br>" + content);
        else messages.put(key, content);
	}

	public static Result index(String username) {
		User user = User.findByUsername(username);
		if (user == null) return notFound();
        return ok(profile.views.html.index.render(
                username,
                user.getName(),
                user.hasProfileImage() ? "uploads/" + user.getUsername() + "/" + user.getProfileImageFileName() : null,
                user,
                authorizedToEditUser(user.getUsername()),
                user.hasTitle() ? user.getTitle() : user.hasMiddleName() ? user.getFullName() : null
        ));
	}

	public static Result update(String username) {
		if (!authorizedToEditUser(username)) return unauthorized();
        User user = User.findByUsername(username);
        if (user == null) return notFound();

        Form<User> form = Form.form(User.class).fill(user).bindFromRequest("email", "website_url", "phone",
                "gender", "profile_image_file_name");

        HashMap<String, String> messages = new HashMap<>();
        Map<String, String> errors = null;
        try {
            errors = User.validateForm(form);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(errors != null && errors.size() > 0) {
            for(Map.Entry<String, String> error : errors.entrySet()) {
                addMessage(messages, error.getKey(), error.getValue());
            }
        }
        if(messages.size() > 0) return ok(profile.views.html.edit.render(
                username,
                user.getName(),
                user.hasProfileImage() ? "uploads/" + user.getUsername() + "/" + user.getProfileImageFileName() : null,
                form,
                messages
        ));

        user.updateFromForm(form);
        return redirect(routes.Profile.index(username));
	}

	public static boolean authorizedToEditUser(String username) {
		User loggedInUser = LoginState.getUser();
		return loggedInUser != null && (username.equals(loggedInUser.getUsername()) || loggedInUser.hasAccess(false, User.Access.ADMIN));
    }

    public static Result edit(String username) {
        if (!authorizedToEditUser(username)) return redirect(routes.Profile.index(username));
        User user = User.findByUsername(username);
        if (user == null) return notFound(request().uri());
        return ok(profile.views.html.edit.render(
                username,
                user.getName(),
                user.hasProfileImage() ? "uploads/" + user.getUsername() + "/" + user.getProfileImageFileName() : null,
                Form.form(User.class).fill(user),
                new HashMap<String, String>()
        ));
	}
}
