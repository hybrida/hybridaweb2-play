package hellome;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

/**
 * Created by Bendik on 13.09.2015.
 */
public class Hellome extends Controller {

    public static Result index(){return ok(layout.render("Hello ME", hellome.views.html.index.render()));}
}
