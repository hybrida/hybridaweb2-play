package controllers;

import models.*;
import models.Event;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;
import views.html.utils.centerBlock;

import java.text.ParseException;

import static play.data.Form.form;


public class ArticleIn extends Controller {

    final static Form<Event> eventForm = form(Event.class);
    final static Form<Article> articleForm = form(Article.class);

    public static Result index() {
        return ok(layout.render("Hybrida: Opprett Artikkel", centerBlock.render(views.html.ArticleIn.index.render())));
    }

    public static Result save() {
        try {
            User user = LoginState.getUser();
            if (user == null || !user.canCreateNewArticle())
                return Application.showUnauthorizedAccess();

            long id = saveArticle();

            if(!(new HttpRequestData().get("event") == null)) {
                System.out.println(new HttpRequestData());
                ResultAndEId res = saveEvent(id);
                if (res.result != null)
                    return res.result;
                Renders.addEvent(res.event);
            }
            else {
                // Husk å legge til artikkelen i renders! Da vises den nemlig på fremsiden ^_^
                Renders.addArticle(Article.find.byId(id));
            }
            return redirect(routes.ArticleOut.index("" + id).absoluteURL(request()));
        }
        catch (IllegalStateException e){
            return Application.show400("ugyldig data oppgitt");
        }
    }

    public static long saveArticle() throws IllegalStateException {
        User user = LoginState.getUser();

        Form<Article> articleInput = articleForm.bindFromRequest();
        System.out.println(new HttpRequestData());
        if (!articleInput.hasErrors()) {
            Article articleModel = articleInput.get();
            articleModel.setImagePath(user.uploadPicture());
            articleModel.setAuthor(user.getId());
            articleModel.save();

            return articleModel.getId();
        }
        throw new IllegalStateException();
    }

    public static class ResultAndEId {
        ResultAndEId() {}
        ResultAndEId(Result res) {
            result = res;
        }
        Result result = null;
        Event event = null;
    }

    public static ResultAndEId saveEvent(long articleID){
        HttpRequestData httpData = new HttpRequestData();
        models.Event eventModel = new models.Event();
        java.text.SimpleDateFormat dateFormat;
        java.util.Calendar cal;
        dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");

        cal = java.util.Calendar.getInstance();
        try {
            cal.setTime(dateFormat.parse(httpData.get("secondSignUp")));
            eventModel.setSecondSignUp(cal);
        } catch (ParseException parseExc) {
            return new ResultAndEId(Application.show400("Error in date format in articleIn"));
        }

        cal = java.util.Calendar.getInstance();
        try {
            cal.setTime(dateFormat.parse(httpData.get("eventHappens")));
            eventModel.setEventHappens(cal);
        } catch (ParseException parseExc) {
            return new ResultAndEId(Application.show400("Error in date format in articleIn"));
        }

        cal = java.util.Calendar.getInstance();
        try {
            cal.setTime(dateFormat.parse(httpData.get("signUpDeadline")));
            eventModel.setSignUpDeadline(cal);
        } catch (ParseException parseExc) {
            return new ResultAndEId(Application.show400("Error in date format in articleIn"));
        }

        eventModel.setMaxParticipantsWaiting(Integer.valueOf(httpData.get("maxParticipantsWaiting")));

        eventModel.setMaxParticipantsWaiting(Integer.valueOf(httpData.get("maxParticipantsWaiting")));
        eventModel.setMaxParticipants(Integer.valueOf(httpData.get("maxParticipants")));

        eventModel.setSexAllowed(httpData.get("sexAllowed").charAt(0));

        eventModel.setSecondLowerGraduationLimit(Integer.valueOf(httpData.get("secondLowerGraduationLimit")));
        eventModel.setSecondUpperGraduationLimit(Integer.valueOf(httpData.get("secondUpperGraduationLimit")));
        eventModel.setFirstLowerGraduationLimit(Integer.valueOf(httpData.get("firstLowerGraduationLimit")));
        eventModel.setFirstUpperGraduationLimit(Integer.valueOf(httpData.get("firstUpperGraduationLimit")));

        eventModel.setLocation(httpData.get("location"));
        eventModel.setArticleId(articleID);

        eventModel.save();
        ResultAndEId reid = new ResultAndEId();
        reid.event = eventModel;
        return reid;
    }

}