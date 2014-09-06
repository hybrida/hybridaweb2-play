package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

import java.util.ArrayList;

/**
 * Created by Ivar on 06.09.2014.
 */
public class Ivar extends Controller {
    public static Result index() {
        ArrayList<String> content = new ArrayList<>();
        content.add("Yeah buddy");
        return ok(layout.render("Hehehe", content));
    }
}
