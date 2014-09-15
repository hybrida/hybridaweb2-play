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
    private String name = null;

    public ChatActor(ActorRef out) {
        this.out = out;
        //this.name = "Anonymous";
        //tellAll("%A chatter connected");
    }

    private void tellAll(String message) {
        for (ChatActor client : clients) {
            if (!client.equals(this)) client.out.tell(message, self());
        }
    }

    public void postStop() throws Exception {
        clients.remove(this);
        tellAll("%" + name + " disconnected");
    }

    public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            if (name == null) {
                name = (String) message;
                tellAll("%" + name + " connected");

                String welcome_message = "%Welcome " + name + "!\n";
                for (int i = 0; i < clients.size(); ++i) {
                    ChatActor client = clients.get(i);
                    if (client.equals(this)) continue;
                    else if (i < clients.size()-2)
                        welcome_message += client.name + ", ";
                    else if (i < clients.size()-1)
                        welcome_message += client.name + " and ";
                    else
                    if (clients.size()==1)
                        welcome_message += client.name + " is currently online!";
                    else
                        welcome_message += client.name + " are currently online!";
                }

                clients.add(this);
                out.tell(welcome_message, self());

            } else {
                message = ((String) message).replace('%', '\0');
                tellAll(name + ": " + message);
            }
        }
    }
}
