package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

import java.util.ArrayList;

/**
 * Created by Yeah on 06.09.2014.
 */
public class Yeah extends Controller {
    public static Result index() {
        ArrayList<String> content = new ArrayList<>();
        content.add("Yeah buddy");
        return ok(layout.render("Hehehe", content));
    }
}
