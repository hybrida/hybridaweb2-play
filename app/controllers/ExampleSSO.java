package controllers;

import play.mvc.Controller;
import views.html.*;
import play.mvc.Result;

public class ExampleSSO extends Controller {

    public static String innsida_login_link = "https://innsida.ntnu.no/sso/?target=hybridaweb&returnargs=";

    public static Result index() {
        String toroute = routes.Application.index().absoluteURL(request());
        return redirect("https://innsida.ntnu.no/sso/?target=hybridaweb&returnargs=");
    }
}

