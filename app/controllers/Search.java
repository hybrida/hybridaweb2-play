package controllers;

import models.SearchForm;
import models.Article;
import application.Application;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;
import play.twirl.api.Html;
import java.util.List;
import controllers.views.html.emptySearch;
import views.html.layoutBoxPage;

import static play.data.Form.form;


public class Search extends Controller {

	public static Result index() {
		Form<SearchForm> input = form(SearchForm.class).bindFromRequest();

		if (input.hasErrors()) {
			SearchForm form = new SearchForm();
			return Application.showUnauthorizedAccess();
		} else {

			SearchForm saved = input.get();
			String key = input.get().term;
			key = "%" + key + "%";

			String head = "eventReference.articleRef.",
				art = "articleReference.";

			List<models.Renders> renderables = models.Renders.find.setMaxRows(10).where(
				).disjunction()
					.like(art + "ingress", key)
					.like(art + "title", key)
					.like(art + "text", key)
					.like(head + "ingress", key)
					.like(head + "title", key)
					.like(head + "text", key)
					.endJunction()
				.orderBy().desc("renderId").findList();

			if (renderables.isEmpty()) {
				return ok(layoutBoxPage.render("Ingenting Funnet", emptySearch.render()));
			} else {
				return newsfeed.Newsfeed.index(renderables);
			}
		}
	}

}
