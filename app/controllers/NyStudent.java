package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layoutHtmlExt;

/**
 * Created by Torsten on
 */
    public class NyStudent extends Controller {
        final static public Result index(){  return ok(layoutHtmlExt.render("",views.html.NyStudent.NyStudentHead.render(), views.html.NyStudent.NyStudentBody.render()));
        }
}
