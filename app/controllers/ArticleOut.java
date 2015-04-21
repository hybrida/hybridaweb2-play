package controllers;

import models.*;
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
        models.Event event = getEvent(article);

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
        try {
            if (Article.find.byId(Long.valueOf(id)) != null)
                return ok(layout.render("Artikkel", views.html.ArticleOut.viewArticle.render(Article.find.byId(Long.valueOf(id)))));
            else
                return Application.show404(request().uri().replaceFirst("/", ""));
        } catch (java.lang.NumberFormatException exception) {
            return Application.show400("Sent erroneous input to viewArticle: " + id);
        }
    }

    public static Article getArticle(long articleId) {
        Article article = Article.find.byId(articleId);
        return article;
    }

    public static models.Event getEvent(Article article) {
        controllers.BackupDatabase.index();
        models.Event event = models.Event.find.where().eq("articleId", article.getId()).findUnique();
        return event;
    }

    public static Result joinEvent(String eventId) {
        return ok();
    }

    public static Result abandonEvent(String eventId) {
        return ok();
    }

    /**
     * Writes a comment to the database, with a relation to the given article, and the user currently signed in
     * @param articleId
     * @return
     */

    public static Result comment(String articleId){
        String comment = new HttpRequestData().get("comment");
        Comment newComment = new Comment(comment, Article.find.byId(Long.parseLong(articleId)));
        newComment.save();
        if(new HttpRequestData().get("isEvent") != null){
            return redirect(routes.Event.viewEvent(new HttpRequestData().get("isEvent")).absoluteURL(request()));
        }
        return redirect(routes.ArticleOut.viewArticle(articleId).absoluteURL(request()));
    }

    /**
     * Finds a comment by commentID, and deletes it from the database. Should be protected from misuse by using the POST method
     * through routes.
     * @param commentId
     * @return
     */
    public static Result deleteComment(String commentId){
        Comment thisComment = Comment.find.byId(Long.parseLong(commentId));
        Article article = thisComment.getArticle();
        thisComment.delete();
        if(new HttpRequestData().get("isEvent") != null){
            return redirect(routes.Event.viewEvent(new HttpRequestData().get("isEvent")).absoluteURL(request()));
        }
        return redirect(routes.ArticleOut.viewArticle(article.getId().toString()).absoluteURL(request()));
    }

}
