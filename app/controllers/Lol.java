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
        content.add("<h1> Hybrida proffetional MLG diamond leauge Lol team:<h1> <p> <p>");
        content.add("Dj Syndeflood <p>");
        if (name != null){
            content.add(name);
            content.add("<p>");
        }
        return ok(layout.render("Hybrida MLG proffesional LoL team: ", content));
    }
}


