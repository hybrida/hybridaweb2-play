package controllers;

import models.*;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;


public class Event extends Controller {

    public static Result updateUser() {
        User user = LoginState.getUser();
        if (user.isDefault()) {
            return controllers.Application.show400("Du må logge inn på nytt.");
        }
        Long event_id = new HttpRequestData().getLong("eventId");
        if (event_id == null) {
            return controllers.Application.show400("Forventet HTTP data nøkkel 'eventId' ikke funnet.");
        }
        models.Event event = models.Event.find.byId(event_id);

        UserEventJoined.insert(user.getId(), event.getEventId());
        return controllers.Application.index();
    }

    public static Result removeUser() {
        User user = LoginState.getUser();
        if (user.isDefault()) {
            return controllers.Application.show400("Du må logge inn på nytt.");
        }
        Long event_id = new HttpRequestData().getLong("eventId");
        if (event_id == null) {
            return controllers.Application.show400("Forventet HTTP data nøkkel 'eventId' ikke funnet.");
        }
        models.Event event = models.Event.find.byId(event_id);

        UserEventJoined.remove(user.getId(), event.getEventId());
        return controllers.Application.index();
    }

    public static Result viewEvent(String eventId) {
        if (models.Event.find.byId(Long.valueOf(eventId)) != null) {
            models.Event event = models.Event.find.byId(Long.valueOf(eventId));
            models.Article article = models.Article.find.byId(Long.valueOf(event.getArticleId()));
            return ok(layout.render("Arrangement", views.html.Event.viewEvent.render(article, event)));
        }
        else
            return Application.show404(request().uri().replaceFirst("/", ""));
    }

}
