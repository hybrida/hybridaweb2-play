package strikk;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

/**
 * Created by Kia on 26.01.16.
 */

public class HybridaStrikk extends Controller{
        final static public Result index() {
            return ok(layout.render(
                    "",
                    strikk.views.html.strikk.render()));
        }

}
