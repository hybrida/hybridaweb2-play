package controllers;

import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layoutHtml;
import views.html.profile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ivar on 21.10.2014.
 */
public class Profile extends Controller {
    public static Result index(String username) throws ParseException {
        User user = User.find.where().eq("username", username).findUnique();
        if(user == null) {
            return redirect("show404");
        }
        return ok(layoutHtml.render(user.getName(), profile.render(user)));
    }
}