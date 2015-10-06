package gallery.models;

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

@Entity
public class GalleryImage extends Model {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false)
    long imageId;

    @CreatedTimestamp
    private Timestamp dateUploaded;

    private String description;

    private String title;

    private User uploadedBy;

    @ManyToOne(cascade=CascadeType.ALL)
    @JsonBackReference
    private Event eventConnected;

    public GalleryImage(String title, String description, Event event){
        this.description = description;
        this.title = title;
        this.uploadedBy = LoginState.getUser();
        this.eventConnected = event;
    }
}
