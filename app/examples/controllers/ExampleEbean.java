package examples.controllers;

import examples.models.ExampleEbeanEntity;
import examples.models.ExampleEbeanForm;
import examples.views.html.exampleEbean;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;
import views.html.layout;

import java.util.ArrayList;
import java.util.List;

import static play.data.Form.form;

public class ExampleEbean extends Controller {

    final static Form<ExampleEbeanForm> form = form(ExampleEbeanForm.class);

    public static Result add() {
        Form<ExampleEbeanForm> input = form.bindFromRequest();
        if (!input.hasErrors()) createEntity(input.get().name);

        return index();
    }

    public static Result index() {
        ArrayList<String> content = new ArrayList<String>();
        content.add(getAll());

        return ok(layout.render("Ebean Example", exampleEbean.render(Html.apply((getAll())))));
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

        return TODO; //Results.redirect(ExampleEbean.index().absoluteURL(request()));
    }

}


