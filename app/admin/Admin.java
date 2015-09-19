package admin;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;
import models.HttpRequestData;
import models.PasswordHash;

public class Admin extends Controller {
	public static Result index() {
		return ok(layout.render("Admin", admin.views.html.loginform.render()));
	}

	public static Result login() {
		try {
			HttpRequestData data = new HttpRequestData();
			String password = data.get("adminpass");
			String hash = "1000:273fad43db7f567593c84d7eab74256fb569d9328e21f938:02a4f3199ffc2c12389ca9bfb55a07f4692f180cc13083e0";
			boolean correct = PasswordHash.validatePassword(password, hash);
			if (correct) {
				session("user", play.api.libs.Crypto.encryptAES("hybrid," + String.valueOf(System.currentTimeMillis())));
				return redirect(application.routes.Application.index());
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
		session("user", "");
		return redirect(application.routes.Application.index());
	}
}
