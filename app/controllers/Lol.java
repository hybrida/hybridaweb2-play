package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;
import views.html.layoutHtml;
import views.html.lolContent;

import java.util.ArrayList;

/**
 * Created by eliasbragstadhagen on 06.09.14.
 */
public class Lol extends Controller{

    public static ArrayList<String> savedNames = new ArrayList<String>();

    public static Result index(String name){
        for (int i = 0; i < savedNames.size(); i++ ){
            content.add(savedNames.get(i));
        }
        if (name != null){
            content.add(name + "<p>");
            savedNames.add(name + "<p>");

        }

        return ok(layoutHtml.render("Hybrida MLG proffesional LoL team: ", lolContent.render(content)));
    }
        public static Result noindex(){
            ArrayList<String> content = new ArrayList<String>();
            for (int i = 0; i < savedNames.size(); i++ ){
                content.add(savedNames.get(i));
            }

            return ok(layoutHtml.render("Hybrida MLG proffesional LoL team: ", lolContent.render(content)));
        }

    public static Html toHtml(ArrayList<String> list){

        String string = "";
        for (int i = 0; i < list.size(); i++){
            string += list.get(i);
        }
        return play.twirl.api.Html.apply(string);
    }

}


