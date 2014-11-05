package controllers;

import models.EventModel;
import models.FeedForm;
import models.HttpRequestData;
import org.apache.commons.io.FileUtils;
import play.mvc.Http;
import play.mvc.Result;
import views.html.*;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import play.db.*;
import play.data.Form;

import static controllers.Lol.toHtml;
import static play.data.Form.form;
import static play.mvc.Controller.request;
import static play.mvc.Results.ok;
import static play.mvc.Results.redirect;
import static play.mvc.Http.Request;

import play.mvc.Controller;

/**
 * Created by eliasbragstadhagen on 04.11.14.
 */
public class Event extends Controller{

    public static Result index(){

        return ok(layoutHtml.render("Hybrida", EventMaker.render()));
    }

    final static Form<EventModel> form = form(EventModel.class);

    public static Result save(){
        Form<EventModel> input = form.bindFromRequest();
        if(!input.hasErrors()){
            input.get().save();
        }
        return index();
    }
    public static Result generateEvent(){
        return ok();
    }
}
