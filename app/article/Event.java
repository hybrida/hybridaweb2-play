package article;

import models.*;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;


public class Event extends Controller {

	final static play.data.Form<models.Article> articleForm = play.data.Form.form(models.Article.class);

	public static Result updateUser() {
		User user = LoginState.getUser();
		if (user.isDefault()) {
			return application.Application.show400("Du må logge inn på nytt.");
		}
		Long event_id = new HttpRequestData().getLong("eventId");
		if (event_id == null) {
			return application.Application.show400("Forventet HTTP data nøkkel 'eventId' ikke funnet.");
		}
		models.Event event = models.Event.find.byId(event_id);

		java.util.Calendar cal = java.util.Calendar.getInstance();
		if (cal.after(event.getSignUpDeadline())) {
			return redirect(routes.Event.viewEvent(event_id.toString()).absoluteURL(request()));
		}
		UserEventJoined joined_user = new UserEventJoined(user.getId(), event.getEventId());
		joined_user.save();
		return redirect(routes.Event.viewEvent(event_id.toString()).absoluteURL(request()));
	}

	public static Result removeUser() {
		User user = LoginState.getUser();
		if (user.isDefault()) {
			return application.Application.show400("Du må logge inn på nytt.");
		}
		Long event_id = new HttpRequestData().getLong("eventId");
		if (event_id == null) {
			return application.Application.show400("Forventet HTTP data nøkkel 'eventId' ikke funnet.");
		}
		models.Event event = models.Event.find.byId(event_id);

		UserEventJoined.remove(user.getId(), event.getEventId());
		return redirect(routes.Event.viewEvent(event_id.toString()).absoluteURL(request()));
	}

	public static Result viewEvent(String eventId) {
		if (models.Event.find.byId(Long.valueOf(eventId)) != null) {
			models.Event inevent = models.Event.find.byId(Long.valueOf(eventId));
			models.Article inarticle = models.Article.find.byId(Long.valueOf(inevent.getArticleId()));
			java.util.List<User> signedups = models.UserEventJoined.getAllSignedUpUsers(inevent.getEventId());
			return ok(layout.render("Arrangement", article.views.html.viewEvent.render(inarticle, inevent)));
		}
		else
			return application.Application.show404(request().uri().replaceFirst("/", ""));
	}

	public static Result editEvent(String id) {
		Result error = application.Application.checkEditPrivilege(LoginState.getUser());
		if (error != null)
			return error;

		models.Event event = models.Event.find.byId(Long.valueOf(id));
		models.Article inarticle = models.Article.find.byId(event.getArticleId());
		return ok(layout.render("", article.views.html.editEvent.render(event, inarticle)));
	}

	public static Result saveEdit(String id) {
		User user = LoginState.getUser();
		Result error = application.Application.checkEditPrivilege(user);
		if (error != null)
			return error;
		models.Event event = models.Event.find.byId(Long.valueOf(id));

		play.data.Form<models.Article> articleInput = articleForm.bindFromRequest();

		if (!articleInput.hasErrors()) {
			models.Article articleModel = articleInput.get();

			articleModel.setId(event.getArticleId());
			articleModel.setImagePath(user.uploadPicture());
			articleModel.setAuthor(user.getId());
			articleModel.update();
			ArticleIn.saveEvent(event.getArticleId(), event.getEventId());
		}
		return application.Application.index();
	}

}
