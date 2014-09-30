package controllers;

import play.mvc.Http;
import views.html.ImUpView;
import play.mvc.Result;

import java.io.File;

import static play.mvc.Controller.flash;
import static play.mvc.Controller.request;
import static play.mvc.Results.ok;
import static views.html.layoutHtml.*;

/**
 * Created by eliasbragstadhagen on 29.09.14.
 */
public class ImageUploadExample {

    public static Result index(){
       return ok(render("Image", ImUpView.render()));
    }

    public static Result upload() {
        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart picture = body.getFile("picture");
        if (picture != null) {
            String fileName = picture.getFilename();
            String contentType = picture.getContentType();
            File file = picture.getFile();
            return ok("Upload Successful");
        } else {
            flash("error", "Missing file");
            return ok("file missing");
        }
    }


}
