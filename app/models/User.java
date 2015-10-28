package models;

import controllers.Upload;
import exceptions.NoFileInRequest;
import exceptions.ServerError;
import exceptions.Unauthorized;
import play.data.Form;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import util.Validator;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(
	name="USER",
	uniqueConstraints=
		@UniqueConstraint(columnNames= {"USERNAME"})
)
public class User extends Model implements ImmutableUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	public Long        id;

	// Name, identification, contact
	public String      username;  // Assigned by NTNU
    @Required
	@Column(name = "FIRST_NAME", columnDefinition = "varchar(256) default 'Fornavn'", nullable = false)
	public String      firstName;
    @Required
    @Column(name = "LAST_NAME", columnDefinition = "varchar(256) default 'Etternavn'", nullable = false)
	public String      lastName;
	@Column(name = "MIDDLE_NAME")
	public String      middleName;
    @Column(name = "EMAIL")
	public String      email;
	@Column(name = "WEBSITE_URL")
	public String      websiteUrl;
    @Column(name = "PHONE")
	public String      phone;
    @Column(name = "TITLE")
	public String      title; // Ph.D., Civ.Eng., Stud., Chief, Commander, General, Lord, Admiral, Vevsjef,...
	@Column(name = "GRADUATION_YEAR")
	public Integer     graduationYear = 0;
    @Enumerated(EnumType.STRING)
    @Column(name = "SPECIALIZATION")
	public Specialization specialization = Specialization.NONE;
    @Column(name = "PROFILE_IMAGE_FILE_NAME")
	public String      profileImageFileName;

	// Privilege status
	@Column(name = "STUDENT", columnDefinition = "boolean default false")
	public Boolean             student;    // No special privileges except for file ajaxUpload.
	@Column(name = "BEDKOM", columnDefinition = "boolean default false")
	public Boolean             bedkom;     // Control over bedpress.
	@Column(name = "ARRKOM", columnDefinition = "boolean default false")
	public Boolean             arrkom;     // Control over arrkom.
	@Column(name = "VEVKOM", columnDefinition = "boolean default false")
	public Boolean             vevkom;     // Control over vevkom.
	@Column(name = "ADMIN", columnDefinition = "boolean default false")
	public Boolean             admin;      // For control over the entire page. Check your privilege
	@Column(name = "ROOT", columnDefinition = "boolean default false")
	public Boolean             root;       // Powers too great for mere mortals.
	@Column(name = "GENDER", columnDefinition = "char(1) default '\0'")
	public Character           gender;     // For specific events.
    @Column(name = "ENROLLED")
	public Timestamp           enrolled;   // For specific bedpreses requiring a year number.
	@Column(name = "DATE_OF_BIRTH")
	public Timestamp           dateOfBirth;

	// Misc. account info
	@Column(name = "LAST_LOGIN")
	private Timestamp          lastLogin; // Used to avoid cookie-stealing schemes and MITM attacks. Combined with AES with time and RNG padded encryption.
    @Column(name = "PROFILE_IMAGE_POS")
    public Double              profileImagePos;

	public User() {}

	public User(String username, String firstName, String lastName) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
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


    // Getters and Setter (and some hassers)

    public Long getId() {
        return id;
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

    public Timestamp getLastLoginTime() {
		return lastLogin;
	}

	public char getGender() {
		return gender;
	}

	public boolean isRoot() {
		return thisOrFalse(root);
	}

	public boolean isFirstUser() {
		return getId() == 1;
	}

    public boolean hasProfileImagePos() {
        return profileImagePos != null;
    }

    public Double getProfileImagePos() {
        return profileImagePos;
    }

    public void setProfileImagePos(Double profileImagePos) {
        this.profileImagePos = profileImagePos;
    }

    public String uploadPicture(String inputName) {
        try {
            return Upload.upload(inputName);
        } catch (Unauthorized unauthorized) {
            unauthorized.printStackTrace();
        } catch (NoFileInRequest noFileInRequest) {
            noFileInRequest.printStackTrace();
        } catch (ServerError serverError) {
            serverError.printStackTrace();
        }
        return null;
    }

    public int calculateClass() {
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
		save();
	}

	public String getProfilePictureWithFallBackOnDefault() {
		return getProfileImageFileName().equals("") ? "/assets/images/logo_big.png" : "/assets/uploads/" + getUsername() + "/" + getProfileImageFileName();
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
		BEDKOM,
		ARRKOM,
		VEVKOM,
		ADMIN,
		ROOT;
	}

	public static boolean hasAccess(boolean inAll, Access... accessList) {
		return hasAccess(LoginState.getUser(), inAll, accessList);
	}

	public static boolean hasAccess(User user, boolean inAll, Access... accessList) {
		//Parameters explained: user: the user you want to check;
		//inAll: set true if you want to check if user has ALL entered accesses, false if you want to check if user has
		// ANY of the entered accesses.
		//Accesses are entered on the form models.User.Access.<access> (for example: models.User.Access.BEDKOM)

		if (user.isDefault()) {
			return false;
		}
		if (inAll == false) {
			boolean access = false;
			for (Access i : accessList) {
				if (i == Access.BEDKOM) {
					access = user.bedkom;
				}
				if (i == Access.ARRKOM) {
					access = user.arrkom;
				}
				if (i == Access.VEVKOM) {
					access = user.vevkom;
				}
				if (i == Access.ADMIN) {
					access = user.admin;
				}
				if (i == Access.ROOT) {
					access = user.root;
				}
				if (access == true) {
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
			if (tempHasAccess == false) {
				return false;
			}
			return true;
		}
	}

	public static Model.Finder<Long, User> find = new Finder<>(
		Long.class, User.class
	);

	public static User findByUsername(String username) {
		return find.where().eq("username", username).findUnique();
	}
}
