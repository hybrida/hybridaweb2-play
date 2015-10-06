package gallery;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

import java.util.ArrayList;

/**
 * Created by Tormod on 06.10.2015.
 */
public class Gallery extends Controller {
    public static Result display() {
        ArrayList<String> images = new ArrayList<>();
        images.add("a");
        return ok(layout.render("Galleri", gallery.views.html.gallery.render(images)));
    }

    public static boolean upload() {
        return false;
    }

    public static boolean upload(String arr) {
        return false;
    }
}
