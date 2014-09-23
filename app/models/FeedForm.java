package models;

import javax.persistence.Entity;
import play.data.validation.Constraints;

/**
 * Created by eliasbragstadhagen on 23.09.14.
 */
@Entity
public class FeedForm {
    @Constraints.Required
    public String title;
    public String article;
}
