package models;


import play.db.ebean.Model;
import play.api.libs.Crypto;
import java.util.Date;
import play.mvc.Controller;
import profile.models.User;

/**
 * \brief Login state manager.
 *
 * Utilizes the login cookie to check for a valid state.
 */
public class LoginState extends Model {

	private static boolean isUserInDatabase(String username) {
		return User.findByUsername(username) != null;
	}

	private static boolean isUserTimeValid(String username, String usertime) {
		User user = User.findByUsername(username);
		Long usertime_int = Long.valueOf(usertime) + 1000L;
		if (user.getLastLoginTime() == null)
			return true;
		return user.getLastLoginTime().before(new Date(usertime_int));
	}

	public static boolean isValidlyLoggedIn() {
		String user = play.mvc.Controller.session("user");
		if (user != null) {
			String data[] = Crypto.decryptAES(user).split(",");
			if (isUserInDatabase(data[0])) {
				if (isUserTimeValid(data[0], data[1])) {
					return true;
				}
			}
		}
		return false;
	}

	public static User getUser() {
		String user = Controller.session("user");
		if (user != null) {
			String data[] = Crypto.decryptAES(user).split(",");
			if (isUserInDatabase(data[0])) {
				if (isUserTimeValid(data[0], data[1])) {
					return User.find.where().eq("username", data[0]).findUnique();
				}
			}
		}
		return new User();
	}

	public static boolean rootExists() {
		return isUserInDatabase("hybrid");
	}

}
