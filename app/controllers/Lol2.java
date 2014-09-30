package controllers;

import models.LolForm;
import models.LolName;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;
import views.html.layoutHtml;
import views.html.lolContent2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static play.data.Form.form;

/**
 * Created by eliasbragstadhagen on 06.09.14.
 */
public class Lol2 extends Controller{

    final static Form<LolForm> lolForm = form(LolForm.class);

    public static Result index() throws SQLException, IllegalStateException{
        String name = new String();
        Form<LolForm> input = lolForm.bindFromRequest();
        if(input.hasErrors() == false) {
            name = input.get().gamertag;
        }
        if (name != null) {
            setNameData(name);
        }
        return noindex();
    }
        public static Result noindex() throws SQLException{
            ArrayList<String> content = new ArrayList<String>();
            content.add(getNameData());

            return ok(layoutHtml.render("Anakonda Buns ", lolContent2.render(toHtml(getNameData()))));
        }

    public static Html toHtml(String string){
        return Html.apply(string);
    }

    public static String getNameData() throws SQLException{

        String returnString = "";
        LolName.Finder<String, LolName> finder = new LolName.Finder<String, LolName>(String.class, LolName.class);
        List<LolName> lolNames = finder.all();
        for (LolName lolName : lolNames) {
            returnString += "<p><h1><img src=\"/assets/images/favicon.ico\" alt=\"rect\"/>- " + lolName.getName() + "</h1></p>";
        }
        return returnString;
    }

    public static void setNameData(String name) throws SQLException{

        LolName lolName = new LolName(name);
        lolName.save();
    }

}


