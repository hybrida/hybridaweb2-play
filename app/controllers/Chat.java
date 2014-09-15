package controllers;

import models.ChatActor;
import play.mvc.Controller;
import akka.actor.*;
import play.mvc.Result;
import play.libs.F.*;
import play.mvc.WebSocket;
import views.html.chatClient;
import views.html.layoutHtml;

/**
 * Created by Tormod on 09.09.2014.
 */
public class Chat extends Controller {

    public static Result connectClient(String name) {
        return ok(layoutHtml.render(name, chatClient.render(name)));
    }

    public static WebSocket<String> socket() {
        return WebSocket.withActor(new Function<ActorRef, Props>() {
            public Props apply(ActorRef out) throws Throwable {
                return ChatActor.props(out);
            }
        });
    }
}