package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by eliasbragstadhagen on 04.11.14.
 */
@Entity
public class EventModel extends Model{
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String image_title;
    private String article;
    private String ingress;
    private int antall; //Antall som får være med!
    //TODO lage klasser for synlighet og tilgang

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
}
