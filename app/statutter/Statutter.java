package statutter;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

/**
 * Created by Bendik on 28.10.2015.
 */
public class Statutter extends Controller {

    public static Result index() {
        return ok(layout.render("Statutter", statutter.views.html.statutter.render()));
    }
}
