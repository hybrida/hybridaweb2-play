package controllers;

import play.mvc.*;
import views.html.*;
import play.data.Form;

import models.*;

import static play.data.Form.form;


public class Search extends Controller {
	
	public static Result index() {
		Form<SearchForm> input = form(SearchForm.class).bindFromRequest();

        if (input.hasErrors()) {
            SearchForm form = new SearchForm();
            return ok(layoutHtml.render("hybrida", play.twirl.api.Html.apply("Error wrong search term")));
        } else {

            SearchForm saved = input.get();
            String key = input.get().term;

            return ok(layoutHtml.render("hybrida", play.twirl.api.Html.apply(key)));
        }
	}

}