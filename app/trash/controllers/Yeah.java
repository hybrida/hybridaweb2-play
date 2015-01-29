package trash.controllers;

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
        content.add("<iframe width=\"420\" height=\"315\" src=\"//www.youtube.com/embed/mznsEcZlM2I?rel=0&autoplay=1\" frameborder=\"0\" allowfullscreen></iframe>");
        return ok(layout.render("Hehehe", content));
    }
}
