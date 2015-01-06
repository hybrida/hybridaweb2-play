package models;

import javax.persistence.Entity;
import play.data.validation.Constraints;
import play.db.ebean.Model;

/**
 * Created by eliasbragstadhagen on 23.09.14.
 */
@Entity
public class FeedForm extends Model {
    public String imageTitle;
    public String ingress;
    @Constraints.Required
    public String title;
    public String article;

}
