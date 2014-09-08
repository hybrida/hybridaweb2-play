package controllers;

import play.*;
import play.mvc.*;
import views.html.*;
import play.data.Form;

import play.data.Form;

import models.*;

import static play.data.Form.form;


public class Search extends Controller {
	
	public static Result index() {
		Form<SearchForm> input = form(SearchForm.class).bindFromRequest();

        if (input.hasErrors()) {
            SearchForm form = new SearchForm();
            return ok(layoutString.render("hybrida", "Error wrong search term"));
        } else {

            SearchForm saved = input.get();
            String key = input.get().term;

            return ok(layoutString.render("hybrida", key));
        }
	}

}