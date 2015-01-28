package controllers;

import models.*;
import org.apache.commons.io.FileUtils;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import play.data.Form;

import views.html.layoutHtml;

import static play.data.Form.form;

import models.Event;

import java.io.File;
import java.io.IOException;

/**
 * Created by eliasbragstadhagen on 28.01.15.
 */
public class ArticleIn extends Controller {


    final static Form<Event> eventForm = form(Event.class);
    final static Form<Article> articleForm = form(Article.class);

    public static Result index(){
        return ok(layoutHtml.render("Hybrida: Opprett Artikkel", views.html.ArticleIn.index.render()));
    }

    public static Result save() {
        Form<Event> eventInput = eventForm.bindFromRequest();
        Form<Article> articleInput = articleForm.bindFromRequest();

        if (!articleInput.hasErrors() && !eventInput.hasErrors()) {

            //Start Imagehandeler
            Http.MultipartFormData body = request().body().asMultipartFormData();
            Http.MultipartFormData.FilePart picture = body.getFile("picture");
            Event eventModel = eventInput.get();
            Article articleModel = articleInput.get();
            if (picture != null) {
                String contentType = picture.getContentType();
                if(checkImageType(contentType)){
                    String fileName = picture.getFilename();
                    System.out.println(contentType);
                    File file = picture.getFile();
                    try {
                        FileUtils.moveFile(file, new File("public/Upload", fileName));
                    } catch (IOException ioe) {
                        System.out.println("Problem operating on filesystem");
                    }
                    articleModel.setImagePath(fileName);}
                else{
                    articleModel.setImagePath(null);
                }
            } else {
                articleModel.setImagePath(null);
            }
            //End Imagehandeler
            //SetAuthor
            User user = LoginState.getUser();
            if (user == null)
                System.out.println("ERROR TO THE MAX");
            articleModel.setAuthor(user.getID());
            //EndSetAuthor

            //TODO HttpRequestData.get().getButton(ellernoe) - sjekke om event er valgt, slik at data ikke lagres unødvendig.

            articleModel.save();
            eventModel.setArticleId(articleModel.getId());
            eventModel.save();

            return redirect(routes.Event.index().absoluteURL(request()));
        }
        return index();
    }

    public void saveArticle(){

    }
    public void saveEvent(long articleID){

    }

    public static boolean checkImageType(String contentType){
        String[] type = contentType.split("/");
        if(type[0].equals("image")){
            return true;
        }
        return false;
    }
}