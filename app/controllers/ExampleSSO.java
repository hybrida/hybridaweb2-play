package controllers;

import play.mvc.Controller;
import play.mvc.Http;
import views.html.*;
import play.mvc.Result;

public class ExampleSSO extends Controller {

    public static String innsida_login_link = "https://innsida.ntnu.no/sso/?target=hybridawebtest&returnargs=";

    public static Result login(String returnarg) {
        return redirect(innsida_login_link + (returnarg.length() == 0 ? request().path() : returnarg));
    }

    public static Result verifylogin() {
        models.SSOData data = new models.SSOData();

        try {
            String return_url = new models.HttpRequestData().get("returnargs");
            if (data.login()) {

                /// TODO HERE:
                /**
                 * 1. We know now that the data is sound and valid. The next thing to do is to check if the
                 * given username is in the database, and that it is possible to set it to "logged in".
                 * The reason for this extra security is to avoid having sneaky packet duplicators
                 * logging in to multiple accounts simultaneously.
                 * PROBLEM: If a user disconnects/clears cookies he will not be able to login again,...
                 *
                 * 2. Generate a salty cookie encrypted with at least 256 bit AES containing the username.
                 * The cookie must use the "time" given in the SSO request header. This allows each login to give a uniquely
                 * salted and encrypted username. Thus; no one can ever duplicate a header or cookie.
                 *
                 * 3. Generate correct code for each page's login button as to redirect you to that specific page.
                 * In addition; we must put code here reading from "returnargs".
                 *
                 * 4. Put code in the else clause notifying the user has failed to log in correctly.
                 */

                System.out.println(data.getLoginInfo().get("username"));
                return redirect(return_url);
            }
            else {
                session().clear();
                return redirect(routes.Application.index().url());
            }
        } catch (Exception exc_obj) {
            return ok(escapeText.render(exc_obj.toString()));
        }
    }
}

