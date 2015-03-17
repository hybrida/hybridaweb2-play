package controllers;

import models.Article;
import models.Event;
import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

import java.util.ArrayList;
import java.util.List;

import static play.data.Form.form;

/**
 * Created by eliasbragstadhagen on 04.02.15.
 */
public class ArticleOut extends Controller {

    public static Result index(String id) {
        if (Article.find.byId(Long.valueOf(id)) == null)
            return Application.show404(request().uri().replaceFirst("/", ""));
        Long lId = Long.parseLong(id);
        Article article = getArticle(lId);
        Event event = getEvent(article);

        List<String> resultList = new ArrayList<String>();
        resultList.add(article.getTitle());
        resultList.add(article.getIngress());
        resultList.add(article.getText());
        resultList.add(article.getImagePath());
        resultList.add(User.find.byId(article.getAuthor()).getName());
        resultList.add(article.getDateMade().toString());

        if(event != null) {
            resultList.add(event.getLocation());
            resultList.add(event.getEventHappens().toString());
            resultList.add("" + event.getMaxParticipants());
        }
        return ok(layout.render("hybrida", views.html.utils.centerBlock.render(views.html.ArticleOut.index.render(resultList))));
    }


    public static Result viewArticle(String id) {
        Application x = new Application();
        if (Article.find.byId(Long.valueOf(id)) != null)
            return ok(layout.render("Artikkel", views.html.ArticleOut.viewArticle.render(Article.find.byId(Long.valueOf(id)))));
        else
            return Application.show404(request().uri().replaceFirst("/", ""));
    }

    public static Article getArticle(long articleId) {
        Article article = Article.find.byId(articleId);
        return article;
    }

    public static Event getEvent(Article article) {
        Event event = Event.find.where("articleId = " + article.getId().toString()).findUnique();
        return event;
    }

    public static Result joinEvent(String eventId) {
        return ok();
    }

    public static Result abandonEvent(String eventId) {
        return ok();
    }

}
