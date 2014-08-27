package controllers;

import play.*;
import play.mvc.*;
import views.html.*;


import play.db.*;


public class Application extends Controller {

    public static Result index() {
    	return ok(layout.render("Hybrida", "This is the secondary content"));
    }

    public static Result getter(String str) {
    	return ok("A message was recorded: " + str);
    }

}