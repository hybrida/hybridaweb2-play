package controllers;

import models.User;
import play.mvc.Controller;
import java.io.File;
import java.util.Date;
import java.sql.Timestamp;
import views.html.*;
import play.mvc.Result;

public class ExampleSSO extends Controller {

    public static String innsida_login_link = "https://innsida.ntnu.no/sso/?target=hybridawebtest&returnargs=";

    public static Result login(String returnarg) {
        File file = new File(models.Certificate.getPath());
        if(file.exists() && !file.isDirectory()) {
            return redirect(innsida_login_link + (returnarg.length() == 0 ? request().path() : returnarg));
        } else {
            session("user", play.api.libs.Crypto.encryptAES("su," + String.valueOf(System.currentTimeMillis())));
            return redirect(returnarg.length() == 0 ? request().path() : returnarg);
        }
    }

    public static Result verifylogin() {
        try {
            models.SSOData data = new models.SSOData();
            try {
                String return_url = new models.HttpRequestData().get("returnargs");
                if (data.login()) {
                    User user = User.find.where().eq("username", data.getLoginInfo().get("username")).findUnique();
                    if (user != null) { // Check if user exists
                        if (user.getLastLoginTime() != null ? user.getLastLoginTime().before(new Timestamp(new Date(Integer.valueOf(data.getLoginInfo().get("time")) * 1000L).getTime())) : true) { // Check if the current user is logging in AFTER the last valid login.
                            System.out.println(data.getLoginInfo().get("username") + " has logged in.");
                            user.setLastLoginTimeNow();
                            user.save();
                            session("user", play.api.libs.Crypto.encryptAES(data.getLoginInfo().get("username") + "," + String.valueOf(System.currentTimeMillis())));
                        }
                    } else {
                        System.out.println("Username: " + data.getLoginInfo().get("username") + " does not exist in the database.");
                    }

                    return redirect(return_url);
                }
                else {
                    session().clear();
                    return redirect(routes.Application.index().url());
                }
            } catch (Exception exc_obj) {
                return ok(escapeText.render(exc_obj.toString()));
            }
        } catch (Exception exc_obj) {
            return ok("Well damn the SSOData failed.");
        }
    }
}

