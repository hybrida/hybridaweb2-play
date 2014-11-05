package controllers;

import org.apache.commons.io.FileUtils;
import play.api.mvc.Call;
import play.mvc.Http;
import views.html.ImUpView;
import play.mvc.Result;
import views.html.layoutHtml;

import java.awt.image.BufferedImage;
import java.io.*;

import static controllers.Lol.toHtml;
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

    static final Call savePlace = routes.Assets.at("Upload");

    public static Result upload() throws FileNotFoundException {
        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart picture = body.getFile("picture");
        if (picture != null) {
            String fileName = picture.getFilename();
            String contentType = picture.getContentType();
            File file = picture.getFile();
            try{
                FileUtils.moveFile(file, new File("public/Upload", fileName));
            } catch (IOException ioe) {
                System.out.println("Problem operating on filesystem");
            }

            return ok(layoutHtml.render("img",toHtml("Upload Successful" + "<img src=\"/assets/Upload/" + fileName + "\" alt=\"rect\"/>")));
        } else {
            flash("error", "Missing file");
            return ok("file missing");
        }
    }
}
