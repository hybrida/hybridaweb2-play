package examples.controllers;

import examples.views.html.exampleCookies;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

import static play.data.Form.form;

/*
	This class shows how to use cookies.

	Cookies are stored as a map/dictionary ((key, value) pair).
	Cookies are stored by the client (normally in the browser).
	Cookies in Play! are automatically encrypted.
	Cookies are accessed via the "session()" function.
	This function is located in play.mvc.Http.Session.
	The cookie is sent when you return a result (together with the rest of the page).
	The client sends the cookie back to the server during each request.
*/
public class ExampleCookies extends Controller {
	
	public final static String counter_cookie_key = "cookie_count";

    public static String getSortedCookies() {
        String x = "<br><br> Here is a list of all cookies: <br>";
        java.util.Set<String> keys = session().keySet();
        java.util.Iterator<String> i = keys.iterator();
        while (i.hasNext()) {
            String u = i.next();
            x += u;
            x += " -> ";
            x += session(u) + "<br>";
        }
        return x;
    }

	public static Result index() {
		return ok(layout.render("hybrida", exampleCookies.render(play.twirl.api.Html.apply("You have " + getCookieCount() + " cookies. You can create or clear cookies here." + getSortedCookies()))));
	}

	public static void createCookie(String key) {
		session(key, "");
	}

	public static void eraseCookie(String key) {
		session().remove(key);
	}

	public static boolean doesCookieExist(String key) {
		return session(key) != null;
	}

	public static Result clearAllCookies() {
		session().clear();
		return ok(layout.render("hybrida", exampleCookies.render(play.twirl.api.Html.apply("You have " + getCookieCount() + " cookies. You can create or clear cookies here." + getSortedCookies()))));
	}

	public static void storeCookie(String key, String value) {
		session(key, value);
	}

	public static void incrementCookieCount() {
		if (doesCookieExist(counter_cookie_key)) {
			String amount = session(counter_cookie_key);
			Integer int_amount = Integer.valueOf(amount) + 1;
			session(counter_cookie_key, int_amount.toString());
		} else {
			session(counter_cookie_key, "1");
		}
	}

	public static String getCookieCount() {
		if (doesCookieExist(counter_cookie_key)) {
			return session(counter_cookie_key);
		} else {
			return "0";
		}
	}

}