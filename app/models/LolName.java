package models;

import play.db.ebean.Model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Ivar on 30.09.2014.
 */
@Entity
public class LolName extends Model {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public LolName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}