package profile;

import models.LoginState;
import models.User;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Ivar on 21.10.2014.
 */
public class Profile extends Controller {

	final static Form<User> userForm = Form.form(User.class);

	public static ArrayList<Html> messages = new ArrayList<>();

//	public static Html message(boolean error, String content) {
//		return profile.views.html.message.render(error, content);
//	}

	public static Result index(String username) {
		User user = User.findByUsername(username);
		if (user == null) return notFound();
		return ok(render(user, false));
	}

	public static Result update(String username) {
		if (!authorizedToEditUser(username)) return unauthorized();
        User user = User.findByUsername(username);
        if (user == null) return notFound();

        Form<User> filledForm = userForm.fill(user).bindFromRequest("email", "website_url", "phone", "gender", "profile_image_file_name");
        user.updateFromForm(filledForm);

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
		messages = new ArrayList<>();
		userForm.fill(user);
		return ok(render(user, true));
	}

	public static Html render(User user, boolean edit) {
		return profile.views.html.index.render(
			user,
			edit,
			messages,
			user.hasMiddleName() ? user.getName(true) : null,
			user.hasProfileImage() ? "upload/" + user.getUsername() + "/" + user.getProfileImageFileName() : null
		);
	}
}
