package controllers;

import models.Company;
import play.*;
import play.mvc.*;
import views.html.*;


import play.db.*;

public class About extends Controller {
	public static Result index() {
        String info = "";
        for (Company c : Company.all())
            info += c.toString() + "\n";

		return ok(showsimple.render("This page is about Hybrida. Company listing: " + info));
	}

    public static Result personInfo(String name) {
        return ok(describe(name));
    }

    public static String describe(String name) {
        if (name.toLowerCase().equals("teodor")){
            return "Teodor er en fyr som studerer på NTNU";
        }

        if (name.toLowerCase().equals("kevin")) {
            return "Kevin is #rect";
        }

        return "Ingen beskrivelse for " + name + "!";
    }
}