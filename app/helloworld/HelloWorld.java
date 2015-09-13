package helloworld;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

/**
 * Created by ivar on 13.09.2015.
 */
public class HelloWorld extends Controller {

    public static Result index() {
        return ok(layout.render("Hello World", helloworld.views.html.index.render()));
    }
}
