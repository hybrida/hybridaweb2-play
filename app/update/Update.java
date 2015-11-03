package update;

import org.apache.commons.io.FileUtils;
import play.mvc.Http;
import play.mvc.Result;
import views.html.layout;

import java.io.*;
import java.util.ArrayList;

import static play.mvc.Controller.flash;
import static play.mvc.Controller.request;
import static play.mvc.Results.TODO;
import static play.mvc.Results.ok;


public class Update {

    public static Result index() throws FileNotFoundException {


        return ok(layout.render("Update!", update.views.html.index.render(getThumbnails())));
    }

    public static Result post() throws FileNotFoundException {
        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart picture = body.getFile("picture");
        if (picture != null && picture.getContentType().contains("pdf")) {
            String fileName = picture.getFilename().replaceAll("[^\\w\\.]+","");
            String thumbName = fileName.substring(0,fileName.length()-4)+".png";
            String gsArgs = "-sDEVICE=png16m ";
            String contentType = picture.getContentType();
            File file = picture.getFile();
            try {
                FileUtils.moveFile(file, new File("public/update", fileName));
                Runtime.getRuntime().exec("gs " + gsArgs + "-o public/update/" + thumbName + " public/update/" + fileName);

            } catch (IOException ioe) {
                System.out.println("Problem operating on filesystem");
            }
            String[] asdf = new String[1];
            asdf[0] = thumbName;
            return ok(layout.render("img", update.views.html.index.render(getThumbnails())));
        }else if (picture != null) {
            flash("error", "Invalid file");
            return ok("Invalid file, accepted format: pdf");
        }

        else {
            flash("error", "Missing file");
            return ok("file missing");
        }
    }

    public static String[] getThumbnails() {
        File[] folder = new File("public/update").listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));
        String[] filenames = new String[folder.length];
        int i;
        for(i = 0; i < folder.length; i++) {
            filenames[i] = folder[i].getName().substring(0,folder[i].getName().length()-4);
        }
        return filenames;
    }

    public static Result utgaver() {
        return TODO;
    }
    public static Result redaksjon() {
        return TODO;
    }
}
