package controllers;

import play.*;
import play.mvc.*;
import views.html.*;


import play.db.*;

public class About extends Controller {
	public static Result index() {
		return ok(showsimple.render("This page is about Hybrida"));
	}	
}