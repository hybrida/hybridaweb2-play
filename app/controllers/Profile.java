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
        if(User.find.where().eq("username", "ivarhk").findUnique() == null) {
            new User("ivarhk",
                    "Ivar",
                    "Kråbøl",
                    "\"Touchpad\"",
                    "ivarhk@gmail.com",
                    null,
                    "48 26 45 19",
                    null,
                    2018,
                    "ivar.jpg",
                    true,
                    false,
                    true,
                    false,
                    'm',
                    new SimpleDateFormat("m/yyyy").parse("8/2013"),
                    new SimpleDateFormat("d/m/yyyy").parse("20/10/1992")).save();
        }

        User user = User.find.where().eq("username", "ivarhk").findUnique();
        return ok(layoutHtml.render(user.getName(), profile.render(user)));
    }
}