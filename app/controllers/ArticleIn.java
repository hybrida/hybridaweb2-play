package controllers;

import models.*;
import play.mvc.Result;

import play.data.Form;

import static play.data.Form.form;
import static play.mvc.Controller.request;
import static play.mvc.Results.ok;
import static play.mvc.Results.redirect;

import models.Event;

/**
 * Created by eliasbragstadhagen on 28.01.15.
 */
public class ArticleIn {


    final static Form<Event> eventForm = form(Event.class);
    final static Form<Article> articleForm = form(Article.class);

    public static Result index(){
        return ok();
    }

    public static Result save() {
        Form<Event> eventInput = eventForm.bindFromRequest();
        Form<Article> articleInput = articleForm.bindFromRequest();
        eventInput.get().setArticleId(articleInput.get().getId());
        if (!articleInput.hasErrors() && !eventInput.hasErrors()) {
            Event model = eventInput.get();
            model.save();
            Article model2 = articleInput.get();
            model2.save();
            return redirect(routes.Event.index().absoluteURL(request()));
        }
        return index();
    }
}