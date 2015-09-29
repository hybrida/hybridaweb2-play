package nomination;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layoutWithHead;


/**
 * Created by Torsten on 22.09.15
 */
public class Nomination extends Controller {
    final static public Result index() {  return ok(layoutWithHead.render(
                                                            "Griffens Orden Nominasjon",
                                                             nomination.views.html.nominasjonbody.render(),
                                                             nomination.views.html.griffensOrdenhead.render()));
    }
}