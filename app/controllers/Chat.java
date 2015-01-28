package controllers;

import models.ChatActor;
import models.LoginState;
import play.mvc.Controller;
import akka.actor.*;
import play.mvc.Result;
import play.libs.F.*;
import play.mvc.WebSocket;
import views.html.layoutHtml;

/**
 * Created by Tormod on 09.09.2014.
 */
public class Chat extends Controller {
    public static Result connectClient() {
        if (LoginState.isValidlyLoggedIn() == false)
            return redirect(routes.Application.showUnauthorizedAccess());
        return ok(layoutHtml.render("Hybrida Chat", views.html.Chat.connectClient.render(LoginState.getUser().getName())));
    }

    public static WebSocket<String> socket() {
        if (LoginState.isValidlyLoggedIn() == false)
            return null;
        return WebSocket.withActor(new Function<ActorRef, Props>() {
            public Props apply(ActorRef out) throws Throwable {
                return ChatActor.props(out);
            }
        });
    }
}