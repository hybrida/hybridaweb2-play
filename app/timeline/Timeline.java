package timeline;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Kia on 02.02.16.
 */

/** link til kode: http://codepen.io/anon/pen/eJjPGV **/

public class Timeline extends Controller {

        final static public Result index() {
            return ok(views.html.layout.render(
                    "Timeline Hybrida",
                    timeline.views.html.index.render()));

        }

}