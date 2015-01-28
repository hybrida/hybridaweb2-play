package models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Ivar on 16.09.2014.
 */
@Entity
public class Article extends Model {

    @Id
    @GeneratedValue
    private Integer     id;
    private String      title;
    private String      ingress;
    private String      text;
    private User        author;
    @CreatedTimestamp
    private Timestamp   dateMade;
    private String      imagePath;

    public Article(String title, String text,String ingress, User author, String imagepath) {
        this.title = title;
        this.text = text;
        this.ingress = ingress;
        this.author = author;
        this.imagePath = imagepath;
    }

    public String getTitle() { return title; }

    public String getIngress() { return ingress; }

    public String getText() { return text;}

    public String getAuthorName() { return author.getName(); }

    public Date getDateMade() { return new Date(dateMade.getTime()); }

    public String getImagepath() { return imagePath;}

    public Integer getId() { return id;}

    public User getAuthor() {    return author; }

    public static Finder<Long, Article> find = new Finder<>(
        Long.class, Article.class
    );
}
