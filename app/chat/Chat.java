package chat;

import akka.actor.ActorRef;
import akka.actor.Props;
import models.ChatActor;
import models.LoginState;
import play.libs.F.Function;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;
import views.html.layout;

/**
 * Created by Tormod on 09.09.2014.
 */
public class Chat extends Controller {
	public static Result connectClient() {
		if (LoginState.isValidlyLoggedIn() == false)
			return application.Application.showUnauthorizedAccess();
		return ok(layout.render("Hybrida Chat",
			chat.views.html.connectClient.render(LoginState.getUser().getName())));
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
