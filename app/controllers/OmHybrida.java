package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layoutHtml;
import views.html.Hybrida;

/**
 * Created by Kia on 16.10.14.
 */
    public class OmHybrida extends Controller {
        final static public Result index(){  return ok(layoutHtml.render("", views.html.Hybrida.render()));
        }
}
