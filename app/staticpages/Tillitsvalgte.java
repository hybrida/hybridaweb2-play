package staticpages;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

//TODO: Move to staticpages

/**
 * Created by Bendik on 22.09.2015.
 */
public class Tillitsvalgte extends Controller {

    public static Result index() {return ok(layout.render("Tillitsvalgte", staticpages.views.html.tillitsvalgte.render()));
    }
}