package models;

import play.db.ebean.Model;
import play.twirl.api.Html;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

/**
 * Created by eliasbragstadhagen on 28.01.15.
 */
@Entity
public class Event extends Model {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(nullable = false)
	private long eventId;

	@OneToOne // This is a foreign key. It points to an "Article".
	private Article articleRef;

	@ManyToMany
	private List<User> joinedUsers;

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

	public boolean checkAndAddJoiner(User user) {
		boolean allowed = false;
		// Check if the timeframe is correct
		Calendar calendar = Calendar.getInstance();
		if (calendar.after(eventHappens))
			return false;
		Calendar firstTime = getSignUpDeadline();
		Calendar secondTime = getSecondSignUp();
		if (calendar.before(firstTime)) {
			// Check if the class matches
			switch (user.calculateClass()) {
				case 1: allowed = firstYearAllowed; break;
				case 2: allowed = secondYearAllowed; break;
				case 3: allowed = thirdYearAllowed; break;
				case 4: allowed = fourthYearAllowed; break;
				case 5: allowed = fifthYearAllowed; break;
				default: break;
			}
		} else if (calendar.after(secondTime)) {
				// Check if the class matches
			switch (user.calculateClass()) {
				case 1: allowed = firstYearAllowedAfterSecondSignup; break;
				case 2: allowed = secondYearAllowedAfterSecondSignup; break;
				case 3: allowed = thirdYearAllowedAfterSecondSignup; break;
				case 4: allowed = fourthYearAllowedAfterSecondSignup; break;
				case 5: allowed = fifthYearAllowedAfterSecondSignup; break;
				default: break;
			}
		} else
			allowed = false;
		if (allowed)
			joinedUsers.add(user);
		return allowed;
	}

	public List<User> getJoinedUsers() {
		return joinedUsers;
	}

	public List<User> getJoinedSpecificClass(int classnum) {
		List<User> joined = joinedUsers;
		List<User> joinedClassNum = new ArrayList<>();
		for (User user : joined)
			if (user.calculateClass() == classnum)
				joinedClassNum.add(user);
		return joinedClassNum;
	}

	public long getId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public void setArticle(Article articleRef) {
		this.articleRef = articleRef;
	}

	public Article getArticle() {
		return this.articleRef;
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
