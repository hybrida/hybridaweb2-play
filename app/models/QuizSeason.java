package models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.db.ebean.*;

import java.util.List;

/**
 * Quizes are organized into seasons. A winner is announced at the end of a season.
 */
public class QuizSeason extends Model {
    @Id
    @GeneratedValue
    public Long id;

    public int season;

    public List<Quiz> quizes;
}
