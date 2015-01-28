package models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by eliasbragstadhagen on 28.01.15.
 */
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "eventId", nullable = false)
    private long eventId;

    private int timeFrame;
    private String location;

    private int firstUpperGraduationLimit;
    private int firstLowerGraduationLimit;
    private int secondUpperGraduationLimit;
    private int secondLowerGraduationLimit;

    private char sexAllowed;

    private int maxParticipants;
    private int maxParticipantsWaiting;

    private Date signUpDeadline;
    private Date eventHappens;
    private Date secondSignUp;

    public long getEventId() {
        return eventId;
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

    public Date getSignUpDeadline() {
        return signUpDeadline;
    }

    public void setSignUpDeadline(Date signUpDeadline) {
        this.signUpDeadline = signUpDeadline;
    }

    public Date getEventHappens() {
        return eventHappens;
    }

    public void setEventHappens(Date eventHappens) {
        this.eventHappens = eventHappens;
    }

    public Date getSecondSignUp() {
        return secondSignUp;
    }

    public void setSecondSignUp(Date secondSignUp) {
        this.secondSignUp = secondSignUp;
    }
}
