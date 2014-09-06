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
    	java.util.ArrayList<String> stuff_to_render = new java.util.ArrayList<String>();
    	stuff_to_render.add("<h1>This is not escaped</h1>");
    	stuff_to_render.add("<h2>1337</h2>");   
    	stuff_to_render.add("<h3>#route</h3>"); 
    	stuff_to_render.add("<h3>#route #MLG #yoloswag ( ͡° ͜ʖ ͡°)</h3>");
    	stuff_to_render.add("<img src=\"assets/images/5f0.png\" alt=\"sweaty face\">");
    	return ok(layout.render("A message was recorded: " + str, stuff_to_render));
    }

}

