package models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.db.ebean.*;

/**
 * A single quiz event where the quizMaster makes the questions
 */
public class Quiz extends Model{

    @Id
    @GeneratedValue
    public Long id;

    public QuizTeam quizMaster;

    public QuizSeason quizSeason;

    public long timeStamp;
}
