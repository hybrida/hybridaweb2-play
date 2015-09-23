package article;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import static play.data.Form.form;

import java.text.ParseException;

import article.views.html.*;
import views.html.layout;
import views.html.utils.centerBlock;
import models.*;


public class ArticleIn extends Controller {

	final static Form<models.Event> eventForm = form(models.Event.class);
	final static Form<models.Article> articleForm = form(models.Article.class);

	public static Result index() {
		return ok(layout.render("Hybrida: Opprett Artikkel", index.render()));
	}

	public static Result save() {
		try {
			User user = LoginState.getUser();
			if (user == null || !user.canCreateNewArticle())
				return application.Application.showUnauthorizedAccess();
			models.Article art = saveArticle();
			if (!(new HttpRequestData().get("event") == null)) {
				ResultAndEId res = saveEvent(art, null);
				if (res.result != null)
					return res.result;
				Renders.addEvent(res.event);
			}
			else {
				// Husk å legge til artikkelen i renders! Da vises den nemlig på fremsiden ^_^
				Renders.addArticle(art);
			}
			return redirect(article.routes.Article.viewArticle("" + art.getId()));
		}
		catch (IllegalStateException e) {
			return application.Application.show400("ugyldig data oppgitt: " + e);
		}
		catch (Exception e) {
			e.printStackTrace();
			return ok(e.toString());
		}
	}

	public static models.Article saveArticle() throws IllegalStateException {
		User user = LoginState.getUser();
		Form<models.Article> articleInput = articleForm.bindFromRequest();
		System.out.println(new HttpRequestData());
		String image_link = user.uploadPicture();
		if (!articleInput.hasErrors()) {
			models.Article articleModel = articleInput.get();
			if (image_link != null)
				articleModel.setImagePath(image_link);
			else
				articleModel.setDefaultImage();
			articleModel.setAuthor(user);
			articleModel.save();

			return articleModel;
		}
		throw new IllegalStateException();
	}

	public static long saveSpecificArticle(String id) throws IllegalStateException {
		User user = LoginState.getUser();

		Form<models.Article> articleInput = articleForm.bindFromRequest();
		String image_link = user.uploadPicture();
		if (!articleInput.hasErrors()) {
			models.Article articleModel = articleInput.get();
			if (image_link != null)
				articleModel.setImagePath(image_link);
			else
				articleModel.setDefaultImage();
			articleModel.setAuthor(user);
			articleModel.setId(Long.valueOf(id));
			articleModel.update();

			return articleModel.getId();
		}
		throw new IllegalStateException();
	}

	public static long saveSpecificEvent(String id) throws IllegalStateException {
		User user = LoginState.getUser();

		models.Event event = models.Event.find.byId(Long.valueOf(id));
		saveSpecificArticle("" + event.getArticle().getId());
		saveEvent(event.getArticle(), Long.valueOf(id));
		throw new IllegalStateException();
	}

	public static class ResultAndEId {
		ResultAndEId() {}
		ResultAndEId(Result res) {
			result = res;
		}
		Result result = null;
		models.Event event = null;
	}

	public static ResultAndEId saveEvent(models.Article articleRef, Long eventId /* Can be null: new id is generated.*/) {
		ResultAndEId reid = new ResultAndEId();
		HttpRequestData httpData = new HttpRequestData();
		System.out.println(httpData);
		models.Event eventModel = new models.Event();
		java.text.SimpleDateFormat dateFormat;
		java.util.Calendar cal = java.util.Calendar.getInstance();
		dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

		java.util.Calendar current_calendar = java.util.Calendar.getInstance();
		current_calendar.setTimeInMillis(System.currentTimeMillis());

		try {
			cal.setTime(dateFormat.parse(httpData.get("secondSignUp")));
			if (cal.before(current_calendar)) {
				reid.result = application.Application.show400("Andre oppmeldingsfristen er før nå. Dette er ikke gyldig.");
				return reid;
			}
			eventModel.setSecondSignUp(cal);
		} catch (ParseException parseExc) {
			System.out.println(cal);
			return new ResultAndEId(application.Application.show400("Feil dato format i den andre oppmeldingsfristen."));
		}

		cal = java.util.Calendar.getInstance();
		try {
			cal.setTime(dateFormat.parse(httpData.get("eventHappens")));
			if (cal.before(current_calendar)) {
				reid.result = application.Application.show400("Arrangementet skjer før nå. Dette er ikke gyldig.");
				return reid;
			}
			eventModel.setEventHappens(cal);
		} catch (ParseException parseExc) {
			return new ResultAndEId(application.Application.show400("Feil dato format når arrangementet faktisk skjer oppmeldingsfristen."));
		}

		cal = java.util.Calendar.getInstance();
		try {
			cal.setTime(dateFormat.parse(httpData.get("timeFrame"))); // eventStops
			if (cal.before(eventModel.getEventHappens())) {
				reid.result = application.Application.show400("Arrangementet slutter før det skjer. Dette er ikke gyldig.");
				return reid;
			}
			eventModel.setEventStops(cal);
		} catch (ParseException parseExc) {
			return new ResultAndEId(application.Application.show400("Feil dato format når arrangementet faktisk skjer oppmeldingsfristen."));
		}

		cal = java.util.Calendar.getInstance();
		try {
			cal.setTime(dateFormat.parse(httpData.get("signUpDeadline")));
			if (cal.before(current_calendar)) {
				reid.result = application.Application.show400("Oppmeldingsfristen er før nå. Dette er ikke gyldig.");
				return reid;
			}
			eventModel.setSignUpDeadline(cal);
		} catch (ParseException parseExc) {
			return new ResultAndEId(application.Application.show400("Feil dato format i oppmeldingsfristen."));
		}

		if (httpData.getInt("maxParticipantsWaiting") < 0) {
			reid.result = application.Application.show400("Antall mulige på ventelisten er ugyldig: '" + httpData.getInt("maxParticipants") + "'. Det skal være flere enn 0.");
			return reid;
		}
		eventModel.setMaxParticipantsWaiting(httpData.getInt("maxParticipantsWaiting"));

		if (httpData.getInt("maxParticipants") <= 0) {
			reid.result = application.Application.show400("Antall mulig påmeldte er ugyldig: '" + httpData.getInt("maxParticipants") + "'. Det skal være flere enn 0.");
			return reid;
		}
		eventModel.setMaxParticipants(httpData.getInt("maxParticipants"));

		char sex = httpData.get("sexAllowed").charAt(0);
		if (sex != 'M' && sex != 'F' && sex != 'A') {
			reid.result = application.Application.show400("Kjønnet er feil: '" + sex + "'. Dette er ikke gyldig.");
			return reid;
		}
		eventModel.setSexAllowed(httpData.get("sexAllowed").charAt(0));

		/*
		if (httpData.getInt("secondLowerGraduationLimit") < 1 || httpData.getInt("secondLowerGraduationLimit") > 5) {
				reid.result = controllers.Application.show400("Andre nedre klasse grense ugyldig '" + httpData.getInt("secondLowerGraduationLimit") + "' må være mellom 1 og 5 inkludert.");
				return reid;
		}
		eventModel.setSecondLowerGraduationLimit(httpData.getInt("secondLowerGraduationLimit"));

		if (httpData.getInt("secondUpperGraduationLimit") < 1 || httpData.getInt("secondUpperGraduationLimit") > 5) {
				reid.result = controllers.Application.show400("Andre øvre klasse grense ugyldig '" + httpData.getInt("secondUpperGraduationLimit") + "' må være mellom 1 og 5 inkludert.");
				return reid;
		}
		eventModel.setSecondUpperGraduationLimit(httpData.getInt("secondUpperGraduationLimit"));
		*/

		eventModel.firstYearAllowed = httpData.get("firstYearAllowed") != null;
		eventModel.secondYearAllowed = httpData.get("secondYearAllowed") != null;
		eventModel.thirdYearAllowed = httpData.get("thirdYearAllowed") != null;
		eventModel.fourthYearAllowed = httpData.get("fourthYearAllowed") != null;
		eventModel.fifthYearAllowed = httpData.get("fifthYearAllowed") != null;

		eventModel.firstYearAllowedAfterSecondSignup = httpData.get("firstYearAllowedAfterSecondSignup") != null;
		eventModel.secondYearAllowedAfterSecondSignup = httpData.get("secondYearAllowedAfterSecondSignup") != null;
		eventModel.thirdYearAllowedAfterSecondSignup = httpData.get("thirdYearAllowedAfterSecondSignup") != null;
		eventModel.fourthYearAllowedAfterSecondSignup = httpData.get("fourthYearAllowedAfterSecondSignup") != null;
		eventModel.fifthYearAllowedAfterSecondSignup = httpData.get("fifthYearAllowedAfterSecondSignup") != null;

		/* DEPRECATED
		if (httpData.getInt("firstLowerGraduationLimit") < 1 || httpData.getInt("firstLowerGraduationLimit") > 5) {
				reid.result = controllers.Application.show400("Første nedre klasse grense ugyldig '" + httpData.getInt("firstLowerGraduationLimit") + "' må være mellom 1 og 5 inkludert.");
				return reid;
		}
		eventModel.setFirstLowerGraduationLimit(httpData.getInt("firstLowerGraduationLimit"));

		if (httpData.getInt("firstUpperGraduationLimit") < 1 || httpData.getInt("firstUpperGraduationLimit") > 5) {
				reid.result = controllers.Application.show400("Første øvre klasse grense ugyldig '" + httpData.getInt("firstUpperGraduationLimit") + "' må være mellom 1 og 5 inkludert.");
				return reid;
		}
		eventModel.setFirstUpperGraduationLimit(httpData.getInt("firstUpperGraduationLimit"));
		*/

		eventModel.setLocation(httpData.get("location"));
		eventModel.setArticle(articleRef);

		if (eventId == null)
			eventModel.save();
		else {
			eventModel.setEventId(eventId);
			eventModel.update();
		}
		reid.event = eventModel;
		return reid;
}

public static Result saveEdit(String id) {
		Result error = application.Application.checkEditPrivilege(LoginState.getUser());
		if (error != null)
			return error;

		models.Article article = models.Article.find.byId(Long.valueOf(id));
		HttpRequestData httpdata = new HttpRequestData();
		article.setTitle(httpdata.get("title"));
		article.setIngress(httpdata.get("ingress"));
		article.setText(httpdata.get("text"));
		article.save();
		return application.Application.index();
	}

}
