package models;

/**
 * Created by Bourgond on 3/10/2015.
 */
@javax.persistence.Entity
public class UserEventJoined extends play.db.ebean.Model {

    @javax.persistence.Id
    private Long userId;

    @javax.persistence.Id
    private Long eventId;

    public UserEventJoined(Long userId, Long eventId) {
        this.userId = userId;
        this.eventId = eventId;
    }

    public static void insert(Long userId, Long eventId) {
        (new UserEventJoined(userId, eventId)).save();
    }

    public static void remove(Long userId, Long eventId) {
        (new UserEventJoined(userId, eventId)).delete();
    }
}
