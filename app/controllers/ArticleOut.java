package controllers;

import models.*;
import models.Event;
import play.mvc.Result;
import play.data.Form;
import play.mvc.Controller;
import views.html.ArticleOut.*;
import views.html.layoutHtml;

import java.util.ArrayList;
import java.util.List;

import static play.data.Form.form;

/**
 * Created by eliasbragstadhagen on 04.02.15.


 */
public class ArticleOut extends Controller {

    final static Form<models.Event> eventForm = form(models.Event.class);
    final static Form<Article> articleForm = form(Article.class);

    public static Result index(String id){
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

        if(event != null){
            resultList.add(event.getLocation());
            resultList.add(event.getEventHappens().toString());
            resultList.add("" + event.getMaxParticipants());
        }
        return ok(layoutHtml.render("hybrida", views.html.utils.centerBlock.render(views.html.ArticleOut.index.render(resultList))));
    }


    public static Article getArticle(long articleId){
        Article article = Article.find.byId(articleId);
        return article;
    }

    public static Event getEvent(Article article){
        Event event = Event.find.where("articleId = " + article.getId().toString()).findUnique();
        return event;
    }


}
