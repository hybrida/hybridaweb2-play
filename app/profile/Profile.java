package profile;

import models.LoginState;
import profile.models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ivar on 21.10.2014.
 */
public class Profile extends Controller {

	private static void addMessage(Map<String, String> messages, String key, String content) {
		if(messages.containsKey(key)) messages.put(key, messages.get(key) + "<br>" + content);
		else messages.put(key, content);
	}

	private static boolean authorizedToEditUser(String username) {
		User loggedInUser = LoginState.getUser();
		return loggedInUser != null && (username.equals(loggedInUser.getUsername())
			|| loggedInUser.isAdmin());
	}

	public static Result index(String username) {
		User user = User.findByUsername(username);
		if (user == null) return application.Application.showNotFound();
			return ok(views.html.layoutWithHead.render(
					"Hybrida - " + user.getName(),
					profile.views.html.index.render(
							username,
							user.getName(),
							user.hasProfileImage() ? "uploads/" + user.getUsername() + "/" + user.getProfileImageFileName() : null,
							user,
							authorizedToEditUser(user.getUsername()),
							user.hasTitle() ? user.getTitle() : user.hasMiddleName() ? user.getFullName() : null
					),
					profile.views.html.indexHead.render()
			));
	}

	private static Result showEdit(String username, User user, Form<User> form, HashMap<String, String> messages) {
		return ok(views.html.layoutWithHead.render(
				user.getName(),
				profile.views.html.edit.render(
						username,
						user.getName(),
						user.hasProfileImage() ? "uploads/" + user.getUsername() + "/" + user.getProfileImageFileName() : null,
						form,
						messages
				),
				profile.views.html.editHead.render(username)
		));
	}

	public static Result update(String username) {
		if (!authorizedToEditUser(username)) return application.Application.showUnauthorizedAccess();
		User user = User.findByUsername(username);
		if (user == null) return application.Application.show404(request().uri());

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
		if(messages.size() > 0) return showEdit(username, user, form, messages);

		user.updateFromForm(form);
		return redirect(routes.Profile.index(username));
	}

	public static Result edit(String username) {
		if (!authorizedToEditUser(username)) return redirect(routes.Profile.index(username));
		User user = User.findByUsername(username);
		if (user == null) return application.Application.showNotFound();
		return showEdit(username, user, Form.form(User.class).fill(user), new HashMap<String, String>());
	}
}
