package models;

import akka.actor.*;
import play.libs.Akka;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tormod on 12.09.2014.
 */
public class ChatActor extends UntypedActor {
    private static List<ChatActor> clients = new ArrayList<ChatActor>();
    //private final String name;

    public static Props props(ActorRef out) {
        return Props.create(ChatActor.class, out);
    }

    private final ActorRef out;

    public ChatActor(ActorRef out) {
        this.out = out;
        clients.add(this);
        //this.name = "Anonymous";
        tellAll("%A chatter connected");
    }

    private void tellAll(String message) {
        for (ChatActor client : clients) {
            if (!client.equals(this)) client.out.tell(message, self());
        }
    }

    public void postStop() throws Exception {
        clients.remove(this);
        tellAll("%A chatter disconnected");
    }

    public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            message = ((String) message).replace('%','\0');
            tellAll((String) message);
        }
    }
}
