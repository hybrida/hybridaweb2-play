package controllers;

import play.mvc.Result;

import static play.mvc.Results.ok;

/**
 * Created by teodorlu on 03.04.15.
 */
public class Quiz {
    public static Result index() {
        return ok(views.html.layoutWithHead.render(
                "Quiz"
                , views.html.Quiz.index.render()
                , views.html.Quiz.head.render()
        ));
    }
}
