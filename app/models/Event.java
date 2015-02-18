package models;

import play.db.ebean.Model;
import play.twirl.api.Html;
import views.html.Article.articleRender;
import views.html.utils.escapeText;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by eliasbragstadhagen on 28.01.15.
 */
@Entity
public class Event extends Model implements Renderable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false)
    private long eventId;

    @OneToOne // This is a foreign key. It points to an "Article".
    private long articleId;

    private int timeFrame;
    private String location;

    private int firstUpperGraduationLimit;
    private int firstLowerGraduationLimit;
    private int secondUpperGraduationLimit;
    private int secondLowerGraduationLimit;

    private char sexAllowed;

    private int maxParticipants;
    private int maxParticipantsWaiting;

    private Calendar signUpDeadline;
    private Calendar eventHappens;
    private Calendar secondSignUp;

    public static Finder<Long, Event> find = new Finder<Long, Event> (
            Long.class, Event.class
    );

    public long getEventId() {
        return eventId;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public int getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(int timeFrame) {
        this.timeFrame = timeFrame;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getFirstUpperGraduationLimit() {
        return firstUpperGraduationLimit;
    }

    public void setFirstUpperGraduationLimit(int firstUpperGraduationLimit) {
        this.firstUpperGraduationLimit = firstUpperGraduationLimit;
    }

    public int getFirstLowerGraduationLimit() {
        return firstLowerGraduationLimit;
    }

    public void setFirstLowerGraduationLimit(int firstLowerGraduationLimit) {
        this.firstLowerGraduationLimit = firstLowerGraduationLimit;
    }

    public int getSecondUpperGraduationLimit() {
        return secondUpperGraduationLimit;
    }

    public void setSecondUpperGraduationLimit(int secondUpperGraduationLimit) {
        this.secondUpperGraduationLimit = secondUpperGraduationLimit;
    }

    public int getSecondLowerGraduationLimit() {
        return secondLowerGraduationLimit;
    }

    public void setSecondLowerGraduationLimit(int secondLowerGraduationLimit) {
        this.secondLowerGraduationLimit = secondLowerGraduationLimit;
    }

    public char getSexAllowed() {
        return sexAllowed;
    }

    public void setSexAllowed(char sexAllowed) {
        this.sexAllowed = sexAllowed;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public int getMaxParticipantsWaiting() {
        return maxParticipantsWaiting;
    }

    public void setMaxParticipantsWaiting(int maxParticipantsWaiting) {
        this.maxParticipantsWaiting = maxParticipantsWaiting;
    }

    public Calendar getSignUpDeadline() {
        return signUpDeadline;
    }

    public void setSignUpDeadline(Calendar signUpDeadline) {
        this.signUpDeadline = signUpDeadline;
    }

    public Calendar getEventHappens() {
        return eventHappens;
    }

    public void setEventHappens(Calendar eventHappens) {
        this.eventHappens = eventHappens;
    }

    public Calendar getSecondSignUp() {
        return secondSignUp;
    }

    public void setSecondSignUp(Calendar secondSignUp) {
        this.secondSignUp = secondSignUp;
    }

    public Html renderFrontPageSample() {
        Article article = Article.find.byId(this.articleId);
        return articleRender.render(article);
    }

    public Html renderFull() {
        return Html.apply("NOT IMPLEMENTED");
    }
}
