package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

import java.util.ArrayList;

/**
 * Created by eliasbragstadhagen on 06.09.14.
 */
public class Lol extends Controller{
    public static Result index(){
        ArrayList<String> content = new ArrayList<String>();
        content.add("Dj Syndeflood");
        return ok(layout.render("Hybrida MLG proffesional LoL team", content));
        }
    }
