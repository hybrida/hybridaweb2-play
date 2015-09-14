package profile;

import models.LoginState;
import models.User;
import play.data.Form;
import play.data.validation.ValidationError;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;
import profile.views.html.layoutPage;
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
		return profile.views.html.message.render(error, content);
	}

	public static Result index(String username) {
		User user = User.find.where().eq("username", username).findUnique();
		if (user == null) {
			return application.Application.show404(request().path());
		}
		return ok(render(username, user, false));
	}

	public static Result update(String username) {
		if (!authorizedToEditUser(username)) return application.Application.showUnauthorizedAccess();
		if (User.find.where().eq("username", username).findRowCount() == 0)
			return application.Application.show404(request().path());
		Form<User> filledForm = userForm.bindFromRequest();

		messages = new ArrayList<>();
		if (filledForm.hasErrors()) {
			Map<String, List<ValidationError>> errors = filledForm.errors();
			for (String key : errors.keySet()) {
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
		return username.equals(loggedInUser.getUsername()) || loggedInUser.admin || loggedInUser.root;
	}

	public static Result edit(String username) {
		if (!authorizedToEditUser(username)) return application.Application.showUnauthorizedAccess();
		User user = User.find.where().eq("username", username).findUnique();
		if (user == null) return application.Application.show404(request().path());
		messages = new ArrayList<>();
		userForm.fill(user);
		return ok(render(username, user, true));
	}

	public static Html render(String username, User user, boolean edit) {
		return layoutPage.render(
			user.getName(),
			profile.views.html.edit.render(user, messages, edit),
			profile.views.html.head.render(),
			user.hasMiddleName() ? user.getName(true) : null,
			user.hasProfileImage() ? "upload/" + username + "/" + user.getProfileImageFileName() : null,
			profile.views.html.subNavButtons.render(username, edit),
			edit ? profile.routes.Profile.index(username).url()  : null
		);
	}
}
