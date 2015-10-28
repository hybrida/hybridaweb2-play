package admin;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;
import play.twirl.api.Html;
import models.HttpRequestData;
import java.util.*;
import admin.models.PasswordHash;
import views.html.layoutBoxPage;

public class Admin extends Controller {
	public static Result index() {
		return ok(layoutBoxPage.render("Admin", admin.views.html.loginform.render(), null));
	}

	public static Result login() {
		try {
			HttpRequestData data = new HttpRequestData();
			String password = data.get("adminpass");
			String hash = "1000:273fad43db7f567593c84d7eab74256fb569d9328e21f938:02a4f3199ffc2c12389ca9bfb55a07f4692f180cc13083e0";
			boolean correct = PasswordHash.validatePassword(password, hash);
			if (correct) {
				session("user", play.api.libs.Crypto.encryptAES("hybrid," + String.valueOf(System.currentTimeMillis())));
				return redirect(admin.routes.Admin.allUsers());
			} else {
				return ok("password incorrect");
			}
		} catch (java.security.NoSuchAlgorithmException exc) {
			return ok(exc.toString());
		} catch (java.security.spec.InvalidKeySpecException exc) {
			return ok(exc.toString());
		}
	}

	public static Result logout() {
		session().remove("user");
		return redirect(application.routes.Application.index());
	}

	public static Result allUsers() {
		models.User loginuser = models.LoginState.getUser();
		if (!loginuser.isRoot()) {
			return redirect(application.routes.Application.showUnauthorizedAccess().url());
		} else {
			java.util.List<models.User> users = models.User.find.all();
			Collections.sort(users, new Comparator<models.User>() {
				@Override
				public int compare(final models.User lhs, models.User rhs)
				{
					return lhs.getUsername().compareTo(rhs.getUsername());
				}
			});
			String all_forms = "";
			for (models.User user : users) {
				Html gen = admin.views.html.UserForm.render(user.getUsername());
				all_forms += gen.toString();
			}
			Html table = admin.views.html.table.render(Html.apply(all_forms));
			all_forms += admin.views.html.NewForm.render().toString();
			Html html = Html.apply(all_forms);
			html = admin.views.html.table.render(html);
			return ok(layoutBoxPage.render("User Administration", html, null));
		}
	}

	public static Result newUser() {
		models.HttpRequestData data = new models.HttpRequestData();
		models.User user = new models.User();
		user.username = data.get("username");
		user.save();
		return redirect(admin.routes.Admin.allUsers());
	}

	public static Result updateUser() {
		return ok("Not implemented 1239543890127937");
	}
}
