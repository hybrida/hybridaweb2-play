package controllers;

import org.apache.commons.io.FileUtils;
import play.mvc.Http;
import play.mvc.Result;
import views.html.layoutHtml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static trash.controllers.Lol.toHtml;
import static play.mvc.Controller.flash;
import static play.mvc.Controller.request;
import static play.mvc.Results.TODO;
import static play.mvc.Results.ok;

/**
 * Created by Sindre on 30.09.2014.
 */
public class Update {


    public static Result index(){

        return ok(layoutHtml.render("Update!", views.html.Update.index.render()));
    }


    public static Result post() throws FileNotFoundException {
        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart picture = body.getFile("picture");
        if (picture != null && picture.getContentType().contains("pdf")) {
            String fileName = picture.getFilename();
            String contentType = picture.getContentType();
            File file = picture.getFile();
            try{
                FileUtils.moveFile(file, new File("public/update", fileName));
            } catch (IOException ioe) {
                System.out.println("Problem operating on filesystem");
            }

            return ok(layoutHtml.render("img",toHtml("Upload Successful" + "<img src=\"/assets/update/" + fileName + "\" alt=\"rect\"/>")));
        }else if(picture != null){
            flash("error", "Invalid file");
            return ok("Invalid file, accepted format: pdf");
        }

        else {
            flash("error", "Missing file");
            return ok("file missing");
        }
    }

    public static Result utgaver(){
        return TODO;
    }
    public static Result redaksjon(){
        return TODO;
    }
}
