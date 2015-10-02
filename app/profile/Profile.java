package profile;

import com.google.common.collect.Iterables;
import models.LoginState;
import models.User;
import play.data.Form;
import play.data.validation.ValidationError;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ivar on 21.10.2014.
 */
public class Profile extends Controller {

	public static void addMessage(Map<String, Html> messages, String key, boolean error, String content) {
        Html message = profile.views.html.message.render(true, content);
        if(messages.containsKey(key)) messages.put(key, Html.apply(messages.get(key).text() + "\n" + message.text()));
        else messages.put(key, message);
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

        HashMap<String, Html> messages = new HashMap<>();
        Map<String, String> errors = User.validateForm(form);
        if(errors != null && errors.size() > 0) {
            for(Map.Entry<String, String> error : errors.entrySet()) {
                addMessage(messages, error.getKey(), true, error.getValue());
            }
        }
        if(form.hasErrors()) {
            for(ValidationError error : Iterables.concat(form.errors().values())) {
                addMessage(messages, error.key(), true, error.message());
            }
            System.out.println(messages);
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
		return username.equals(loggedInUser.getUsername()) || loggedInUser.admin || loggedInUser.root;
    }

    public static Result edit(String username) {
        if (!authorizedToEditUser(username)) return unauthorized();
        User user = User.findByUsername(username);
        if (user == null) return notFound(request().uri());
        return ok(profile.views.html.edit.render(
                username,
                user.getName(),
                user.hasProfileImage() ? "uploads/" + user.getUsername() + "/" + user.getProfileImageFileName() : null,
                Form.form(User.class).fill(user),
                new HashMap<String, Html>()
        ));
	}
}
