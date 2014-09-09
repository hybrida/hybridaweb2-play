package controllers;

import play.mvc.Controller;
import views.html.*;
import play.mvc.Result;

public class ExampleFeide extends Controller {

    public static Result index() {
        return ok(layoutHtml.render("Feide", play.twirl.api.Html.apply("<h1> Feide innlogging </h1>")));
    }
}
