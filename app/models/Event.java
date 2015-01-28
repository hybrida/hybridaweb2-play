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

    private int timeframe;
    private String location;

    private int firstUpperGraduationLimit;
    private int firstLowerGraduationLimit;
    private int secoundUpperGraduationLimit;
    private int secoundLowerGraduationLimit;

    private char sexAllowed;

    private int max_participants;
    private int max_participants_waiting;

    private Date signUpDeadline;
    private Date eventHappens;
    private Date secoundSignUp;

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public int getTimeframe() {
        return timeframe;
    }

    public void setTimeframe(int timeframe) {
        this.timeframe = timeframe;
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

    public int getSecoundUpperGraduationLimit() {
        return secoundUpperGraduationLimit;
    }

    public void setSecoundUpperGraduationLimit(int secoundUpperGraduationLimit) {
        this.secoundUpperGraduationLimit = secoundUpperGraduationLimit;
    }

    public int getSecoundLowerGraduationLimit() {
        return secoundLowerGraduationLimit;
    }

    public void setSecoundLowerGraduationLimit(int secoundLowerGraduationLimit) {
        this.secoundLowerGraduationLimit = secoundLowerGraduationLimit;
    }

    public char getSexAllowed() {
        return sexAllowed;
    }

    public void setSexAllowed(char sexAllowed) {
        this.sexAllowed = sexAllowed;
    }

    public int getMax_participants() {
        return max_participants;
    }

    public void setMax_participants(int max_participants) {
        this.max_participants = max_participants;
    }

    public int getMax_participants_waiting() {
        return max_participants_waiting;
    }

    public void setMax_participants_waiting(int max_participants_waiting) {
        this.max_participants_waiting = max_participants_waiting;
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

    public Date getSecoundSignUp() {
        return secoundSignUp;
    }

    public void setSecoundSignUp(Date secoundSignUp) {
        this.secoundSignUp = secoundSignUp;
    }
}
