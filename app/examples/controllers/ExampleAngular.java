package examples.controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by teodorlu on 02.04.15.
 */
public class ExampleAngular extends Controller {
    public static Result index() {
//        return ok("Hello, World!");
        return ok(examples.views.html.exampleAngular.render());
    }
}
