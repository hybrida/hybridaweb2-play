package bedkomdatabase.models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.*;
import com.avaje.ebean.*;
import play.db.ebean.Model;
import play.twirl.api.Html;

import javax.persistence.*;
import java.lang.Override;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import models.*;
import play.data.validation.Constraints;

@Entity
public class Bedrift extends Model {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false)
    long bedriftId;

    @CreatedTimestamp
    private Timestamp dateMade;

    @UpdatedTimestamp
    private Timestamp whenUpdated;

    private String bedriftName;

    private User responsible; //defines the user responsible for contacting this company.

    @Constraints.Max(10)
    @Constraints.Min(0)
    private int priority;

    @OneToMany
    private List<Contact> contacts;

    @OneToMany
    private List<Note> notes;


    public Bedrift(String bedriftName, int priority, User responsible){
        this.bedriftName = bedriftName;
        this.priority = priority;
        this.responsible = responsible;
    }

    public Timestamp getDateMade() {
        return dateMade;
    }

    public Timestamp getWhenUpdated() {
        return whenUpdated;
    }

    public String getBedriftName() {
        return bedriftName;
    }

    public void setBedriftName(String bedriftName) {
        this.bedriftName = bedriftName;
    }

    public User getResponsible() {
        return responsible;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public static Finder<Long, Bedrift> find = new Finder<>(
            Long.class, Bedrift.class
    );


}
