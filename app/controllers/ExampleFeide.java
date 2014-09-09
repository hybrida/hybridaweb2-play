package controllers;

import play.mvc.Controller;
import views.html.*;
import play.mvc.Result;
import no.ntnu.it.fw.saml2api.http.*;

import javax.servlet.ServletException;

public class ExampleFeide extends Controller {

    public static Result index() {
        return redirect("https://innsida.ntnu.no/sso/?target=hybridaweb&returnargs=");
    }
}

