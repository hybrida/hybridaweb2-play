package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

import java.util.ArrayList;

/**
 * Created by eliasbragstadhagen on 06.09.14.
 */
public class Lol extends Controller{
    public static Result index(String name){
        ArrayList<String> content = new ArrayList<>();
        content.add("<img src=\"/assets/images/mlg.jpg\" alt=\"rect\">");
        content.add("<h1> Hybrida proffesional MLG diamond league Lol team:<h1> <p> <p>");
        content.add("Dj Syndeflood <p>");
        if (name != null){
            content.add(name);
            content.add("<p>");
        }

        return ok(layout.render("Hybrida MLG proffesional LoL team: ", content));
    }
        public static Result noindex(){
            ArrayList<String> content = new ArrayList<>();
            content.add("<img src=\"/assets/images/mlg.jpg\" alt=\"rect\">");
            content.add("<h1> Hybrida proffesional MLG diamond league Lol team:<h1> <p> <p>");
            content.add("Dj Syndeflood <p>");

            return ok(layout.render("Hybrida MLG proffesional LoL team: ", content));
        }
}


