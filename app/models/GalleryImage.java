package models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import play.db.ebean.Model;
import profile.models.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class GalleryImage extends Model {
    private static final int CLICK_SCORE = 3;

    private static final int VIEW_SCORE = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    long imageId;

    @CreatedTimestamp
    private Timestamp dateUploaded;

    private String description;

    private String imageURL;

    private String thumbURL;

    private String title;

    private int score;

    private int thumbSize;

    private int width;

    private int height;

    @ManyToOne
    private User uploadedBy;

    public String getImageURL() {
        return imageURL;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbURL() {
        return thumbURL;
    }

    public int getScore() {
        return score;
    }

    public int getThumbSize() {
        return thumbSize;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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

    public void giveClickScore() {
        score += CLICK_SCORE;
        save();
    }

    public void giveViewScore() {
        score += VIEW_SCORE;
        save();
    }

    @ManyToOne

    private Event eventConnected;

    public GalleryImage(String title, String description, int width, int height, int thumbSize, Event event, String imageURL, String thumbURL){
        this.description = description;
        this.imageURL = imageURL;
        this.thumbSize = thumbSize;
        this.thumbURL = thumbURL;
        this.width = width;
        this.height = height;
        this.title = title;
        this.uploadedBy = LoginState.getUser();
        this.score = 0;
        this.eventConnected = event;
    }

    /**
     * Finder for ebeans - requiered to search this model in the db.
     */
    public static Finder<Long, GalleryImage> find = new Finder<> (
            Long.class, GalleryImage.class
    );
}
