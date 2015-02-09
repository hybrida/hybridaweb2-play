package controllers;

import models.*;
import org.apache.commons.io.FileUtils;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import play.data.Form;

import views.html.layoutHtml;
import views.html.utils.centerBlock;

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
        return ok(layoutHtml.render("Hybrida: Opprett Artikkel", centerBlock.render(views.html.ArticleIn.index.render())));
    }

    public static Result save() {
        try {
            long id = saveArticle();

            if(!(new HttpRequestData().get("event") == null)) {
                saveEvent(id);
                System.out.println("TRUE");
            }
            return redirect(routes.ArticleOut.index("" + id).absoluteURL(request()));
        }
        catch (IllegalStateException e){
            return redirect(routes.Application.show400("error").absoluteURL(request()));

        }
    }

    public static long saveArticle() throws IllegalStateException {
        Form<Article> articleInput = articleForm.bindFromRequest();

        if (!articleInput.hasErrors()) {
            Article articleModel = articleInput.get();

            //Start Imagehandeler
            Http.MultipartFormData body = request().body().asMultipartFormData();
            Http.MultipartFormData.FilePart picture = body.getFile("picture");
            if (picture != null) {
                String contentType = picture.getContentType();
                if (checkImageType(contentType)) {
                    String fileName = picture.getFilename();
                    System.out.println(contentType);
                    File file = picture.getFile();
                    try {
                        FileUtils.moveFile(file, new File("public/Upload", fileName));
                    } catch (IOException ioe) {
                        System.out.println("Problem operating on filesystem");
                    }
                    articleModel.setImagePath(fileName);
                } else {
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

            articleModel.save();

            return articleModel.getId();
        }
        throw new IllegalStateException();
    }

    public static void saveEvent(long articleID){
        Form<Event> eventInput = eventForm.bindFromRequest();
        Event eventModel = eventInput.get();
        eventModel.setArticleId(articleID);
        eventModel.save();

    }

    public static boolean checkImageType(String contentType){
        String[] type = contentType.split("/");
        if(type[0].equals("image")){
            return true;
        }
        return false;
    }
}