package models;

import play.db.ebean.*;

import javax.persistence.*;
import java.util.List;

/**
 * A team participating in the quiz
 */
@Entity
public class QuizTeam extends Model{

    @Id
    @GeneratedValue
    public Long id;

    public String name;

    public String description;

    public static Finder<Long, QuizTeam> find
            = new Finder<Long, QuizTeam>(Long.class, QuizTeam.class);

    public static List<QuizTeam> findAllTeams() {
        return QuizTeam.find.all();
    }
}
