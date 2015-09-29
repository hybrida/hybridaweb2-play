package bedkomdatabase;

import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;
import models.*;

import application.views.html.*;
import views.html.layout;

public class Bedkomdatabase extends Controller {

    public static Result index(){

        return ok();
    }

    public static Result saveBedrift(){
        return ok();
    }

    public static Result saveKontaktPerson(){
        return ok();
    }


}