package controllers;

import com.fasterxml.jackson.databind.JsonNode;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Calendar extends Controller {
    public static Result index() {
        return ok(layoutWithHead.render("Kalender", views.html.Calendar.calendarHead.render(), views.html.Calendar.calendarBody.render()));
    }

    public static Result fetch(String start, String end, String zone) {
        Date start_date;
        Date end_date;

        try {
            start_date = new SimpleDateFormat("yyyy-MM-dd").parse(start);
            end_date = new SimpleDateFormat("yyyy-MM-dd").parse(end);
        } catch (ParseException e) {
            return badRequest();
        }

        JsonNode json = Json.toJson(models.Event.find.where().between("eventHappens", new java.sql.Date(start_date.getTime()), new java.sql.Date(end_date.getTime()))); //timeFrame - duration
        return ok(json);
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
