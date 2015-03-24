package trash.controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layoutWithHead;
import views.html.NyStudent.*;


/**
 * Created by Torsten on 11.02.15
 */
public class griffensOrden extends Controller {
    final static public Result index() {  return ok(layoutWithHead.render("Griffens Orden", views.html.griffensOrdenbody.render(),views.html.griffensOrdenhead.render()));
    }
}