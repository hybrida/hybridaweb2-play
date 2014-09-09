package controllers;

import play.mvc.Controller;
import views.html.*;
import play.mvc.Result;
import no.ntnu.it.fw.saml2api.http.*;

import javax.servlet.ServletException;

public class ExampleFeide extends Controller {

    public static Result index() throws ServletException {
        (new InitServlet()).init();
        LoginServlet servlet = new LoginServlet();
        servlet.init();
        return ok(layoutHtml.render("Feide", play.twirl.api.Html.apply("<h1> Feide innlogging </h1>")));
    }
}
