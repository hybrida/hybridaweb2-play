package controllers;

import views.html.*;
import play.mvc.*;

public class Calendar extends Controller {
    public static Result calendarRender() {
        return ok(layoutHtml.render("Kalender",calendar.render()));
    }
}
