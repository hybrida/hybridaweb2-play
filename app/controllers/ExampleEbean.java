package controllers;

import models.ExampleEbeanEntity;
import models.ExampleEbeanForm;
import models.LolName;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import play.twirl.api.Html;
import views.html.exampleEbean;
import views.html.layoutHtml;

import java.util.ArrayList;
import java.util.List;

import static play.data.Form.form;

/**
 * Created by ivarhk on 30.09.14
 */
public class ExampleEbean extends Controller{

    final static Form<ExampleEbeanForm> form = form(ExampleEbeanForm.class);

    public static Result add(){
        Form<ExampleEbeanForm> input = form.bindFromRequest();
        if(!input.hasErrors()) createEntity(input.get().name);

        return index();
    }

    public static Result index(){
        ArrayList<String> content = new ArrayList<String>();
        content.add(getAll());

        return ok(layoutHtml.render("Ebean Example", exampleEbean.render(Html.apply((getAll())))));
    }

    public static String getAll() {
        List<ExampleEbeanEntity> entities = ExampleEbeanEntity.find.all();
        String returnString = "";
        for (ExampleEbeanEntity entity : entities) returnString += "<p>" + entity.getName() + "</p>";

        return returnString;
    }

    public static void createEntity(String name) {
        ExampleEbeanEntity entity = new ExampleEbeanEntity(name);
        entity.save();
    }

    public static Result clear() {
        List<ExampleEbeanEntity> entities = ExampleEbeanEntity.find.all();
        for (ExampleEbeanEntity entity : entities) entity.delete();

        return Results.redirect(routes.ExampleEbean.index().absoluteURL(request()));
    }

}

