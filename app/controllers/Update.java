package controllers;

import play.mvc.Result;
import views.html.layoutHtml;
import views.html.update;

import static play.mvc.Results.TODO;
import static play.mvc.Results.ok;

/**
 * Created by Sindre on 30.09.2014.
 */
public class Update {


    public static Result index(){

        return ok(layoutHtml.render("Update!", update.render()));
    }

    public static Result utgaver(){
        return TODO;
    }
    public static Result redaksjon(){
        return TODO;
    }
}
