package elg;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;


/**
 * Created by TrulsElg on 13/09/15.
 */
public class Elg extends Controller {

    public static Result index() {
        return ok(layout.render("Elg", elg.views.html.index.render()));
    }
}
