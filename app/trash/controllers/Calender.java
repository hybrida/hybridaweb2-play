package trash.controllers;

import models.Company;
import play.*;
import play.mvc.*;
import views.html.*;


import play.db.*;


public class Calender extends Controller {
	public static Result index() {
        return redirect("http://en.wikipedia.org/wiki/Calender");
	}
}