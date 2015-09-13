package quiz.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.db.ebean.*;

/**
 * A quizTeamScore is a single team's score during a quiz
 */
public class QuizTeamScore extends Model {
    @Id
    @GeneratedValue
    public Long id;

    public Quiz quiz;

    public QuizTeam team;

    public int score;
}
