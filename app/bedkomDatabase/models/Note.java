package bedkomdatabase.models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.*;
import play.db.ebean.Model;
import play.twirl.api.Html;

import javax.persistence.*;
import java.lang.Override;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import models.*;

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

    @ManyToOne(cascade=CascadeType.ALL)
    private Bedrift bedrift;

    public Note(String note, Bedrift bedrift){
        this.note = note;
        this.bedrift = bedrift;
        this.madeBy = LoginState.getUser();
    }
}