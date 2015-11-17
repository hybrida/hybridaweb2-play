package admin;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;
import play.twirl.api.Html;
import models.HttpRequestData;
import java.util.*;
import admin.models.PasswordHash;
import views.html.layoutBoxPage;
import admin.views.html.*;
import admin.models.RingNumber;

public class Admin extends Controller {
	public static Result index() {
		return ok(layoutBoxPage.render("Admin", admin.views.html.loginform.render()));
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
			String formheads = "";
			for (models.User user : users) {
				formheads += formHead.render(
					user.getId()).toString();
			}
			formheads += formHeadNew.render().toString();
			RingNumber period = new RingNumber(10);
			for (models.User user : users) {
				Html gen = userForm.render(
					user, period.inc() == 1, user.getId());
				all_forms += gen.toString();
			}
			all_forms = newForm.render().toString() + all_forms;
			Html html = Html.apply(formheads + all_forms);
			html = table.render(html);
			return ok(layoutBoxPage.render("User Administration", html));
		}
	}

	public static Result editUser(String uid) {
		models.User loginuser = models.LoginState.getUser();
		if (!loginuser.isRoot()) {
			return redirect(application.routes.Application.showUnauthorizedAccess().url());
		}
		if (HttpRequestData.isGiven("delete")) {
			models.User toRemove = models.User.find.byId(Long.parseLong(uid));
			if (toRemove != null) {
				toRemove.delete();
			}
			return redirect(admin.routes.Admin.allUsers());
		} else {
			models.User change = models.User.getUserFromForm();
			change.setId(Long.parseLong(uid));
			change.update();
			return redirect(admin.routes.Admin.allUsers());
		}
	}

	public static Result newUser() {
		models.User loginuser = models.LoginState.getUser();
		if (!loginuser.isRoot()) {
			return redirect(application.routes.Application.showUnauthorizedAccess().url());
		}
		models.User user = models.User.getUserFromForm();
		user.save();
		return redirect(admin.routes.Admin.allUsers());
	}

	public static Result updateUser() {
		return ok("Not implemented 1239543890127937");
	}
}
