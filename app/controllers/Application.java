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
    	java.util.ArrayList<String> is = new java.util.ArrayList<String>();
    	java.util.ArrayList<String> is2 = new java.util.ArrayList<String>();
    	
    	for (int i = 0; i < 5; ++i) {
	    	is.add(new Integer(i).toString());
	    	String x = layout.render("I dunno m89", is).toString();
	    	is.remove(is.size() - 1);
	    	is.add(x);
	    }

    	is.add("<h1>This is not escaped</h1>");
    	is.add("<h2>1337</h2>");   
    	is.add("<h3>#route</h3>"); 
    	is.add("<h3>#route #MLG #yoloswag ( ͡° ͜ʖ ͡°)</h3>");
    	is.add("<img src=\"/assets/images/5f0.png\" alt=\"sweaty face\">");


    	return ok(layout.render("A message was recorded: " + str, is));
    }


}

