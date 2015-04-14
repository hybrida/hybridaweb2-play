package controllers;

import com.avaje.ebean.Expr;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import models.*;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layoutWithHead;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

//TODO: Remove unnessesary files from fullcalendar and relocate the rest, Test birthday functionality, Make dragging a event around actually change something if admin

public class Calendar extends Controller {
    private final static String ISO8601 = "yyyy-MM-dd";
    private final static String ISO8601_TIME = "yyyy-MM-dd'T'HH:mm:ssXXX";
    private final static String EVENT_COLOR = "#236293";
    private final static String BIRTHDAY_COLOR = "#25626C";
    private final static String EVENT_DEFAULT_TITLE = "Ingen tittel";
    private final static String BIRTHDAY_DEFAULT_TITLE = "Bursdag til [NAME]";

    public static Result index() {
        return ok(layoutWithHead.render("Kalender", views.html.Calendar.calendarHead.render(), views.html.Calendar.calendarBody.render()));
    }

    public static Result change(String id, String start, String end) {
        return ok("false"); //TODO: Change entry with given id
    }

    public static Result fetch(String start, String end) { // Also passing a timezone, but I can't read it since the variable name is a _, which play doesn't like to have in the routes
        long start_time = 0;
        long end_time = 0;

        try {
            Date start_date = new SimpleDateFormat(ISO8601).parse(start);
            if (start_date != null) start_time = start_date.getTime();

            Date end_date = new SimpleDateFormat(ISO8601).parse(end);
            if (end_date != null) end_time = end_date.getTime();

        } catch (ParseException e) {
            return badRequest();
        }

        if (start_time == 0 || end_time == 0 || start_time > end_time) return badRequest();

        // Get events
        List<models.Event> events =
                models.Event.find.where().and(
                        Expr.not(Expr.and(
                                Expr.lt("eventHappens", new Timestamp(start_time)),
                                Expr.lt("eventStops", new Timestamp(start_time))
                        )),
                        Expr.not(Expr.and(
                                Expr.gt("eventHappens", new Timestamp(end_time)),
                                Expr.gt("eventStops", new Timestamp(end_time))
                        ))
                ).findList();

        // Create new json compatible with FullCalendar for every event
        List<ObjectNode> reformatted_list_json = new ArrayList<>();
        if (events != null) {
            for (models.Event event : events) {
                if (event == null) break;
                ObjectNode reformatted = Json.newObject();

                // Set start time
                if (event.getEventHappens() != null && event.getEventHappens().getTimeInMillis() != 0) {
                    String eventStartTime = new SimpleDateFormat(ISO8601_TIME).format(event.getEventHappens().getTimeInMillis());
                    reformatted.set("start", new TextNode(eventStartTime));
                } else break; // We can't do anything if this is not set

                // Set id
                if (event.getEventId() != 0) {
                    reformatted.set("id", new TextNode(""+event.getEventId()));
                } else break; // We can't do anything if this is not set

                // Set end time
                if (event.getEventStops() != null && event.getEventStops().getTimeInMillis() != 0) {
                    String eventEndTime = new SimpleDateFormat(ISO8601_TIME).format(event.getEventStops().getTimeInMillis());
                    reformatted.set("end", new TextNode(eventEndTime));
                }

                // Set title
                Article article = Article.find.byId(event.getArticleId());
                String title;
                if (article == null || article.getTitle() == null || article.getTitle().isEmpty()) {
                    title = EVENT_DEFAULT_TITLE;
                } else {
                    title = article.getTitle();
                }
                reformatted.set("title", new TextNode(title));

                // Set url
                reformatted.set("url", new TextNode("event/ut/" + event.getEventId())); //TODO: forandre event til arrangement?

                // Set color
                reformatted.set("color", new TextNode(EVENT_COLOR));

                reformatted_list_json.add(reformatted);
            }
        }

        // If logged in, get birthdays for all users
        if (LoginState.isValidlyLoggedIn()) {
            List<User> users = User.find.all();
            if (users != null) {
                for (User user : users) {
                    if (user == null || user.dateOfBirth == null || user.dateOfBirth.getTime() == 0 || user.getName() == null || user.getName().isEmpty()) continue;
                    java.util.Calendar tempCalendar = new GregorianCalendar();

                    // Get requested start year
                    tempCalendar.setTimeInMillis(start_time);
                    int startYear = tempCalendar.get(java.util.Calendar.YEAR);

                    // Get requested start year
                    tempCalendar.setTimeInMillis(end_time);
                    int endYear = tempCalendar.get(java.util.Calendar.YEAR);

                    // Get user's birthday day and month
                    tempCalendar.setTimeInMillis(user.dateOfBirth.getTime());
                    int birthdayDay = tempCalendar.get(java.util.Calendar.DAY_OF_MONTH);
                    int birthdayMonth = tempCalendar.get(java.util.Calendar.MONTH);

                    // Add a event each year for the requested interval
                    for (int year = startYear; year <= endYear; ++year) {
                        ObjectNode reformatted = Json.newObject();
                        tempCalendar.set(java.util.Calendar.YEAR, year);
                        tempCalendar.set(java.util.Calendar.DAY_OF_MONTH, birthdayDay);
                        tempCalendar.set(java.util.Calendar.MONTH, birthdayMonth);

                        // Set start time
                        String birthdayTime = new SimpleDateFormat(ISO8601_TIME).format(tempCalendar.getTimeInMillis());
                        reformatted.set("start", new TextNode(birthdayTime));

                        // Set title
                        reformatted.set("title", new TextNode(BIRTHDAY_DEFAULT_TITLE.replaceAll("\\[NAME\\]", user.getName())));

                        // Set url
                        if (user.getUsername() != null && !user.getUsername().isEmpty()) {
                            reformatted.set("url", new TextNode("profil/" + user.getUsername()));
                        }

                        // Set color
                        reformatted.set("color", new TextNode(BIRTHDAY_COLOR));

                        reformatted_list_json.add(reformatted);
                    }
                }
            }
        }

        return ok(Json.toJson(reformatted_list_json));
    }
}
