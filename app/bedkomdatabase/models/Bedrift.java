package bedkomdatabase.models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.*;
import com.avaje.ebean.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import play.db.ebean.Model;
import play.twirl.api.Html;

import javax.persistence.*;
import javax.persistence.OrderBy;
import java.lang.Override;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import models.*;
import play.data.validation.Constraints;
import java.util.Collections;

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

    private boolean active;

    private String webpage;

    @ManyToOne
    private User responsible; //defines the user responsible for contacting this company.

    @Constraints.Max(10)
    @Constraints.Min(0)
    private int priority;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    @OrderBy("Contact.getContact DESC")
    private List<Contact> contacts;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    @OrderBy("Note.getDateMade DESC")
    private List<Note> notes;


    public Bedrift(String bedriftName, String webpage, int priority, User responsible){
        this.bedriftName = bedriftName;
        this.priority = priority;
        this.responsible = responsible;
        this.active = true;
        this.webpage = webpage;
    }

    public long getBedriftId() {
        return bedriftId;
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

        List<Note> reverseNotes;

        reverseNotes = notes;
        Collections.reverse(reverseNotes);

        return reverseNotes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

	public static Finder<Long, Bedrift> find = new Finder<>(
		Long.class, Bedrift.class
	);
    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }



}
