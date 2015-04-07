package controllers;

import models.*;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;


public class Event extends Controller {

    final static play.data.Form<Article> articleForm = play.data.Form.form(Article.class);

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

    public static Result editEvent(String id) {
        models.Event event = models.Event.find.byId(Long.valueOf(id));
        models.Article article = models.Article.find.byId(event.getArticleId());
        return ok(layout.render("", views.html.Event.editEvent.render(event, article)));
    }

    public static Result saveEdit(String id) {
        User user = LoginState.getUser();
        if (user.isDefault()) {
            return controllers.Application.show400("Du må logge inn for å endre arransjement.");
        }
        models.Event event = models.Event.find.byId(Long.valueOf(id));
        play.data.Form<Article> articleInput = articleForm.bindFromRequest();

        if (!articleInput.hasErrors()) {
            Article articleModel = articleInput.get();
            articleModel.setId(event.getArticleId());
            articleModel.setImagePath(user.uploadPicture());
            articleModel.setAuthor(user.getId());
            articleModel.update();
        }
        ArticleIn.saveEvent(event.getArticleId(), event.getEventId());
        return Application.index();
    }

}
