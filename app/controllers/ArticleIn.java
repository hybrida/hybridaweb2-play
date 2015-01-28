package controllers;

import models.*;
import org.apache.commons.io.FileUtils;
import play.mvc.Http;
import play.mvc.Result;
import play.twirl.api.Html;
import views.html.*;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import play.db.*;
import play.data.Form;

import static controllers.Lol.toHtml;
import static play.data.Form.form;
import static play.mvc.Controller.request;
import static play.mvc.Results.ok;
import static play.mvc.Results.redirect;
import static play.mvc.Http.Request;
import models.Event;

import play.mvc.Controller;

/**
 * Created by eliasbragstadhagen on 28.01.15.
 */
public class ArticleIn {


    final static Form<Event> eventForm = form(Event.class);
    final static Form<Article> articleForm = form(Article.class);

    public static Result index(){
        return ok(layout.render(articleIn.render()));
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