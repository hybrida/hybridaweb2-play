package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Created by Sindre on 28.01.2015.
 */
@Entity
public class Renders extends Model {

    @OneToOne
    @JoinColumn(name = "article", referencedColumnName = "id")
    public Integer rendered;

    public static Finder<Long, Renders> find = new Finder<>(
            Long.class, Renders.class
    );
}
