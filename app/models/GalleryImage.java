package models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import play.db.ebean.Model;
import profile.models.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class GalleryImage extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    long imageId;

    @CreatedTimestamp
    private Timestamp dateUploaded;

    private String description;

    private String imageURL;

    private String title;

    @ManyToOne
    private User uploadedBy;

    public String getImageURL() {
        return imageURL;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public User getUploadedBy() {
        return uploadedBy;
    }

    public Event getEventConnected() {
        return eventConnected;
    }

    public long getImageId() {
        return imageId;
    }

    public Timestamp getDateUploaded() {
        return dateUploaded;
    }

    @ManyToOne

    private Event eventConnected;

    public GalleryImage(String title, String description, Event event, String imageURL){
        this.description = description;
        this.imageURL = imageURL;
        this.title = title;
        this.uploadedBy = LoginState.getUser();
        this.eventConnected = event;
    }

    /**
     * Finder for ebeans - requiered to search this model in the db.
     */
    public static Finder<Long, GalleryImage> find = new Finder<> (
            Long.class, GalleryImage.class
    );
}
