package article;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import static play.data.Form.form;

import article.views.html.*;
import profile.models.User;
import views.html.layout;
import controllers.Upload;
import exceptions.*;
import models.*;

public class ArticleIn extends Controller {

	final static Form<models.ArticleSQL> articleFormSql = form(models.ArticleSQL.class);
	final static Form<models.Article> articleForm = form(models.Article.class);
	final static Form<models.Event> eventForm = form(models.Event.class);

	public static Result index() {
		return ok(layout.render("Hybrida: Opprett Artikkel",
			index.render()));
	}

	public static boolean thisIsAnEvent() {
		return (new HttpRequestData()).get("event") != null;
	}

	public static Result save() throws Unauthorized, ServerError {
		User user = LoginState.getUser();
		if (!user.canCreateNewArticle())
			return application.Application.showUnauthorizedAccess();

		String image_link = Upload.uploadOptional("picture");
		String imagePath = image_link;

		models.ArticleSQL articleSql;
		try {
			articleSql = articleFormSql.bindFromRequest().get();
			if (articleSql.validate() == null) {
				Long id = articleSql.createNewArticle(user.getId(), imagePath);
				models.Visible.setArticleVisible(id);
				return redirect(routes.Event.viewEvent("" + id));
			} else {
				return application.Application.show400("Mangler inputt for artikkelen, trykk tilbake for å fikse.");
			}
		} catch (IllegalStateException exc) {
			return application.Application.show400("Fikk tom input. Frykt ikke; bare trykk tilbake for å redde det du prøvde å poste.");
		}
	}

	public static long saveSpecificArticle(String id)
		throws IllegalStateException,
			Unauthorized,
			ServerError,
			NoFileInRequest {
		User user = LoginState.getUser();

		Form<models.Article> articleInput = articleForm.bindFromRequest();
		String image_link = Upload.uploadOptional("picture");

		if (!articleInput.hasErrors()) {
			models.Article articleModel = articleInput.get();
			if (image_link != null)
				articleModel.setImagePath(image_link);
			else
				articleModel.setDefaultImage();

			articleModel.setAuthor(user);
			articleModel.setId(Long.valueOf(id));
			articleModel.update();

			return articleModel.getId();
		}
		throw new IllegalStateException();
	}


	public static Result saveEdit(String id)
		throws Unauthorized,
			ServerError,
			NoFileInRequest {

		User user = LoginState.getUser();

		String image_link = Upload.uploadOptional("picture");

		models.Article article = models.Article.find.byId(Long.valueOf(id));
		if (HttpRequestData.isGiven("delete"))
			renders.models.Renders.getByArticleId(article.getId()).delete();
		else {
			HttpRequestData httpdata = new HttpRequestData();
			models.Article oldart = new models.Article(article);
			oldart.save();
			article.setTitle(httpdata.get("title"));
			article.setIngress(httpdata.get("ingress"));
			article.setText(httpdata.get("text"));
			article.setAuthor(LoginState.getUser());
			article.setPrevious(oldart);

			if (image_link != null)
				article.setImagePath(image_link);
			else
				article.setImagePath(article.getImagePath());

			article.save();
		}
		return redirect(application.routes.Application.index());
	}

}
