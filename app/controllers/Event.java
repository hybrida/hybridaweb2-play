package controllers;

import models.*;
import org.apache.commons.io.FileUtils;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import views.html.layout;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static play.data.Form.form;


public class Event extends Controller {

    public static Result index() {
        return ok(layout.render("Hybrida", views.html.Event.index.render()));
    }

    final static Form<EventModel> form = form(EventModel.class);
    private static EventModel model = null;

    public static Result save() {
        Form<EventModel> input = form.bindFromRequest();
        //Image handler:
        if(!input.hasErrors()){
            EventModel model = input.get();
            Http.MultipartFormData body = request().body().asMultipartFormData();
            Http.MultipartFormData.FilePart picture = body.getFile("picture");
            if (picture != null) {
                String contentType = picture.getContentType();
                if(checkImageType(contentType)){
                    String fileName = picture.getFilename();
                    System.out.println(contentType);
                    File file = picture.getFile();
                    try {
                        FileUtils.moveFile(file, new File("public/Upload", fileName));
                    } catch (IOException ioe) {
                        System.out.println("Problem operating on filesystem");
                    }
                    model.setImage_title(fileName);}
                else{
                    model.setImage_title(null);
                }
            } else {
                model.setImage_title(null);
            }
        //End Image Handler
        model.save();
        return redirect(routes.Event.generateEvent(String.valueOf(input.get().getId())).absoluteURL(request()));
        }
        return index();
    }

    public static boolean checkImageType(String contentType){
        String[] type = contentType.split("/");
        if(type[0].equals("image")){
            return true;
        }
        return false;
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
        Boolean signed = isSignedUp();
        contentList.add(signed.toString());
        return ok(layout.render("Hybrida", views.html.Event.generateEvent.render(contentList)));
    }

    public static Result listEvents(){
        List<EventModel> entityList = EventModel.find.all();
        List<List<String>> listedEvents = new ArrayList<List<String>>();
        for(EventModel entity : entityList){
            listedEvents.add(generateEventNews(entity));
        }
        return ok();
    }

    public static List<String> generateEventNews(EventModel entity) {
        List<String> newsEntity = new ArrayList<String>();
        newsEntity.add(entity.getTitle());
        newsEntity.add(entity.getIngress());
        newsEntity.add(entity.getImage_title());
        return newsEntity;
    }

    public static Result updateUser() {
        User user = LoginState.getUser();
        if (user.isDefault()) {
            return controllers.Application.show400("Du må logge inn på nytt.");
        }
        Long event_id = new HttpRequestData().getLong("eventId");
        if (event_id == null) {
            return controllers.Application.show400("Forventet HTTP data nøkkel 'eventId' ikke funnet.");
        }
        models.Event event = models.Event.find.byId(event_id);

        UserEventJoined.insert(user.getId(), event.getEventId());
        return controllers.Application.index();
    }

    public static Result removeUser() {
        User user = LoginState.getUser();
        if (user.isDefault()) {
            return controllers.Application.show400("Du må logge inn på nytt.");
        }
        Long event_id = new HttpRequestData().getLong("eventId");
        if (event_id == null) {
            return controllers.Application.show400("Forventet HTTP data nøkkel 'eventId' ikke funnet.");
        }
        models.Event event = models.Event.find.byId(event_id);

        UserEventJoined.remove(user.getId(), event.getEventId());
        return controllers.Application.index();
    }

    public static Boolean isSignedUp(){
        User user = LoginState.getUser();
        if (user.isDefault()){
            System.out.println("ERROR TO THE MAX");
        }
        Boolean isSignedUp = model.userExists(String.valueOf(user.getId()));
        return isSignedUp;
    }

    public static Result viewEvent(String eventId) {
        if (models.Event.find.byId(Long.valueOf(eventId)) != null) {
            models.Event event = models.Event.find.byId(Long.valueOf(eventId));
            models.Article article = models.Article.find.byId(Long.valueOf(event.getArticleId()));
            return ok(layout.render("Arrangement", views.html.Event.viewEvent.render(article, event)));
        }
        else
            return Application.show404(request().uri().replaceFirst("/", ""));
    }

}
