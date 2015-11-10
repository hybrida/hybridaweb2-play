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
		String error = form.doValidation();
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
			event.secondSignUp.setTime(format.parse(form.secondSignUp));
			event.signUpDeadline.setTime(format.parse(form.signUpDeadline));
			event.eventHappens.setTime(format.parse(form.eventHappens));
			event.eventStops.setTime(format.parse(form.timeFrame));
		} catch (ParseException excObj) {
		}
		event.firstYearAllowed = form.firstYearAllowed != null;
		event.secondYearAllowed = form.secondYearAllowed != null;
		event.thirdYearAllowed = form.thirdYearAllowed != null;
		event.fourthYearAllowed = form.fourthYearAllowed != null;
		event.fifthYearAllowed = form.fifthYearAllowed != null;

		event.firstYearAllowedAfterSecondSignup = form.firstYearAllowedAfterSecondSignup != null;
		event.secondYearAllowedAfterSecondSignup = form.secondYearAllowedAfterSecondSignup != null;
		event.thirdYearAllowedAfterSecondSignup = form.thirdYearAllowedAfterSecondSignup != null;
		event.fourthYearAllowedAfterSecondSignup = form.fourthYearAllowedAfterSecondSignup != null;
		event.fifthYearAllowedAfterSecondSignup = form.fifthYearAllowedAfterSecondSignup != null;

		event.location = form.location;
		event.maxParticipants = Integer.parseInt(form.maxParticipants);
		event.maxParticipantsWaiting = Integer.parseInt(form.maxParticipantsWaiting);
		event.genderAllowed = form.genderAllowed.charAt(0);
		event.bedpres = form.bedpres != null;
		event.binding = form.binding != null;
		return event;
	}

	public static class EventForm {

		public String
			signUpStart,
			secondSignUp,
			signUpDeadline,
			eventHappens,
			timeFrame;

		public Boolean
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

			bedpres,
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
				return false;
			}
		}

		// Validate the newly generated event.
		// This is a pure function.
		public String doValidation() {
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
			isValid &= beforeOrEq(signUpStart, secondSignUp);
			if (isValid == false) return "Sign up is not before or equal to the second sign up";
			isValid &= before(secondSignUp, signUpDeadline);
			if (isValid == false) return "Second sign up is not before the deadline";
			isValid &= before(signUpDeadline, eventHappens);
			if (isValid == false) return "The deadline is not before the event's happening";
			isValid &= before(eventHappens, timeFrame);
			if (isValid == false) return "The does not start before the end";

			// Check whether at least one class is allowed
			int sum = firstYearAllowed != null ? 1 : 0;
			sum += secondYearAllowed != null ? 1 : 0;
			sum += thirdYearAllowed != null ? 1 : 0;
			sum += fourthYearAllowed != null ? 1 : 0;
			sum += fifthYearAllowed != null ? 1 : 0;
			if (sum == 0) isValid = false;

			// If the second sign up is null, we need not check if any class is allowed.
			if (secondSignUp == null)
				return "SHEIT";
			return null;
		}
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(nullable = false)
	private long eventId;

	@OneToOne // This is a foreign key. It points to an "Article".
	private Article articleRef;

	@OneToOne
	private Event previousEdit;

	@ManyToMany
	@JoinTable(name="joined_users")
	private List<User> joinedUsers;

	@Override
	public void save() {
		waitingUsers.save();
		super.save();
	}

	@OneToOne
	private EventWaitingUsers waitingUsers = new EventWaitingUsers();

	private String location;

	private int firstUpperGraduationLimit;
	private int firstLowerGraduationLimit;
	private int secondUpperGraduationLimit;
	private int secondLowerGraduationLimit;

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
		bedpres,
		binding;

	private char genderAllowed;

	private int maxParticipants;
	private int maxParticipantsWaiting;

	private Calendar signUpStart;
	private Calendar secondSignUp;
	private Calendar signUpDeadline;
	private Calendar eventHappens;
	private Calendar eventStops;

	public Event() {}
	public Event(Event copy) {
		this.articleRef = copy.articleRef;
		this.previousEdit = copy.previousEdit;
		this.joinedUsers = copy.joinedUsers;
		this.waitingUsers = copy.waitingUsers;
		this.location = copy.location;
		this.firstUpperGraduationLimit = copy.firstUpperGraduationLimit;
		this.firstLowerGraduationLimit = copy.firstLowerGraduationLimit;
		this.secondUpperGraduationLimit = copy.secondUpperGraduationLimit;
		this.secondLowerGraduationLimit = copy.secondLowerGraduationLimit;

		this.firstYearAllowed = copy.firstYearAllowed;
		this.secondYearAllowed = copy.secondYearAllowed;
		this.thirdYearAllowed = copy.thirdYearAllowed;
		this.fourthYearAllowed = copy.fourthYearAllowed;
		this.fifthYearAllowed = copy.fifthYearAllowed;

		this.firstYearAllowedAfterSecondSignup = copy.firstYearAllowedAfterSecondSignup;
		this.secondYearAllowedAfterSecondSignup = copy.secondYearAllowedAfterSecondSignup;
		this.thirdYearAllowedAfterSecondSignup = copy.thirdYearAllowedAfterSecondSignup;
		this.fourthYearAllowedAfterSecondSignup = copy.fourthYearAllowedAfterSecondSignup;
		this.fifthYearAllowedAfterSecondSignup = copy.fifthYearAllowedAfterSecondSignup;

		this.bedpres = copy.bedpres;
		this.binding = copy.binding;
		this.genderAllowed = copy.genderAllowed;
		this.maxParticipants = copy.maxParticipants;
		this.maxParticipantsWaiting = copy.maxParticipantsWaiting;
		this.signUpStart = copy.signUpStart;
		this.secondSignUp = copy.secondSignUp;
		this.signUpDeadline = copy.signUpDeadline;
		this.eventHappens = copy.eventHappens;
		this.eventStops = copy.eventStops;
	}

	public void setPrevious(Event previous) {
		this.previousEdit = previous;
	}

	public Event getPrevious() {
		return this.previousEdit;
	}

	public Boolean hasPrevious() {
		return this.previousEdit != null;
	}

	public boolean canRemove() {
		return !(binding && Calendar.getInstance().after(signUpDeadline));
	}

	/**
		\brief return the amount of following bedpresses that the user
		is blocked from.

		When the user is flagged, he will not be able to attend the following four
		bedpresses. This function finds the following four bedpresses (in start date)
		and marks checks if 'this' is that bedpres. If it is, it will count the distance
		between the mark and this bedpres. If the mark is less than zero, -1 will be
		returned. This means that the user is NOT blocked. If any value [0, 3] is returned,
		then the user is blocked. Note that this function is used internally, with
		the exception of being used on the bedpres pages where it may give the user
		information as: "You are blocked from attending the following X bedpresses".
	*/
	public int getUserBlocked(User user) {
		Event blockedFrom = user.getBlockedEvent();
		if (blockedFrom == null) return -1;
		List<Event> blockedFromThese = Event.find.setMaxRows(4).where().eq(
			"bedpres", true).where().gt("eventId", blockedFrom.getId()).orderBy(
				"eventHappens ASC").findList();
		int counter = 3;
		for (Event blocky : blockedFromThese) {
			if (blocky.getId() == this.getId())
				return counter;
			--counter;
		}
		return counter;
	}

	public String getBlockedMessageIfBedpress(User user) {
		int count = getUserBlocked(user);
		String common = " Du kan likevel melde deg på ventelisten. Dersom ikke alle plasser er fylt opp ved tidsslutt, vil du havne på oppmeldte. Du kommer bakerst i ventelisten.";
		switch (count) {
			case 3:
			case 2:
				return "Du er sperret fra denne og de " + count + " neste bedpresser fordi du ikke møtte opp." + common;
			case 1:
				return "Du er sperret fra denne og den neste bedpressen fordi du ikke møtte opp." + common;
			case 0:
				return "Du er sperret fra denne bedpressen fordi du ikke møtte opp." + common;
			default:
				return "";
		}
	}

	public boolean canJoin(User user) {
		if (user.isDefault())
			return false;
		boolean allowed = false;
		// Check if the user is within four events of his blocked event.
		if (getUserBlocked(user) != -1)
			return false;

		// Check gender requirements
		char gender = getGenderAllowed();
		if (gender == 'A')
			;
		else if (gender != user.getGender())
			return false;
		// Check if the timeframe is correct
		Calendar calendar = Calendar.getInstance();
		if (calendar.after(eventHappens))
			return false;
		Calendar opening = getSignUpStart();
		Calendar secondTime = getSecondSignUp();
		Calendar closing = getSignUpDeadline();
		if (calendar.before(opening))
			;
		else if (calendar.before(secondTime)) {
			// Check if the class matches
			switch (user.calculateClass()) {
				case 1: allowed = firstYearAllowed; break;
				case 2: allowed = secondYearAllowed; break;
				case 3: allowed = thirdYearAllowed; break;
				case 4: allowed = fourthYearAllowed; break;
				case 5: allowed = fifthYearAllowed; break;
				default: break;
			}
		} else if (calendar.before(closing)) {
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
		return allowed;
	}

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

	public boolean checkAndRemoveJoiner(User user) {
		if (canRemove()) {
			getJoinedUsers().remove(getJoinedUsers().indexOf(user));
			return true;
		}
		else
			return false;
	}

	public boolean checkAndAddJoiner(User user) {
		boolean allowed = canJoin(user);
		if (allowed)
			joinedUsers.add(user);
		return allowed;
	}

	public List<User> getJoinedUsers() {
		return joinedUsers;
	}

	public List<User> getWaitingUsers() {
		if (waitingUsers == null) {
			System.out.println("WaitingUsers is null");
		}
		return waitingUsers.getList();
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

	public void setId(long id) {
		eventId = id;
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
	public static Model.Finder<Long, models.Event> find = new Finder<Long, Event> (
		Long.class, models.Event.class
	);
}
