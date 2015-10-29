package article;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import static play.data.Form.form;

import java.text.ParseException;
import java.util.Calendar;
import java.time.LocalDate;

import article.Article;
import article.views.html.*;
import views.html.layout;
import views.html.utils.centerBlock;
import models.*;


public class ArticleIn extends Controller {

	final static Form<models.Article> articleForm = form(models.Article.class);
	final static Form<models.Event> eventForm = form(models.Event.class);

	public static Result index() {
		Calendar signUpStart = Calendar.getInstance();
		signUpStart.add(Calendar.DAY_OF_MONTH, 1);

		Calendar secondSignUp = Calendar.getInstance();
		secondSignUp.add(Calendar.DAY_OF_MONTH, 3);

		Calendar signUpDeadline = Calendar.getInstance();
		signUpDeadline.add(Calendar.DAY_OF_MONTH, 7);

		Calendar eventHappens = Calendar.getInstance();
		eventHappens.add(Calendar.DAY_OF_MONTH, 8);

		Calendar eventEnds = Calendar.getInstance();
		eventEnds.add(Calendar.DAY_OF_MONTH, 9);

		return ok(layout.render("Hybrida: Opprett Artikkel",
			index.render(signUpStart, secondSignUp, signUpDeadline, eventHappens,
				eventEnds)));
	}

	public static boolean thisIsAnEvent() {
		return (new HttpRequestData()).get("event") != null;
	}

	public static Result save() {
		System.out.println(new HttpRequestData());
		User user = LoginState.getUser();
		if (!user.canCreateNewArticle())
			return application.Application.showUnauthorizedAccess();

		String image_link = user.uploadPicture("picture");

		models.Article article;
		try {
			article = articleForm.bindFromRequest().get();
		} catch (IllegalStateException exc) {
			return application.Application.show400("Fikk tom input. Frykt ikke; bare trykk tilbake for å redde det du prøvde å poste.");
		}
		if (article.validate() != null)
			return application.Application.showUnauthorizedAccess();

		article.setAuthor(user);
		if (image_link != null) article.setImagePath(image_link);
		else article.setDefaultImage();
		if (thisIsAnEvent()) {
			models.Event event = models.Event.getFromRequest();
			article.save();
			event.setArticle(article);
			event.save();
			models.Renders.addEvent(event);
			return redirect(routes.Event.viewEvent("" + event.getId()));
		} else {
			article.save();
			models.Renders.addArticle(article);
			return redirect(routes.Article.viewArticle("" + article.getId()));
		}
	}

	public static models.Article saveArticle() throws IllegalStateException {
		User user = LoginState.getUser();
		Form<models.Article> articleInput = articleForm.bindFromRequest();
		System.out.println(new HttpRequestData());
//		String image_link = user.uploadPicture();
		if (!articleInput.hasErrors()) {
			models.Article articleModel = articleInput.get();
//			if (image_link != null)
//				articleModel.setImagePath(image_link);
//			else
//				articleModel.setDefaultImage();
			articleModel.setDefaultImage(); //TODO: Should use Upload Controller (sry Kev)
			articleModel.setAuthor(user);
			articleModel.save();

			return articleModel;
		}
		throw new IllegalStateException();
	}

	public static long saveSpecificArticle(String id) throws IllegalStateException {
		User user = LoginState.getUser();

		Form<models.Article> articleInput = articleForm.bindFromRequest();
//		String image_link = user.uploadPicture();
		if (!articleInput.hasErrors()) {
			models.Article articleModel = articleInput.get();
//			if (image_link != null)
//				articleModel.setImagePath(image_link);
//			else
//				articleModel.setDefaultImage();
            articleModel.setDefaultImage(); //TODO: Should use Upload Controller (sry Kev)
			articleModel.setAuthor(user);
			articleModel.setId(Long.valueOf(id));
			articleModel.update();

			return articleModel.getId();
		}
		throw new IllegalStateException();
	}


	public static Result saveEdit(String id) {
		Result error = application.Application.checkEditPrivilege(LoginState.getUser());
		if (error != null)
			return error;

		models.Article article = models.Article.find.byId(Long.valueOf(id));
		HttpRequestData httpdata = new HttpRequestData();
		article.setTitle(httpdata.get("title"));
		article.setIngress(httpdata.get("ingress"));
		article.setText(httpdata.get("text"));
		String new_image = null;
		if (new_image != null)
			article.setImagePath(new_image);
		article.save();
		return application.Application.index();
	}

}
