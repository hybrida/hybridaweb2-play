package trash.controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layoutHtml;

/**
 * Created by Kia on 16.10.14.
 */
    public class NyStudent extends Controller {
        final static public Result index(){  return ok(layoutHtml.render("", views.html.OmHybrida.index.render()));
        }
}
