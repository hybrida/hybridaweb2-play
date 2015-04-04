package models;

import play.db.ebean.*;

import javax.persistence.*;
import java.util.List;


/**
 * Quizes are organized into seasons. A winner is announced at the end of a season.
 */
@Entity
public class QuizSeason extends Model {
    @Id
    public Long season;

    public String description;

    public static Finder<Long, QuizSeason> find
            = new Finder<Long, QuizSeason>(Long.class, QuizSeason.class);

    public static List<QuizSeason> findAllSeasons(){
        return QuizSeason.find.all();
    }
}
