package controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Tormod on 09.09.2014.
 */
public class Loop extends Controller {
    public static Result goThere() {
        return redirect("/GoBack");
    }

    public static Result goBack() {
        return redirect("/GoThere");
    }
}