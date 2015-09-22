package arrkom;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

/**
 * Created by Bendik on 22.09.2015.
 */
public class ArrKom extends Controller {

    public static Result index() {
        return ok(layout.render("Arrangement komiteen", arrkom.views.html.index.render()));
    }
}
