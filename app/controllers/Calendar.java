package controllers;

import views.html.*;
import play.mvc.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import java.net.URL;
import java.util.*;
import java.io.*;

public class Calendar extends Controller {
    public static Result index() {
        return ok(layoutHtmlExt.render("Kalender", views.html.Calendar.calendarHead.render(), views.html.Calendar.calendarBody.render()));
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
                        if (parser.getLocalName() == "title"){
                            inTitle = true;
                        }
                        else if (parser.getLocalName() == "summary"){
                            inSummary = true;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT://kun for sikkerhetsskyld
                        if (parser.getLocalName() == "title"){
                            inTitle = false;
                        }
                        else if (parser.getLocalName() == "summary"){
                            inSummary = false;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        if (inTitle){
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

        return ok(layoutHtml.render("KalenderTest", views.html.Calendar.calendarRender.render(titles, summaries)));
    }
}
