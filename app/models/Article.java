package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.Date;

import java.util.*;
import javax.persistence.*;

/**
 * Created by Ivar on 16.09.2014.
 */
@Entity
public class Article extends Model {
    private String title;
    private String content;
    private User author;
    private Timestamp posted;

    public Article(String title, String content, User author, Timestamp posted) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.posted = posted;
    }

    public String getTitle() { return title; }

    public String getContent() { return content; }

    public String getAuthorName() { return author.getName(); }

    public Date getPosted() { return new Date(posted.getTime()); }

    public static Finder<Long, Article> find = new Finder<>(
            Long.class, Article.class
    );
}
