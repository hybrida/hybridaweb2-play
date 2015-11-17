package update;

import org.apache.commons.io.FileUtils;
import play.mvc.Http;
import play.mvc.Result;
import views.html.layout;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

import static play.mvc.Controller.flash;
import static play.mvc.Controller.request;
import static play.mvc.Results.TODO;
import static play.mvc.Results.ok;


public class Update {

    public static Result index() throws FileNotFoundException {
        String[] foldernamess = new File("restricted/innlogget/update").list((dir, name) -> !name.contains("."));
        Arrays.sort(foldernamess, Comparator.<String>reverseOrder());
        HashMap<String, String[]> folders = new HashMap<String, String[]>();
        for (String foldername : foldernamess) {
            folders.put(foldername, new File("restricted/innlogget/update/"+foldername).list((dir, name) -> name.toLowerCase().endsWith(".png")));
        }

        return ok(layout.render("Update!", update.views.html.index.render(foldernamess, folders)));
    }
    //"gs -sDEVICE=png16m -o public/update/" + thumbName + " public/update/" + fileName r243x313

    public static Result utgaver() {
        return TODO;
    }
    public static Result redaksjon() {
        return TODO;
    }
}
