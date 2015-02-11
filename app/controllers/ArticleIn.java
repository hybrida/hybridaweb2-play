package controllers;

import models.*;
import play.mvc.Controller;
import play.mvc.Result;

import play.data.Form;

import views.html.layoutHtml;
import views.html.utils.centerBlock;

import static play.data.Form.form;

import models.Event;


public class ArticleIn extends Controller {

    final static Form<Event> eventForm = form(Event.class);
    final static Form<Article> articleForm = form(Article.class);

    public static Result index() {
        return ok(layoutHtml.render("Hybrida: Opprett Artikkel", centerBlock.render(views.html.ArticleIn.index.render())));
    }

    public static Result save() {
        try {
            User user = LoginState.getUser();
            if (user == null || !user.canCreateNewArticle())
                return Application.showUnauthorizedAccess();

            long id = saveArticle();

            if(!(new HttpRequestData().get("event") == null)) {
                saveEvent(id);
                System.out.println("TRUE");
            }
            return redirect(routes.ArticleOut.index("" + id).absoluteURL(request()));
        }
        catch (IllegalStateException e){
            return redirect(routes.Application.show400("error").absoluteURL(request()));

        }
    }

    public static long saveArticle() throws IllegalStateException {
        User user = LoginState.getUser();

        Form<Article> articleInput = articleForm.bindFromRequest();
        System.out.println(new HttpRequestData());
        if (!articleInput.hasErrors()) {
            Article articleModel = articleInput.get();
            articleModel.setImagePath(user.uploadPicture());
            articleModel.setAuthor(user.getID());
            articleModel.save();
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

    public static boolean checkImageType(String contentType){
        String[] type = contentType.split("/");
        if(type[0].equals("image")){
            return true;
        }
        return false;
    }
}