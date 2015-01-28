package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.generateArticle;
import views.html.layoutHtml;

public class ContactForUser extends Controller {
    public static Result index() {
        return ok(layoutHtml.render("Kontakt oss", generateArticle.render(views.html.ContactForUser.index.render())));
    }
}
