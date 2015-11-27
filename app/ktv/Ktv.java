package ktv;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

/**
 * Created by Bendik on 22.09.2015.
 */
public class Ktv extends Controller {

    public static Result index() {return ok(layout.render("KTV", ktv.views.html.ktv.render()));
    }
}
