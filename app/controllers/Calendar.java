package controllers;

import com.avaje.ebean.Expr;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import models.*;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;
import views.html.layoutWithHead;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Calendar extends Controller {
    private final static String ISO8601 = "yyyy-MM-dd";

    public static Result index() {
        return ok(layoutWithHead.render("Kalender", views.html.Calendar.calendarHead.render(), views.html.Calendar.calendarBody.render()));
    }

    public static Result fetch(String start, String end) {
        Date start_date; //title, start, end, url
        Date end_date;

        try {
            start_date = new SimpleDateFormat(ISO8601).parse(start);
            end_date = new SimpleDateFormat(ISO8601).parse(end);
        } catch (ParseException e) {
            return badRequest();
        }

        List<models.Event> events = models.Event.find.where().or(
                Expr.between("eventHappens", new Timestamp(start_date.getTime()), new Timestamp(end_date.getTime())),
                Expr.between("eventHappens", new Timestamp(start_date.getTime()), new Timestamp(end_date.getTime())) //TODO: Read end date
        ).findList();

        List<ObjectNode> reformatted_list_json = new ArrayList<>();

        for (models.Event event : events) {
            JsonNode json = Json.toJson(event);
            ObjectNode reformatted = Json.newObject();
            reformatted.set("title", new TextNode(json.findValue("articleId").asText())); //TODO: Find title
            reformatted.set("start", new TextNode(new SimpleDateFormat(ISO8601).format(json.findValue("eventHappens").asLong())));
            //reformatted.set("end", new TextNode(json.get("articleId").asText())); //TODO: Set end
            reformatted.set("url", new TextNode("artikkel/"+json.findValue("articleId").asText()));
            reformatted_list_json.add(reformatted);
        }

        return ok(reformatted_list_json.toString());
    }

    public static Result calendarRender() {
        ArrayList<String> titles = new ArrayList<>();
        ArrayList<String> summaries = new ArrayList<>();
        try {
            URL calendarUrl = new URL("https://www.google.com/calendar/feeds/tt7fg01e7id8t22el4sssh6qs4%40group.calendar.google.com/public/basic");
            InputStream calendarStream = calendarUrl.openStream();
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader parser = factory.createXMLStreamReader(calendarStream);

            boolean inTitle = false;
            boolean inSummary = false;

            for (int event = parser.next();
                 event != XMLStreamConstants.END_DOCUMENT;
                 event = parser.next()) {

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if (parser.getLocalName() == "title") {
                            inTitle = true;
                        }
                        else if (parser.getLocalName() == "summary") {
                            inSummary = true;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT://kun for sikkerhetsskyld
                        if (parser.getLocalName() == "title") {
                            inTitle = false;
                        }
                        else if (parser.getLocalName() == "summary") {
                            inSummary = false;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        if (inTitle) {
                            titles.add(parser.getText());
                            inTitle = false;
                        }
                        else if (inSummary) {
                            summaries.add(parser.getText());
                            inSummary = false;
                        }
                    break;
                }

            }
            parser.close();
        }
        //TODO: Lage en feilside
        catch (IOException ex) {
            //sannsynligvis noe galt med kalenderURLen
        }
        catch (XMLStreamException ex) {
            //vise ex på feilsiden?
        }

        return ok(layout.render("KalenderTest", views.html.Calendar.calendarRender.render(titles, summaries)));
    }
}
