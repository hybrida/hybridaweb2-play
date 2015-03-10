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

    /**
     * Constructor for UserEventJoined is merely used to construct this simple object.
     * @param userId
     * @param eventId
     */
    public UserEventJoined(Long userId, Long eventId) {
        this.userId = userId;
        this.eventId = eventId;
    }

    /**
     *
     * @return the user id associated with this event.
     */
    public Long getUserId() {
        return userId;
    }

    /**
     *
     * @return the event id.
     */
    public Long getEventId() {
        return eventId;
    }

    /**
     * Adds a user to an event.
     * @param userId
     * @param eventId
     * @return whether or not the user was successfully signed up.
     * @todo Done: Ensure that the event limit is not exceeded.
     * @todo Make sure the participant is within the specified sign up year.
     */
    public static boolean insert(Long userId, Long eventId) {
        models.Event event = models.Event.find.byId(eventId);
        if (getNumberOfSignedUp(eventId) < event.getMaxParticipants()) {
            (new UserEventJoined(userId, eventId)).save();
            return true;
        }
        else
            return false;
    }

    /**
     * Remove a user from an event.
     * @param userId
     * @param eventId
     */
    public static void remove(Long userId, Long eventId) {
        (new UserEventJoined(userId, eventId)).delete();
    }

    /**
     *
     * @param eventId
     * @return the number of users signed up to this event.
     */
    public static int getNumberOfSignedUp(Long eventId) {
        return getJoinedEventList(eventId).size();
    }

    /**
     * Check to see if a user is signed up to an event.
     * @param userId
     * @param eventId
     * @return the status of the specific user (true for signed up or false for not signed up)
     */
    public static boolean isSignedUp(Long userId, Long eventId) {
        UserEventJoined joined = UserEventJoined.find.where().eq("userId", userId).eq("eventId", eventId).findUnique();
        return joined != null;
    }

    /**
     * Fetched a list of UserEventJoined containing the event id and the user ids that have joined this event.
     * @param eventId
     * @return a complete list of users that have joined the particular event.
     */
    public static java.util.List<UserEventJoined> getJoinedEventList(Long eventId) {
        return UserEventJoined.find.where().eq("eventId", eventId).findList();
    }

    public static play.db.ebean.Model.Finder<Long, UserEventJoined> find = new Finder<>(
            Long.class, UserEventJoined.class
    );
}
