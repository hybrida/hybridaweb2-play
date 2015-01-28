package controllers;

import play.mvc.Result;
import play.data.Form;

import static play.data.Form.form;
import static play.mvc.Controller.request;
import static play.mvc.Results.ok;
import static play.mvc.Results.redirect;

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
        return Application.show400("Could not create the event. Boo hoo :(");
    }
}