package gallery;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

/**
 * Created by Tormod on 06.10.2015.
 */
public class Gallery {
    public static Result display() {
        return play.mvc.Controller.ok(layout.render("Galleri", gallery.views.html.gallery.render()));
    }

    public static void upload() {

    }
}
