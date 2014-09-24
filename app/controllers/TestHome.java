package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class TestHome extends Controller{

    public static Result indexTest(){

        return ok(testHome.render("testhome","asdf"));
    }
}
