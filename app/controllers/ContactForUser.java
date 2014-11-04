package controllers;

import play.mvc.*;
import views.html.*;

public class ContactForUser extends Controller {
    public static Result index() {
        return ok(layoutHtml.render("Kontakt oss", generateArticle.render(contactForUser.render())));
    }
}
