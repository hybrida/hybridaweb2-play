package bedkomdatabase.models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import play.db.ebean.Model;
import play.twirl.api.Html;

import javax.persistence.*;
import java.lang.Override;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import models.*;
import java.text.SimpleDateFormat;

@Entity
public class Note extends Model {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false)
    long noteId;

    @CreatedTimestamp
    private Timestamp dateMade;

    @UpdatedTimestamp
    private Timestamp whenUpdated;

    private String note;

    private User madeBy;

    @ManyToOne()
    @JsonBackReference
    private Bedrift bedrift;

    public Note(String note, Bedrift bedrift){
        this.note = note;
        this.bedrift = bedrift;
        this.madeBy = LoginState.getUser();
    }

    public long getNoteId() {
        return noteId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public static Finder<Long, Note> find = new Finder<>(
            Long.class, Note.class
    );

    public Timestamp getWhenUpdated() {
        return whenUpdated;
    }

    public User getMadeBy() {
        return madeBy;
    }

    public String getDateMade() {
        SimpleDateFormat dateMade = new SimpleDateFormat("dd/MM/YYYY HH:mm");
        String string  = dateMade.format(this.dateMade);
        return string;
    }
}