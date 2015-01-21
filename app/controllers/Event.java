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
 * Created by eliasbragstadhagen on 04.11.14.
 */
public class Event extends Controller{

    public static Result index(){

        return ok(layoutHtml.render("Hybrida", EventMaker.render()));
    }

    final static Form<EventModel> form = form(EventModel.class);
    private static EventModel model = null;

    public static Result save(){
        Form<EventModel> input = form.bindFromRequest();
        //Image handler:
        if(!input.hasErrors()){
            EventModel model = input.get();
            Http.MultipartFormData body = request().body().asMultipartFormData();
            Http.MultipartFormData.FilePart picture = body.getFile("picture");
            if (picture != null) {
                String fileName = picture.getFilename();
                String contentType = picture.getContentType();
                File file = picture.getFile();
                try {
                    FileUtils.moveFile(file, new File("public/Upload", fileName));
                } catch (IOException ioe) {
                    System.out.println("Problem operating on filesystem");
                }
                model.setImage_title(fileName);
            } else {
                model.setImage_title(null);
            }
        //End Image Handler
        model.save();
        return redirect(routes.Event.generateEvent(String.valueOf(input.get().getId())).absoluteURL(request()));
        }
        return index();
    }
    public static Result generateEvent(String eventId){
        EventModel entity = EventModel.find.byId(eventId);
        model = entity;
        List<String> contentList = new ArrayList<>();
        contentList.add(entity.getTitle());
        contentList.add(entity.getIngress());
        contentList.add(entity.getArticle());
        contentList.add(entity.getImage_title());
        contentList.add(eventId);
        String[] users = entity.getUsers().split(";");
        String userNames = "";
        if (users.length != 0)
        {
            for (String user : users) {
                System.out.println(user);
                if (user != "") {
                    User use = User.find.where().eq("id", Integer.valueOf(user)).findUnique();
                    userNames += use.first_name + " " + use.surname + "<br>";
                }
            }
        }
        contentList.add(userNames);
        return ok(layoutHtml.render("Hybrida", generatedEvent.render(contentList)));
    }
    public static Result listEvents(){
        List<EventModel> entityList = EventModel.find.all();
        List<List<String>> listedEvents = new ArrayList<List<String>>();
        for(EventModel entity : entityList){
            listedEvents.add(generateEventNews(entity));
        }
        return ok();
    }

    public static List<String> generateEventNews(EventModel entity){
        List<String> newsEntity = new ArrayList<String>();
        newsEntity.add(entity.getTitle());
        newsEntity.add(entity.getIngress());
        newsEntity.add(entity.getImage_title());
        return newsEntity;
    }

    public static Result updateUsers(){
        User user = LoginState.getUser();
        if (user == null)
            System.out.println("ERROR TO THE MAX");
        model.addUser(user);
        model.update();
        return redirect(routes.Event.generateEvent(String.valueOf(model.getId())).absoluteURL(request()));
    }

    public static Result removeUsers(){
        User user = LoginState.getUser();
        if ( user == null){
            System.out.println("ERROR TO THE MAX");
        }
        model.removeUser(user);
        model.update();
        return redirect(routes.Event.generateEvent(String.valueOf(model.getId())).absoluteURL(request()));
    }

}
