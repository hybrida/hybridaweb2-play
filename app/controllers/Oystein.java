package controllers;

import play.mvc.Controller;
import views.html.layout;

import play.mvc.Result;
import java.util.ArrayList;

import static play.mvc.Results.ok;

/**
 * Created by oysteinhauan on 06/09/14.
 */
public class Oystein extends Controller{

    public static Result someCode(String number){
        int num = Integer.parseInt(number);
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i<num; i++){
            list.add("<p><h1>Antall pushups hittil: " + i + "</h1></p>");
        }

        return ok(layout.render("Jassejass", list));

    }
}
