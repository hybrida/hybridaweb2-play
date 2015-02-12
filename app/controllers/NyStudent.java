package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layoutWithHead;

/**
 * Created by Torsten on
 */
    public class NyStudent extends Controller {
        final static public Result index(){  return ok(layoutWithHead.render("", views.html.NyStudent.NyStudentHead.render(), views.html.NyStudent.NyStudentBody.render()));
        }
}
