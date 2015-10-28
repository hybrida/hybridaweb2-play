package article;

import controllers.Upload;
import exceptions.NoFileInRequest;
import exceptions.ServerError;
import exceptions.Unauthorized;
import models.*;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

import java.util.List;

public class Event extends Controller {

	final static play.data.Form<models.Article> articleForm = play.data.Form.form(models.Article.class);

	public static Result updateUser() {
		User user = LoginState.getUser();
		if (user.isDefault())
			return application.Application.show400("Du må logge inn på nytt.");
		Long event_id = new HttpRequestData().getLong("eventId");
		if (event_id == null)
			return application.Application.show400("Forventet HTTP data nøkkel 'eventId' ikke funnet.");

		models.Event evt = models.Event.find.byId(event_id);
		evt.checkAndAddJoiner(user);
		evt.save();

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
		event.getJoinedUsers().remove(event.getJoinedUsers().indexOf(user));
		event.save();

		return redirect(routes.Event.viewEvent(event_id.toString()).absoluteURL(request()));
	}

	public static Result viewEvent(String eventId) {
		if (models.Event.find.byId(Long.valueOf(eventId)) != null) {
			models.Event evt = models.Event.find.byId(Long.valueOf(eventId));
			models.Article art = evt.getArticle();
			List<User> signedups = evt.getJoinedUsers();
			return ok(layout.render("Arrangement", article.views.html.viewEvent.render(art, evt)));
		}
		else
			return application.Application.show404(request().uri().replaceFirst("/", ""));
	}

	public static Result editEvent(String id) {
		Result error = application.Application.checkEditPrivilege(LoginState.getUser());
		if (error != null)
			return error;

		models.Event evt = models.Event.find.byId(Long.valueOf(id));
		models.Article art = evt.getArticle();
		return ok(layout.render("", article.views.html.editEvent.render(evt, art)));
	}

	public static Result saveEdit(String id) {
		User user = LoginState.getUser();
		Result error = application.Application.checkEditPrivilege(user);
		if (error != null)
			return error;
		models.Event event = models.Event.find.byId(Long.valueOf(id));

		play.data.Form<models.Article> articleInput = articleForm.bindFromRequest();

		String image_path = null;
		try{
			image_path = Upload.upload();
		} catch (Unauthorized unauthorized) {
			unauthorized.printStackTrace();
		} catch (NoFileInRequest noFileInRequest) {
			noFileInRequest.printStackTrace();
		} catch (ServerError serverError) {
			serverError.printStackTrace();
		}
		if (!articleInput.hasErrors()) {
			models.Article articleModel = articleInput.get();
			if (image_path != null)
				articleModel.setImagePath(image_path);
			articleModel.setAuthor(user);
			articleModel.update();
			ArticleIn.saveEvent(event.getArticle(), event.getId());
		}
		return application.Application.index();
	}

}
