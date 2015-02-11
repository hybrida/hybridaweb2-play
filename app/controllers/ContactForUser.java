package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layoutHtml;

public class ContactForUser extends Controller {
    public static Result index() {
        return ok(layoutHtml.render("Kontakt oss", views.html.ContactForUser.index.render()));
    }
}
