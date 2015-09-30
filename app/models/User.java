package models;

import org.apache.commons.io.FileUtils;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Http;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.lang.Enum;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

@Entity
@Table(
	name="USER",
	uniqueConstraints=
		@UniqueConstraint(columnNames= {"username"})
)
public class User extends Model {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public Long        id;

	// Name, identification, contact
	public String      username;  // Assigned by NTNU
	@Column(name = "first_name", columnDefinition = "varchar(256) default 'Fornavn'")
	public String      firstName;
	@Column(name = "surname", columnDefinition = "varchar(256) default 'Etternavn'")
	public String      surname;
	@Column(name = "middle_name")
	public String      middleName;
	public String      email;
	@Column(name = "website_url")
	public String      websiteUrl;
	public String      phone;
	public String      title; // Ph.D., Civ.Eng., Stud., Chief, Commander, General, Lord, Admiral, Vevsjef,...
	@Column(name = "profile_image_file_name")
	public String      profileImageFileName;
	@Column(name = "graduation_year")
	public Integer graduationYear = 0;

	// Privilege status
	@Column(name = "student", columnDefinition = "boolean default false")
	public Boolean             student;    // No special privileges except for file upload.
	@Column(name = "bedkom", columnDefinition = "boolean default false")
	public Boolean             bedkom;     // Control over bedpress.
	@Column(name = "arrkom", columnDefinition = "boolean default false")
	public Boolean             arrkom;     // Control over arrkom.
	@Column(name = "vevkom", columnDefinition = "boolean default false")
	public Boolean             vevkom;     // Control over vevkom.
	@Column(name = "admin", columnDefinition = "boolean default false")
	public Boolean             admin;      // For control over the entire page. Check your privilege
	@Column(name = "root", columnDefinition = "boolean default false")
	public Boolean             root;       // Powers too great for mere mortals.
	@Column(name = "gender", columnDefinition = "char(1) default '\0'")
	public Character           gender;         // For specific events.
	public Timestamp           enrolled;    // For specific bedpreses requiring a year number.
	@Column(name = "date_of_birth")
	public Timestamp           dateOfBirth;

	// Misc. account info
	@Column(name = "last_login")
	private Timestamp          lastLogin; // Used to avoid cookie-stealing schemes and MITM attacks. Combined with AES with time and RNG padded encryption.

	public User() {}

	public User(String username, String firstName, String surname) {
		this.username = username;
		this.firstName = firstName;
		this.surname = surname;
	}

	public User(
		String username,
		String firstName,
		String surname,
		String middleName,
		String email,
		String websiteUrl,
		String phone,
		String title,
		int graduationYear,
		String profileImageFileName,
		Boolean student,
		Boolean bedkom,
		Boolean arrkom,
		Boolean vevkom,
		Boolean admin,
		Boolean root,
		Character gender,
		Timestamp enrolled,
		Timestamp dateOfBirth) {
			this.username = username;
			this.firstName = firstName;
			this.surname = surname;
			this.middleName = middleName;
			this.email = email;
			this.websiteUrl = websiteUrl;
			this.phone = phone;
			this.title = title;
			this.graduationYear = graduationYear;
			this.profileImageFileName = profileImageFileName;
			this.student = student;
			this.bedkom = bedkom;
			this.admin = admin;
			this.root = root;
			this.gender = gender;
			this.enrolled = enrolled;
			this.dateOfBirth = dateOfBirth;
	}

	public boolean isDefault() {
		return (id == null);
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

	public boolean isRoot() {
		return thisOrFalse(root);
	}

	public boolean hasMiddleName() {
		return middleName != null && !middleName.equals("");
	}

	public boolean hasEmail() {
		return email != null && !email.equals("");
	}

	public String getEmail() {
		return email;
	}

    public void setEmail(String email) {
        this.email = email;
    }

	public boolean hasWebsiteUrl() {
		return websiteUrl != null && !websiteUrl.equals("");
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public boolean hasPhone() {
		return phone != null && !phone.equals("");
	}

	public String getPhone() {
		return phone;
	}

    public void setPhone(String phone) {
        this.phone = phone;
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

    public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public Timestamp getLastLoginTime() {
		return lastLogin;
	}

	public String getName(boolean showMiddleName) {
		String m = "";
		if (showMiddleName) m = " " + middleName;
		return firstName + m + " " + surname;
	}

	public String getName() {
		return getName(false);
	}

	public char getGender() {
		return gender;
	}

    public Long getId() {
		return id;
	}

	public int calculateClass() {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
		int classYear = 5 - (graduationYear - currentYear);
		if (currentMonth >= 8) // July, MONTH is [0, 11]
			classYear += 1;
		return classYear;
	}

	public static boolean checkImageType(String contentType) {
		String[] type = contentType.split("/");
		return type[0].equals("image");
	}

	public void saveToSession() {
		play.mvc.Controller.session("user", play.api.libs.Crypto.encryptAES(username + "," + String.valueOf(System.currentTimeMillis())));
	}

    public void updateFromForm(Form<User> form) {
        if(isSet(form.apply("email").value())) setEmail(form.apply("email").value());
        if(isSet(form.apply("websiteUrl").value())) setWebsiteUrl(form.apply("websiteUrl").value());
        if(isSet(form.apply("phone").value())) setPhone(form.apply("phone").value());
        if(isSet(form.apply("profileImageFileName").value())) setProfileImageFileName(form.apply("profileImageFileName").value());
        save();
    }

    public static boolean isSet(String field) {
        return field != null && field.length() > 0;
    }

	public String toString() {
		StringBuilder sb = new StringBuilder("USER[\n");
		if (id != null) sb.append("\tid: " + id.toString() + ", \n");
		if (email != null) sb.append("\temail: " + email.toString() + ", \n");
		if (phone != null) sb.append("\tphone: " + phone.toString() + ", \n");
		if (title != null) sb.append("\ttitle: " + title.toString() + ", \n");
		if (username != null) sb.append("\tusername: " + username.toString() + ", \n");
		if (surname != null)  sb.append("\tsurname: " + surname.toString() + ", \n");
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

	public enum Access{
		BEDKOM,
		ARRKOM,
		VEVKOM,
		ADMIN,
		ROOT;
	}

	public static boolean hasAccess(User user, boolean inAll, Access... accessList){
		//Parameters explained: user: the user you want to check;
		//inAll: set true if you want to check if user has ALL entered accesses, false if you want to check if user has
		// ANY of the entered accesses.
		//Accesses are entered on the form models.User.Access.<access> (for example: models.User.Access.BEDKOM)

		if(user.isDefault()){
			return false;
		}
		if(inAll == false){
			boolean access = false;
			for (Access i : accessList){
				if (i == Access.BEDKOM){
					access = user.bedkom;
				}
				if (i == Access.ARRKOM){
					access = user.arrkom;
				}
				if (i == Access.VEVKOM){
					access = user.vevkom;
				}
				if (i == Access.ADMIN){
					access = user.admin;
				}
				if (i == Access.ROOT){
					access = user.root;
				}
				if (access == true){
					return true;
				}
			}
			return false;
		}
		else {
			boolean tempHasAccess = false;
			for (Access i : accessList) {
				if (i == Access.BEDKOM) {
					tempHasAccess = user.bedkom;
				}
				if (i == Access.ARRKOM) {
					tempHasAccess = user.arrkom;
				}
				if (i == Access.VEVKOM) {
					tempHasAccess = user.vevkom;
				}
				if (i == Access.ADMIN) {
					tempHasAccess = user.admin;
				}
				if (i == Access.ROOT) {
					tempHasAccess = user.root;
				}
				if (tempHasAccess == false) {
					return false;
				}
			}
			if (tempHasAccess == false){
				return false;
			}
			return true;
		}
	}

    public static Finder<Long, User> find = new Finder<>(
            Long.class, User.class
    );

    public static User findByUsername(String username){
        return find.where().eq("username", username).findUnique();
    }
}
