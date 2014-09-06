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
        return ok(describe(name.toLowerCase()));
    }

    public static String describe(String name) {
        if (name.equals("teodor")) {
            return "Teodor er en fyr som studerer på NTNU";
        } else if (name.equals("simen")){
            return "Simen er den eneste i Norge som heter Simen Norderud Jensen";
        } else if (name.equals("henrik")){
            return "Henrik er selverklært norgesmester i LoL";
        } else if (name.equals("kevin")) {
            return "Kevin is #rect";
        } else if (name.toLowerCase().equals("elias")){
            return "Elias er en kjernekar! Han skal progge hybrida-app!";
        } else if (name.toLowerCase().equals("oystein")){
            return "Øystein er en trivelig type, født og oppvokst i strengkassa på et piano/n" +
                    "for øyeblikket spiller han i Hybridas eget stolte linjeband, Ståpels";
        }

        return "Ingen beskrivelse for " + name + "!";
    }
}