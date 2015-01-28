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

import play.mvc.Controller;

/**
 * Created by eliasbragstadhagen on 28.01.15.
 */
public class EventWIP {


    final static Form<Event> form = form(Event.class);
    private static Event model = null;

    public static Result index(){
        return ok();
    }

    public static Result save() {
        Form<Event> input = form.bindFromRequest();
        if (!input.hasErrors()) {
            Event model = input.get();
            model.save();
            return redirect(routes.Event.index().absoluteURL(request()));
        }
        return index();
    }
}