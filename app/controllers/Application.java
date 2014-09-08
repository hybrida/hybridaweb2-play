package controllers;

import play.*;
import play.mvc.*;
import views.html.*;

import models.*;

import play.db.*;


public class Application extends Controller {

	final static play.data.Form<SearchForm> userForm = play.data.Form.form(SearchForm.class);

	public static play.twirl.api.Html renderMainLayout(String title, java.util.ArrayList<String> content) {
    	return layout.render(title, content);
	}

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

        return ok(layoutHtml.render("Hybrida", escapeText.render("<h1> derp </h1>")));
    	//return ok(Application.renderMainLayout("Hybrida", names));
    }

    public static Result processForm() {
    	play.data.Form<SearchForm> s = userForm.bindFromRequest();
    	SearchForm x = s.get();
    	if (x.term != null)
    		return ok(x.term);
    	return badRequest("Whut");
    }

    public static Result show404(String get_value) {
    	java.util.ArrayList<String> four = new java.util.ArrayList<String>();
    	four.add(notFoundErrorPage.render(get_value).toString());
    	//play.data.Form<Search> userForm = play.data.Form.form(Search.class);
    	return notFound(renderMainLayout("404", four));
    }


}

