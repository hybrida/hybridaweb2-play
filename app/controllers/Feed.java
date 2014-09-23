package controllers;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;
import views.html.feed;
import views.html.layoutHtml;
import views.html.lolContent;
import java.sql.*;
import play.db.*;
import play.mvc.*;
import models.LolForm;
import play.data.Form;

import static play.mvc.Results.ok;

/**
 * Created by eliasbragstadhagen on 23.09.14.
 */
public class Feed {

    public static Result index(){

        return ok(layoutHtml.render("NewsFeed", feed.render()));
    }

    public static Result save(){
    return ok();
    }
}
