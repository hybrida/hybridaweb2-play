package controllers;

import play.*;
import play.mvc.*;
import views.html.*;


import play.db.*;


public class Application extends Controller {

    public static Result index() throws java.sql.SQLException {
    	java.util.ArrayList<String> names = new java.util.ArrayList<String>();    	

    	String x = session("visited");
    	if (x == null)
    	{
    		session("visited", "0");
    	}
		else
		{
			session("visited", Integer.toString(Integer.valueOf(x) + 1));
			if (Integer.parseInt(x) > 10)
				names.add("You're a true hybrid");
    	}
		return ok(layout.render("Hybrida", names));
    }

    public static Result show404(String get_value) {
    	java.util.ArrayList<String> four = new java.util.ArrayList<String>();
    	four.add(notFoundErrorPage.render(get_value).toString());
    	return notFound(layout.render("404", four));
    }


}

