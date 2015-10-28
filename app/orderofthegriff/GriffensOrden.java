package orderofthegriff;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layoutWithHead;


/**
 * Created by Torsten on 11.02.15
 */
public class GriffensOrden extends Controller {
    final static public Result index() {  return ok(layoutWithHead.render("Griffens Orden", orderofthegriff.views.html.griffensOrdenbody.render(),orderofthegriff.views.html.griffensOrdenhead.render()));
    }
}
