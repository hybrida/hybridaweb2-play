package controllers;
import play.mvc.*;
import views.html.*;
/**
 * Created by Kia on 30.09.14.
 */
public class OmStyret extends Controller {
    final static public Result index(){
    return ok(layoutHtml.render("",views.html.OmStyret.index.render()));
}


}
