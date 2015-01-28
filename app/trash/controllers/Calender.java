package trash.controllers;

import play.mvc.*;


public class Calender extends Controller {
	public static Result index() {
        return redirect("http://en.wikipedia.org/wiki/Calender");
	}
}