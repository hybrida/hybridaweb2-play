package models;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ivar on 30.09.2014.
 */

@Entity
public class Feed extends Model {
    @Id
    public Long id;

    public String title;


    @Column(columnDefinition = "text")
    public String article;

}
