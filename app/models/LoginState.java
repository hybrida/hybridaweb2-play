package models;


import play.db.ebean.Model;
import views.html.escapeText;
import views.html.layoutHtml;

/**
 * \brief Login state manager.
 *
 * Utilizes the login cookie to check for a valid state.
 */
public class LoginState extends Model {

    private static boolean isUserInDatabase(String username) {
        return User.find.where().eq("username", username).findUnique() != null;
    }

    private static boolean isUserTimeValid(String username, String usertime) {
        User user = User.find.where().eq("username", username).findUnique();
        Long usertime_int = Long.valueOf(usertime) + 1000L;
        if (user.getLastLoginTime() == null)
            return true;
        return user.getLastLoginTime().before(new java.util.Date(usertime_int));
    }

    public static boolean isValidlyLoggedIn() {
        String user = play.mvc.Controller.session("user");
        if (user != null) {
            String data[] = play.api.libs.Crypto.decryptAES(user).split(",");
            if (isUserInDatabase(data[0])) {
                if (isUserTimeValid(data[0], data[1])) {
                    //User.find.where().eq("username", data[0]).findUnique();
                    return true;
                }
            }
        }
        return false;
    }

    public static User getUser() {
        String user = play.mvc.Controller.session("user");
        if (user != null) {
            String data[] = play.api.libs.Crypto.decryptAES(user).split(",");
            if (isUserInDatabase(data[0])) {
                if (isUserTimeValid(data[0], data[1])) {
                    return User.find.where().eq("username", data[0]).findUnique();
                }
            }
        }
        return new User();
    }

}
