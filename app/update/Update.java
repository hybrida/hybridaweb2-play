package update;

import play.mvc.Result;
import views.html.layout;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

import static play.mvc.Results.TODO;
import static play.mvc.Results.ok;


public class Update {

    public static Result index() throws FileNotFoundException {
        String[] foldernamess = new File("restricted/loggedin/update").list((dir, name) -> !name.contains("."));
        Arrays.sort(foldernamess, Comparator.<String>reverseOrder());
        HashMap<String, String[]> folders = new HashMap<String, String[]>();
        for (String foldername : foldernamess) {
            String[] files =  new File("restricted/loggedin/update/"+foldername).list((dir, name) -> name.toLowerCase().endsWith(".png"));
            Arrays.sort(files, Comparator.<String>reverseOrder());
            folders.put(foldername, files);
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
