package controllers;

import play.*;
import play.mvc.*;
import views.html.*;


import play.db.*;


public class Application extends Controller {

    public static Result index() throws java.sql.SQLException {
		java.util.ArrayList<String> names = new java.util.ArrayList<String>();    	
		return ok(layout.render("Hybrida", names));
    }

    public static Result getter(String str) {
    	return ok("A message was recorded: " + str);
    }

}
