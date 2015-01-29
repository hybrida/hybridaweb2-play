package trash.models;

import models.User;
import play.db.ebean.Model;

import javax.persistence.*;

/**
 * Created by eliasbragstadhagen on 04.11.14.
 */
@Entity
public class EventModel extends Model{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    private String title;
    private String image_title;
    private String article;
    private String ingress;
    private int antall; //Antall som får være med!
    private String users;
    //TODO lage klasser for synlighet og tilgang, samt lagring av påmeldte

    public EventModel(){
        //users = new ArrayList<User>();
        users = "";
    }

    public static Finder<String, EventModel> find = new Finder<String, EventModel> (
            String.class, EventModel.class
    );

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_title() {
        return image_title;
    }

    public void setImage_title(String image_title) {
        this.image_title = image_title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getIngress() {
        return ingress;
    }

    public void setIngress(String ingress) {
        this.ingress = ingress;
    }

    public int getAntall() {
        return antall;
    }

    public void setAntall(int antall) {
        this.antall = antall;
    }
    public long getId(){
        return id;
    }

    public void addUser(User user){
        if(!userExists(String.valueOf(user.getID()))) {
            users += user.getID() + ";";
        }
    }

    public String getUsers(){
        return users;
    }
    public boolean userExists(String id){
        String[] user = users.split(";");
        for(String i : user){
            if (id.equals(i)){
                return true;
            }
        }
        return false;
    }

    public void removeUser(User user){
        String tempUsers = "";
        if(userExists(String.valueOf(user.getID()))){
            String[] bruker = users.split(";");
            for(String i : bruker){
                if(!i.equals(user.getID())){
                    tempUsers += i + ";";
                }
            }
            this.users = tempUsers;
        }
    }
}
