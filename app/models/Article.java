package models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Article extends Model {

    @Id
    @GeneratedValue
    private Long        id;
    private String      title;
    private String      ingress;
    private String      text;
    @OneToOne
    private Long        author;
    @CreatedTimestamp
    private Timestamp   dateMade;
    private String      imagePath;

    public Article(String title, String text,String ingress, Long author_id, String imagepath) {
        this.title = title;
        this.text = text;
        this.ingress = ingress;
        this.author = author_id;
        this.imagePath = imagepath;
    }

    public String getTitle() { return title; }

    public String getIngress() { return ingress; }

    public String getText() { return text;}

    public Date getDateMade() { return new Date(dateMade.getTime()); }

    public String getImagepath() { return imagePath;}

    public Long getId() { return id;}

    public Long getAuthor() {    return author; }

    public static Finder<Long, Article> find = new Finder<>(
        Long.class, Article.class
    );
}
