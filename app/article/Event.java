package article;

import controllers.Upload;
import exceptions.NoFileInRequest;
import exceptions.ServerError;
import exceptions.Unauthorized;
import models.*;
import play.mvc.Controller;
import play.mvc.Result;
import profile.models.User;
import views.html.layout;
import views.html.layoutWithHead;
import article.views.html.*;

import static application.Application.show400;

import java.util.List;

public class Event extends Controller {

	final static play.data.Form<models.Article> articleForm = play.data.Form.form(models.Article.class);

	public static Result updateUser() {
		User user = LoginState.getUser();
		if (user.isDefault())
			return show400("Du må logge inn på nytt.");
		//if (user.isFirstUser())
			//return show400("Du kan ikke melde deg på som root bruker.");
		Long event_id = new HttpRequestData().getLong("eventId");
		if (event_id == null)
			return show400("Forventet HTTP data nøkkel 'eventId' ikke funnet.");

		models.Event evt = models.Event.find.byId(event_id);
		evt.checkAndAddJoiner(user);
		evt.update();

		return redirect(routes.Event.viewEvent(event_id.toString()).absoluteURL(request()));
	}

	public static Result removeUser() {
		User user = LoginState.getUser();
		if (user.isDefault()) {
			return show400("Du må logge inn på nytt.");
		}
		Long event_id = new HttpRequestData().getLong("eventId");
		if (event_id == null) {
			return show400("Forventet HTTP data nøkkel 'eventId' ikke funnet.");
		}

		models.Event event = models.Event.find.byId(event_id);
		event.checkAndRemoveJoiner(user);
		event.update();

		return redirect(routes.Event.viewEvent(event_id.toString()).absoluteURL(request()));
	}

	public static Result viewEvent(String eventId) {
		if (models.Event.find.byId(Long.valueOf(eventId)) != null) {
			models.Event evt = models.Event.find.byId(Long.valueOf(eventId));
			evt.checkAndAssignWaiters();

			models.Article art = evt.getArticle();
			List<User> signedups = evt.getJoinedUsers();
			return ok(layout.render("Arrangement", viewEvent.render(art, evt)));
		}
		else
			return application.Application.show404(request().uri().replaceFirst("/", ""));
	}

	public static Result editEvent(String id) {
		Result error = application.Application.checkEditPrivilege(LoginState.getUser()); //TODO: Each controller should take care of it's own auth logic
		if (error != null)
			return error;

		models.Event evt = models.Event.find.byId(Long.valueOf(id));
		models.Article art = evt.getArticle();
		return ok(layoutWithHead.render(
				""
				, article.views.html.editEvent.render(evt, art)
				, article.views.html.editHead.render()));
	}

	public static Result saveEdit(String id) throws Unauthorized, ServerError {
		User user = LoginState.getUser();
		Result error = application.Application.checkEditPrivilege(user);
		if (error != null)
			return error;
		models.Event event = models.Event.find.byId(Long.valueOf(id));

		if (HttpRequestData.isGiven("delete")) {
			renders.models.Renders.getByEventId(Long.valueOf(id)).delete();
			return redirect(application.routes.Application.index());
		}

		play.data.Form<models.Article> articleInput = articleForm.bindFromRequest();

		String image_path = null;
		try{
			image_path = Upload.upload("picture");
		} catch (Unauthorized unauthorized) {
			unauthorized.printStackTrace();
		} catch (NoFileInRequest noFileInRequest) {
			noFileInRequest.printStackTrace();
		} catch (ServerError serverError) {
			serverError.printStackTrace();
		}
		if (!articleInput.hasErrors()) {

			models.Event oldevent = new models.Event(event);
			oldevent.save();

			models.Article articleModel = articleInput.get();
			if (image_path != null)
				articleModel.setImagePath(image_path);
			else
				articleModel.setImagePath(oldevent.getArticle().getImagePath());
			articleModel.setAuthor(LoginState.getUser());
			articleModel.save();

			EventWaitingUsers waitingUsers = event.getRawWaitingUsers();
			Long eid = event.getId();
			event = models.Event.getFromRequest();
			event.setPrevious(oldevent);
			event.setId(eid);
			event.setArticle(articleModel);
			event.setWaitingUsers(waitingUsers);

			event.update();
		}
		return application.Application.index();
	}

}
