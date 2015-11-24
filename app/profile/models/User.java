package profile.models;

import static play.data.Form.form;
import controllers.Upload;
import controllers.routes;
import exceptions.NoFileInRequest;
import exceptions.ServerError;
import exceptions.Unauthorized;
import models.Event;
import models.LoginState;
import play.data.Form;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.mvc.Call;
import play.twirl.api.Html;
import util.Validator;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(
		name="user",
		uniqueConstraints=
		@UniqueConstraint(columnNames= {"username"})
)
public class User extends Model implements ImmutableUser {

	public static class UserForm {
		public Long uid;
		public String username;
		public Boolean
				arrkom, bedkom, root, vevkom, admin, jentekom, redaksjonen;
		public Integer graduationYear;
		public Character gender;

		public String doValidation() {
			User found = User.findByUsername(username);
			if (found != null && found.getId() != uid)
				return "User already exists with that name";
			return null;
		}
	}


	//FIXME: Really? A Form object named userForm and a UserForm object named form... get yo shit together, man
	public static User getUserFromForm() {
		Form<UserForm> userForm = form(UserForm.class);
		UserForm form = userForm.bindFromRequest().get();
		String error = form.doValidation();
		if (error != null) throw new Error(error);
		User user = new User();
		user.username = form.username;
		user.graduationYear = form.graduationYear;
		user.bedkom = form.bedkom != null;
		user.arrkom = form.arrkom != null;
		user.vevkom = form.vevkom != null;
		user.jentekom = form.jentekom != null;
		user.redaksjonen = form.redaksjonen != null;
		user.admin = form.admin != null;
		user.root = form.root != null;
		user.gender = form.gender == null ? 'U' : form.gender;
		return user;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public Long        id;

	// Name, identification, contact
	public String      username;  // Assigned by NTNU
	@Required
	@Column(name = "first_name", columnDefinition = "varchar(256) default 'Fornavn'", nullable = false)
	public String      firstName;
	@Required
	@Column(name = "last_name", columnDefinition = "varchar(256) default 'Etternavn'", nullable = false)
	public String      lastName;
	@Column(name = "middle_name")
	public String      middleName;
	@Column(name = "email")
	public String      email;
	@Column(name = "website_url")
	public String      websiteUrl;
	@Column(name = "phone")
	public String      phone;
	@Column(name = "title")
	public String      title; // Ph.D., Civ.Eng., Stud., Chief, Commander, General, Lord, Admiral, Vevsjef,...
	@Column(name = "graduation_year")
	public Integer     graduationYear = 0;
	@Enumerated(EnumType.STRING)
	@Column(name = "specialization")
	public Specialization specialization = Specialization.NONE;
	@Column(name = "profile_image_file_name")
	public String      profileImageFileName;

	// Privilege status
	@Column(name = "student", columnDefinition = "boolean default false") //TODO: Seems unnecessary, maybe change to member? As in having paid membership fee
	public Boolean             student = false;    // No special privileges except for file ajaxUpload.
	@Column(name = "styret", columnDefinition = "boolean default false")
	public Boolean             styret = false;     // Access to styret functionality.
	@Column(name = "bedkom", columnDefinition = "boolean default false")
	public Boolean             bedkom = false;     // Access to bedkom functionality.
	@Column(name = "arrkom", columnDefinition = "boolean default false")
	public Boolean             arrkom = false;     // Access to arrkom functionality.
	@Column(name = "vevkom", columnDefinition = "boolean default false")
	public Boolean             vevkom = false;     // Access to vevkom functionality.
	@Column(name = "jentekom", columnDefinition = "boolean default false")
	public Boolean             jentekom = false;   // Access to jentekom functionality.
	@Column(name = "redaksjonen", columnDefinition = "boolean default false")
	public Boolean             redaksjonen = false;// Access to redkasjonen functionality.
	@Column(name = "admin", columnDefinition = "boolean default false")
	public Boolean             admin = false;      // For control over the entire page. Check your privilege
	@Column(name = "root", columnDefinition = "boolean default false")
	public Boolean             root = false;       // Powers too great for mere mortals.
	@Column(name = "gender", columnDefinition = "char(1) default 'U'")
	public Character           gender = 'U';     // For specific events.
	@Column(name = "enrolled")
	public Timestamp           enrolled;   // For specific bedpreses requiring a year number.
	@Column(name = "date_of_birth")
	public Timestamp           dateOfBirth;

	@ManyToOne
	@Column(columnDefinition = "default null")
	public models.Event block4FromThisEvent;

	// Misc. account info
	@Column(name = "last_login")
	private Timestamp          lastLogin; // Used to avoid cookie-stealing schemes and MITM attacks. Combined with AES with time and RNG padded encryption.

	public User() {}

	public User(String username, String firstName, String lastName) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public boolean isMale() {
		return gender == 'M';
	}

	public boolean isFemale() {
		return gender == 'F';
	}

	public boolean isUnknownGender() {
		return gender == 'U';
	}

	public boolean isDefault() {
		return id == null;
	}

	public void setLastLoginTimeNow() {
		lastLogin = new Timestamp(new java.util.Date(System.currentTimeMillis()).getTime());
	}

	private boolean thisOrFalse(Boolean object) {
		return (object != null ? object : false);
	}

	public boolean canCreateNewArticle() {
		return thisOrFalse(bedkom) || thisOrFalse(admin) || thisOrFalse(root);
	}

	// Getters and Setter (and some hassers)

	public Long getId() {
		return id;
	}

	// Used only during updating specific ids.
	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean hasMiddleName() {
		return middleName != null && !middleName.equals("");
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getName() {
		return firstName + " " + lastName;
	}

	public String getFullName() {
		return firstName + " " + (hasMiddleName() ? middleName + " " : "") + lastName;
	}

	public Html getNameLink() {
		return profile.views.html.nameLink.render(this);
	}

	public boolean hasEmail() {
		return email != null && !email.equals("");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email.isEmpty()) this.email = "";
		else {
			int i = email.indexOf('@');
			this.email = email.substring(0, i) + email.substring(i).toLowerCase();
		}
	}

	public boolean hasWebsiteUrl() {
		return websiteUrl != null && !websiteUrl.equals("");
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		if (websiteUrl.isEmpty()) this.websiteUrl = "";
		else {
			if (!websiteUrl.substring(0, 4).equalsIgnoreCase("http")) {
				websiteUrl = "http://" + websiteUrl + (websiteUrl.indexOf('/') == -1 ? "/" : "");
			}
			if (websiteUrl.indexOf('?') != -1) {
				int i = websiteUrl.indexOf('?');
				websiteUrl = websiteUrl.substring(0, i).toLowerCase() + websiteUrl.substring(i);
			}
			this.websiteUrl = websiteUrl;
		}
	}

	public boolean hasPhone() {
		return phone != null && !phone.equals("");
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (phone.isEmpty()) this.phone = "";
		else {
			phone = phone.replaceAll(" ", "");
			phone = phone.substring(phone.length() - 8);
			this.phone = "+47 " + phone.substring(0, 3) + " " + phone.substring(3, 5) + " " + phone.substring(5);
		}
	}

	public boolean hasTitle() {
		return title != null && title.length() > 0;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean hasGraduationYear() {
		return graduationYear != null;
	}

	public Integer getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(Integer graduationYear) {
		this.graduationYear = graduationYear;
	}

	public boolean hasSpecialization() {
		return specialization != null && specialization != Specialization.NONE;
	}

	public Specialization getSpecialization() {
		if (specialization == null) specialization = Specialization.NONE;
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public void setSpecialization(String displayName) {
		this.specialization = Specialization.fromDisplayName(displayName);
	}

	public boolean hasProfileImage() {
		return profileImageFileName != null && !profileImageFileName.equals("");
	}

	public String getProfileImageFileName() {
		return profileImageFileName;
	}

	public void setProfileImageFileName(String profileImageFileName) {
		this.profileImageFileName = profileImageFileName;
	}

	public Call getProfileImageCall() {
		if(hasProfileImage()) return controllers.routes.Assets.at("uploads/" + getUsername() + "/" + getProfileImageFileName());
		return controllers.routes.Assets.at("images/placeholder-profile.jpg");
	}

	public Html getThumbnail() {
		return profile.views.html.thumbnail.render(this);
	}

	public Timestamp getLastLoginTime() {
		return lastLogin;
	}

	public char getGender() {
		return gender;
	}

	public boolean isInStyret() {
		return styret;
	}

	public boolean isInArrkom() {
		return arrkom;
	}

	public boolean isInBedkom() {
		return bedkom;
	}

	public boolean isInVevkom() {
		return vevkom;
	}

	public boolean isInJentekom() {
		return jentekom;
	}

	public boolean isInRedaksjonen() {
		return redaksjonen;
	}

	@Override
	public Access[] getMemberships() {
		List<Access> committees = new ArrayList<>();
		for(Access committee : Access.COMMITTEES) if(committee.userHasAccess(this)) committees.add(committee);
		return committees.toArray(new Access[committees.size()]);
	}

	public boolean isAdmin() {
		return admin;
	}

	public boolean isRoot() {
		return thisOrFalse(root);
	}

	public boolean isFirstUser() {
		return getId() == 1;
	} //FIXME: Why?

	public int calculateClass() {
		if (!hasGraduationYear()) return 0;
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
		int classYear = 5 - (graduationYear - currentYear);
		if (currentMonth >= 8) // July, MONTH is [0, 11]
			classYear += 1;
		return classYear;
	}

	public void saveToSession() {
		play.mvc.Controller.session("user", play.api.libs.Crypto.encryptAES(username + "," + String.valueOf(System.currentTimeMillis())));
	}

	public static Map<String, String> validateForm(Form<User> form) throws IOException {
		Validator validator = Validator.fromJSON(new File("public/json/userValidation.json"));
		return validator.validate(form);
	}

	public void updateFromForm(Form<User> form) {
		setFirstName(form.apply("firstName").valueOr(getFirstName()));
		setLastName(form.apply("lastName").valueOr(getLastName()));
		setMiddleName(form.apply("middleName").valueOr(getMiddleName()));
		setEmail(form.apply("email").valueOr(getEmail()));
		setWebsiteUrl(form.apply("websiteUrl").valueOr(getWebsiteUrl()));
		setPhone(form.apply("phone").valueOr(getPhone()));
		setProfileImageFileName(form.apply("profileImageFileName").valueOr(getProfileImageFileName()));
		setTitle(form.apply("title").valueOr(getTitle()));
		setGraduationYear(Integer.parseInt(form.apply("graduationYear").valueOr(getGraduationYear().toString())));
		setSpecialization(form.apply("specialization").valueOr(getSpecialization().toString()));
		update();
	}

	public String getProfilePictureWithFallBackOnDefault() {
		return getProfileImageCall().url();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("USER[\n");
		if (id != null) sb.append("\tid: " + id.toString() + ", \n");
		if (email != null) sb.append("\temail: " + email.toString() + ", \n");
		if (phone != null) sb.append("\tphone: " + phone.toString() + ", \n");
		if (title != null) sb.append("\ttitle: " + title.toString() + ", \n");
		if (username != null) sb.append("\tusername: " + username.toString() + ", \n");
		if (lastName != null)  sb.append("\tlastName: " + lastName.toString() + ", \n");
		if (firstName != null) sb.append("\tfirstName: " + firstName.toString() + ", \n");
		if (middleName != null) sb.append("\tmiddleName: " + middleName.toString() + ", \n");
		if (profileImageFileName != null) sb.append("\tprofileImageFileName: " + profileImageFileName.toString() + ", \n");
		if (websiteUrl != null) sb.append("\twebsiteUrl: " + websiteUrl.toString() + ", \n");
		if (student != null) sb.append("\tstudent: " + student.toString() + ", \n");
		if (bedkom != null) sb.append("\tbedkom: " + bedkom.toString() + ", \n");
		if (admin != null) sb.append("\tadmin: " + admin.toString() + ", \n");
		if (root != null) sb.append("\troot: " + root.toString() + ", \n");
		if (gender != null) sb.append("\tgender: " + gender.toString() + ", \n");
		if (enrolled != null) sb.append("\tenrollied: " + enrolled.toString() + ", \n");
		if (dateOfBirth != null) sb.append("\tdateOfBirth: " + dateOfBirth.toString() + ", \n");
		if (lastLogin != null) sb.append("\tlastLogin: " + lastLogin.toString() + ", \n");
		sb.append("]");
		return sb.toString();
	}

	public enum Access {
		STYRET("Styret"){ @Override public boolean userHasAccess(User user) { return user.isInStyret();}},
		BEDKOM("Bedkom"){ @Override public boolean userHasAccess(User user) { return user.isInBedkom();}},
		ARRKOM("Arrkom"){ @Override public boolean userHasAccess(User user) { return user.isInArrkom();}},
		VEVKOM("Vevkom"){ @Override public boolean userHasAccess(User user) { return user.isInVevkom();}},
		JENTEKOM("Jentekom"){ @Override public boolean userHasAccess(User user) { return user.isInJentekom();}},
		REDAKSJONEN("Redaksjonen"){ @Override public boolean userHasAccess(User user) { return user.isInRedaksjonen();}},
		UPDATE("Update"){ @Override public boolean userHasAccess(User user) { return user.canReadUpdate();}},
		ADMIN("Admin"){ @Override public boolean userHasAccess(User user) { return user.isAdmin();}},
		ROOT("Root"){ @Override public boolean userHasAccess(User user) { return user.isRoot();}},
		USER("User"){ @Override public boolean userHasAccess(User user) { return !user.isDefault();}},
		NONE("None"){ @Override public boolean userHasAccess(User user) { return true;}};

		private String name;
		public static final Access[] COMMITTEES = new Access[]{STYRET, BEDKOM, ARRKOM, VEVKOM, JENTEKOM, REDAKSJONEN};
		Access(String name) {this.name = name;}
		@Override public String toString() {return name;}
		public static Access fromString(String name) {
			for (Access committee : COMMITTEES) if (committee.toString().equalsIgnoreCase(name)) return committee;
			return NONE;
		}
		public abstract boolean userHasAccess(User user);
	}

	public boolean canReadUpdate() {
		if (this.enrolled == null) return false;
		Calendar date = Calendar.getInstance();
		date.add(Calendar.MONTH, 1);
		return this.enrolled.after(date.getTime());
	}

	public boolean hasAccess(boolean inAll, Access... accessList) {
		//Parameters explained: user: the user you want to check;
		//inAll: set true if you want to check if has ALL entered accesses, false if you want to check if has
		// ANY of the entered accesses.
		//Accesses are entered on the form models.User.Access.<access> (for example: models.User.Access.BEDKOM)

		if (isDefault()) {
			return false;
		}
		if (isRoot()) {
			return true;
		}
		if (inAll) {
			for(Access access : accessList) if(!access.userHasAccess(this)) return false;
			return true;
		}
		for(Access access : accessList) if(access.userHasAccess(this)) return true;
		return false;
	}

	public static boolean hasAccess(User user, boolean inAll, Access... accessList) {
		return user.hasAccess(inAll, accessList);
	}

	public static boolean loggedInUserHasAccess(boolean inAll, Access... accessList) {
		return hasAccess(LoginState.getUser(), inAll, accessList);
	}


	public boolean isBlockedFrom(models.Event event) {
		if (block4FromThisEvent != null)
			return event.getId() == block4FromThisEvent.getId();
		else
			return false;
	}

	public Event getBlockedEvent() {
		return block4FromThisEvent;
	}

	public void setBlockedEvent(Event event) {
		block4FromThisEvent = event;
	}

	public static Model.Finder<Long, User> find = new Finder<>(
			Long.class, User.class
	);

	public static User findByUsername(String username) {
		return find.where().eq("username", username).findUnique();
	}
}
