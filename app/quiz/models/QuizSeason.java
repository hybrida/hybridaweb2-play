package quiz.models;

import play.db.ebean.*;

import javax.persistence.*;
import java.util.List;


/**
 * Quizes are organized into seasons. A winner is announced at the end of a seasonNumber.
 */
@Entity
public class QuizSeason extends Model {
    @Id
    public Long id;

    @Column(unique = true)
    public Long seasonNumber;

    public String description;

    public static Finder<Long, QuizSeason> find
            = new Finder<Long, QuizSeason>(Long.class, QuizSeason.class);

    public static List<QuizSeason> findAllSeasons(){
        return QuizSeason.find.all();
    }

    public static QuizSeason findById(Long id) {
        return find.byId(id);
    }
}
