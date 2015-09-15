package models;

import play.db.ebean.Model;
import play.twirl.api.Html;
import views.html.Article.articleRenderFrontPageSample;
import views.html.Event.eventRenderFrontPageSample;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by eliasbragstadhagen on 28.01.15.
 */
@Entity
public class Event extends Model implements Renderable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(nullable = false)
	private long eventId;

	@OneToOne // This is a foreign key. It points to an "Article".
	private long articleId;

	private String location;

	private int firstUpperGraduationLimit;
	private int firstLowerGraduationLimit;
	private int secondUpperGraduationLimit;
	private int secondLowerGraduationLimit;

	public boolean firstYearAllowed, secondYearAllowed, thirdYearAllowed, fourthYearAllowed, fifthYearAllowed;
	public boolean firstYearAllowedAfterSecondSignup, secondYearAllowedAfterSecondSignup, thirdYearAllowedAfterSecondSignup, fourthYearAllowedAfterSecondSignup, fifthYearAllowedAfterSecondSignup;

	private char sexAllowed;

	private int maxParticipants;
	private int maxParticipantsWaiting;

	private Calendar signUpDeadline;
	private Calendar secondSignUp;
	private Calendar eventHappens;
	private Calendar eventStops;



	public long getEventId() {
		return eventId;
	}

	public long getArticleId() {
		return articleId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}

	public Calendar getEventStops() {
		return eventStops;
	}

	public void setEventStops(Calendar eventStopsTime) {
		this.eventStops = eventStopsTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getFirstUpperGraduationLimit() {
		return firstUpperGraduationLimit;
	}

	public void setFirstUpperGraduationLimit(int firstUpperGraduationLimit) {
		this.firstUpperGraduationLimit = firstUpperGraduationLimit;
	}

	public int getFirstLowerGraduationLimit() {
		return firstLowerGraduationLimit;
	}

	public void setFirstLowerGraduationLimit(int firstLowerGraduationLimit) {
		this.firstLowerGraduationLimit = firstLowerGraduationLimit;
	}

	public int getSecondUpperGraduationLimit() {
		return secondUpperGraduationLimit;
	}

	public void setSecondUpperGraduationLimit(int secondUpperGraduationLimit) {
		this.secondUpperGraduationLimit = secondUpperGraduationLimit;
	}

	public int getSecondLowerGraduationLimit() {
		return secondLowerGraduationLimit;
	}

	public void setSecondLowerGraduationLimit(int secondLowerGraduationLimit) {
		this.secondLowerGraduationLimit = secondLowerGraduationLimit;
	}

	public char getSexAllowed() {
		return sexAllowed;
	}

	public void setSexAllowed(char sexAllowed) {
		this.sexAllowed = sexAllowed;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	public int getMaxParticipantsWaiting() {
		return maxParticipantsWaiting;
	}

	public void setMaxParticipantsWaiting(int maxParticipantsWaiting) {
		this.maxParticipantsWaiting = maxParticipantsWaiting;
	}

	public Calendar getSignUpDeadline() {
		return signUpDeadline;
	}

	public void setSignUpDeadline(Calendar signUpDeadline) {
		this.signUpDeadline = signUpDeadline;
	}

	public Calendar getEventHappens() {
		return eventHappens;
	}

	public void setEventHappens(Calendar eventHappens) {
		this.eventHappens = eventHappens;
	}

	public Calendar getSecondSignUp() {
		return secondSignUp;
	}

	public void setSecondSignUp(Calendar secondSignUp) {
		this.secondSignUp = secondSignUp;
	}

	public Html renderFrontPageSample() {
		Article article = Article.find.byId(this.articleId);
		if (article.getImagePath() == null)
			article.setImagePath("/assets/images/logo_big.png");
		return eventRenderFrontPageSample.render(article, this);
	}

	public static String changeMonthToNorwegian(int month) {
		switch (month) {
			case 0: return "Januar";
			case 1: return "Februar";
			case 2: return "Mars";
			case 3: return "April";
			case 4: return "Mai";
			case 5: return "Juni";
			case 6: return "Juli";
			case 7: return "August";
			case 8: return "September";
			case 9: return "Oktober";
			case 10: return "November";
			case 11: return "Desember";
			default: return "InvalidString";
		}
	}
	public static String changeDayToNorwegian(int day) {
		switch (day) {
			case 2: return "Mandag";
			case 3: return "Tirsdag";
			case 4: return "Onsdag";
			case 5: return "Torsdag";
			case 6: return "Fredag";
			case 7: return "Lørdag";
			case 1: return "Søndag";
			default: return "InvalidString";
		}
	}

	/**
	 * Finder for ebeans - requiered to search this model in the db.
	 */
	public static Finder<Long, models.Event> find = new Finder<Long, Event> (
		Long.class, models.Event.class
	);
}
