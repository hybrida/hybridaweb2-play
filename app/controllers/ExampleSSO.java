package controllers;

import play.mvc.Controller;
import views.html.*;
import play.mvc.Result;

public class ExampleSSO extends Controller {

    public static Result index() {
        return redirect("https://innsida.ntnu.no/sso/?target=hybridaweb&returnargs=");
    }
}

