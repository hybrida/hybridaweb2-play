package sso;

import admintools.Admin;
import models.LoginState;
import play.Configuration;
import play.Play;
import profile.models.User;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.utils.escapeText;

import java.sql.Timestamp;
import java.util.Date;

/**
 * This class handles SSOLogins via Feide.
 *
 * How it works:
 * First we let control enter the "login(String)" function.
 * It checks if the certificate file is present.
 * If the certificate is not present, the login will occur as
 * the standard root user in dev mode, or it will return an internal server error
 * in any other mode.
 *
 * If the certificate is present, the user is redirected to innsida.ntnu.no
 * (see innsida_login_link for full link). The parameter "target" tells innsida
 * where to return to after a succesful login. The parameter "returnargs" is a
 * bounced-back parameters that will inform this server where to go.
 * The bounce-back is used so that login in from a specific page
 * returns you to that same page after having logged in.
 *
 * The logout function simply clears the cookies via session().clear() first,
 * it then redirects you to innsida's logout which will further invalidate
 * other cookies.
 *
 * verifyLogin works by looking at the current HTTP data and validating its
 * timestamp, encryption, and where the HTTP request originated from.
 * This function accesses the database to check if the returned username
 * actually exists there as well.
 * If the login is successful, verifyLogin stores the username with a timestamp.
 * It also encrypts the cookie with the last login time using a private key.
 *
 * The encryption's justification:
 * The login time is stored in the database. If anyone wishes to commit forgery
 * by creating a custom cookie, they will have a hard time doing so because they
 * will need to store unreadable text that must result in the form: "username, login_time"
 * This is extremely difficult to do as any change to the input should give big changes to the output
 * like a hashing algorithm.
 */
public class SSOLogin extends Controller {

	private static String target = Play.application().configuration().getString("ssologin.target"); // Get target from application.conf
	public static String getTarget() {
		return target != null ? target : "hybridaweb"; // Fallback to "hybridaweb" if no ssologin.target entry in conf
	}
	public static String innsida_login_link = "https://innsida.ntnu.no/sso/?target=" + getTarget() + "&returnargs=";

	public static Result login(String returnarg) throws Exception {
		if (!LoginState.rootExists()) Admin.importTestData();

		java.io.File file = new java.io.File(sso.models.Certificate.getPath());
		if (file.exists() && !file.isDirectory()) {
			// The following page will redirect us to verifylogin when it returns.
			return redirect(
				innsida_login_link + (
					returnarg == null || returnarg.length() == 0
					? request().path() : returnarg) + ",");
		} else if (Configuration.root().getString("application.env").equalsIgnoreCase("dev")){
			session("user", play.api.libs.Crypto.encryptAES("hybrid," + String.valueOf(System.currentTimeMillis())));
			return redirect(returnarg.length() == 0 ? request().path() : returnarg);
		} else {
			return ok("Cannot find certificate file");
		}
	}

	public static Result logout() {
		session().clear();
		return redirect("https://innsida.ntnu.no/c/portal/logout");
	}

	public static Result verifylogin() {
		try {
			sso.models.SSOData data = new sso.models.SSOData();
			try {
				String return_url = new models.HttpRequestData().get("returnargs");
				if(return_url.endsWith(",")) return_url = return_url.substring(0, return_url.length()-1); // Remove trailing comma bc beta-fix
				if (data.login()) {
					User user = User.find.where().eq("username", data.getLoginInfo().get("username")).findUnique();
					if (user != null) { // Check if user exists
						if (user.getLastLoginTime() == null || user.getLastLoginTime().before(new Timestamp(new Date(Integer.valueOf(data.getLoginInfo().get("time")) * 1000L).getTime()))) { // Check if the current user is logging in AFTER the last valid login.
						// System.out.println(data.getLoginInfo().get("username") + " has logged in.");
							user.setLastLoginTimeNow();
							user.save();
							user.saveToSession();
						}
					} else {
				// System.out.println("Username: " + data.getLoginInfo().get("username") + " does not exist in the database.");
						return redirect(contactforuser.routes.ContactForUser.index().url());
					}

					return redirect(return_url);
				} else {
					session().clear();
					return application.Application.showInternalServerError();
				}
			} catch (Exception exc_obj) {
				return ok(escapeText.render(exc_obj.toString()));
			}
		} catch (Exception exc_obj) {
			return internalServerError("Well damn, the SSOData failed.");
		}
	}

}

