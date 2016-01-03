package iktringen;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Andreas on 13/10/2015.
 */
public class IKTringen extends Controller {
    final static public Result index() {
        return ok(views.html.layoutWithHead.render(
                "I&IKT-Ringen",
                iktringen.views.html.index.render(),
                iktringen.views.html.head.render()));
    }
}
