package andreas;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;


public class Andreas extends Controller {

    public static Result index() {
        return ok(layout.render("Andreas", andreas.views.html.index.render()));
    }
}
