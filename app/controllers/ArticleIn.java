package controllers;

import models.*;
import models.Event;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;
import views.html.utils.centerBlock;

import static play.data.Form.form;


public class ArticleIn extends Controller {

    final static Form<Event> eventForm = form(Event.class);
    final static Form<Article> articleForm = form(Article.class);

    public static Result index() {
        return ok(layout.render("Hybrida: Opprett Artikkel", centerBlock.render(views.html.ArticleIn.index.render())));
    }

    public static Result save() {
        try {
            User user = LoginState.getUser();
            if (user == null || !user.canCreateNewArticle())
                return Application.showUnauthorizedAccess();

            long id = saveArticle();

            if(!(new HttpRequestData().get("event") == null)) {
                System.out.println("Event was checked!");
                saveEvent(id);
                System.out.println("TRUE");
            }
            return redirect(routes.ArticleOut.index("" + id).absoluteURL(request()));
        }
        catch (IllegalStateException e){
            return Application.show400("ugyldig data oppgitt");
        }
    }

    public static long saveArticle() throws IllegalStateException {
        User user = LoginState.getUser();

        Form<Article> articleInput = articleForm.bindFromRequest();
        System.out.println(new HttpRequestData());
        if (!articleInput.hasErrors()) {
            Article articleModel = articleInput.get();
            articleModel.setImagePath(user.uploadPicture());
            articleModel.setAuthor(user.getId());
            articleModel.save();

            // Husk å legge til artikkelen i renders! Da vises den nemlig på fremsiden ^_^
            Renders.addArticle(articleModel);

            return articleModel.getId();
        }
        throw new IllegalStateException();
    }

    public static void saveEvent(long articleID){
        Form<Event> eventInput = eventForm.bindFromRequest();
        Event eventModel = eventInput.get();
        eventModel.setArticleId(articleID);
        eventModel.save();
    }

}