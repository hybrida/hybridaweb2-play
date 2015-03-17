package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layoutWithHead;

/**
 * Created by Torsten on
 */
public class Riddere extends Controller {
    final static public Result index() {  return ok(layoutWithHead.render("Griffens Orden", views.html.griffensOrdenbody.render(),views.html.griffensOrdenhead.render()));
    }
}
