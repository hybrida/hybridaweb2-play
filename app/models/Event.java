package models;

import play.db.ebean.Model;
import play.data.format.Formats;
import play.twirl.api.Html;
import play.data.Form;
import static play.data.Form.form;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import javax.persistence.*;

/**
 * Created by eliasbragstadhagen on 28.01.15.
 */
@Entity
public class Event extends Model {

	public static Event getFromRequest() {
		Form<EventForm> eventForm = form(EventForm.class);
		EventForm form = eventForm.bindFromRequest().get();
		String error = form.validate();
		if (error != null) throw new Error(error);
		Event event = new Event();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		try {
			event.signUpStart = Calendar.getInstance();
			event.secondSignUp = Calendar.getInstance();
			event.signUpDeadline = Calendar.getInstance();
			event.eventHappens = Calendar.getInstance();
			event.eventStops = Calendar.getInstance();

			event.signUpStart.setTime(format.parse(form.signUpStart));
			System.out.println(format.parse(form.signUpStart));
			event.secondSignUp.setTime(format.parse(form.secondSignUp));
			event.signUpDeadline.setTime(format.parse(form.signUpDeadline));
			event.eventHappens.setTime(format.parse(form.eventHappens));
			event.eventStops.setTime(format.parse(form.timeFrame));
		} catch (ParseException excObj) {
			System.out.println("HEEEEEEEEEEEE" + excObj);
		}
		event.firstYearAllowed = form.firstYearAllowed;
		event.secondYearAllowed = form.secondYearAllowed;
		event.thirdYearAllowed = form.thirdYearAllowed;
		event.fourthYearAllowed = form.fourthYearAllowed;
		event.fifthYearAllowed = form.fifthYearAllowed;

		event.firstYearAllowedAfterSecondSignup = form.firstYearAllowedAfterSecondSignup;
		event.secondYearAllowedAfterSecondSignup = form.secondYearAllowedAfterSecondSignup;
		event.thirdYearAllowedAfterSecondSignup = form.thirdYearAllowedAfterSecondSignup;
		event.fourthYearAllowedAfterSecondSignup = form.fourthYearAllowedAfterSecondSignup;
		event.fifthYearAllowedAfterSecondSignup = form.fifthYearAllowedAfterSecondSignup;

		event.location = form.location;
		event.maxParticipants = Integer.parseInt(form.maxParticipants);
		event.maxParticipantsWaiting = Integer.parseInt(form.maxParticipantsWaiting);
		event.genderAllowed = form.genderAllowed.charAt(0);
		event.binding = form.binding;
		return event;
	}

	public static class EventForm {

		public String
			signUpStart,
			secondSignUp,
			signUpDeadline,
			eventHappens,
			timeFrame;

		public boolean
			firstYearAllowed,
			secondYearAllowed,
			thirdYearAllowed,
			fourthYearAllowed,
			fifthYearAllowed,

			firstYearAllowedAfterSecondSignup,
			secondYearAllowedAfterSecondSignup,
			thirdYearAllowedAfterSecondSignup,
			fourthYearAllowedAfterSecondSignup,
			fifthYearAllowedAfterSecondSignup,

			binding;

		public String
			location,
			maxParticipants,
			maxParticipantsWaiting,
			genderAllowed;

		private boolean before(String bc, String ad) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			try {
				cal1.setTime(dateFormat.parse(bc));
				cal2.setTime(dateFormat.parse(ad));
				return cal1.before(cal2);
			} catch (ParseException parseExc) {
				return false;
			}
		}

		private boolean beforeOrEq(String bc, String ad) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			try {
				cal1.setTime(dateFormat.parse(bc));
				cal2.setTime(dateFormat.parse(ad));
				return cal1.before(cal2) || cal1.equals(cal2);
			} catch (ParseException parseExc) {
				System.out.println(parseExc);
				return false;
			}
		}

		private boolean before(Calendar bc, String ad) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
			Calendar cal2 = Calendar.getInstance();
			try {
				cal2.setTime(dateFormat.parse(ad));
				return bc.before(cal2);
			} catch (ParseException parseExc) {
				System.out.println(parseExc);
				return false;
			}
		}

		// Validate the newly generated event.
		// This is a pure function.
		public String validate() {
			Calendar now = Calendar.getInstance();
			// Check whether the input is a valid event.
			boolean isValid = true;
			isValid &= !signUpStart.equals("");
			isValid &= !signUpDeadline.equals("");
			isValid &= !eventHappens.equals("");
			if (isValid == false) return "nodates";

			// Put second sign up = sign up start if it is empty
			if (secondSignUp.equals("")) secondSignUp = signUpStart;

			// Check whether the times are valid.
			isValid &= before(now, signUpStart);
			isValid &= beforeOrEq(signUpStart, secondSignUp);
			isValid &= before(secondSignUp, signUpDeadline);
			isValid &= before(signUpDeadline, eventHappens);
			isValid &= before(eventHappens, timeFrame);
			if (isValid == false) return "wrongdates";

			// Check whether at least one class is allowed
			int sum = firstYearAllowed ? 1 : 0;
			sum += secondYearAllowed ? 1 : 0;
			sum += thirdYearAllowed ? 1 : 0;
			sum += fourthYearAllowed ? 1 : 0;
			sum += fifthYearAllowed ? 1 : 0;
			if (sum == 0) isValid = false;

			// If the second sign up is null, we need not check if any class is allowed.
			if (secondSignUp == null)
			{
				return "SHEIT";
			}
			return null;
		}
	}

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

	public String bool2checked(boolean bool) {
		return bool ? "checked" : "";
	}

	public boolean
		firstYearAllowed,
		secondYearAllowed,
		thirdYearAllowed,
		fourthYearAllowed,
		fifthYearAllowed;
	public boolean
		firstYearAllowedAfterSecondSignup,
		secondYearAllowedAfterSecondSignup,
		thirdYearAllowedAfterSecondSignup,
		fourthYearAllowedAfterSecondSignup,
		fifthYearAllowedAfterSecondSignup;

	public boolean
		binding;

	private char genderAllowed;

	private int maxParticipants;
	private int maxParticipantsWaiting;

	private Calendar signUpStart;
	private Calendar secondSignUp;
	private Calendar signUpDeadline;
	private Calendar eventHappens;
	private Calendar eventStops;

	public Calendar getSignUpStart() {
		return signUpStart;
	}

	public String areAllGendersAllowed() {
		return getGenderAllowed() == 'A' ? "checked" : "";
	}

	public String areOnlyMalesAllowed() {
		return getGenderAllowed() == 'M' ? "checked" : "";
	}

	public String areOnlyFemalesAllowed() {
		return getGenderAllowed() == 'F' ? "checked" : "";
	}

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

	public char getGenderAllowed() {
		return genderAllowed;
	}

	public void setGenderAllowed(char genderAllowed) {
		this.genderAllowed = genderAllowed;
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
