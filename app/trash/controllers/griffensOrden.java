package trash.controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layoutHtmlExt;
import views.html.NyStudent.*;
import views.html.main_ext;

/**
 * Created by Torsten on 11.02.15
 */
public class griffensOrden extends Controller {
    final static public Result index(){  return ok(layoutHtmlExt.render("",views.html.griffensOrdenhead.render(), views.html.griffensOrdenbody.render()));
    }
}