package models;

import org.apache.commons.io.FileUtils;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Http;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import play.db.ebean.Model.Finder;

@Entity
@Table(
        name="USER",
        uniqueConstraints=
            @UniqueConstraint(columnNames={"username"})
)
public class User extends Model {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long        id;

    // Name, identification, contact
    public String      username = "guest";  // Assigned by NTNU
    @Column(name = "first_name", columnDefinition = "varchar(256) default 'Fornavn'")
    public String      first_name = null;
    @Column(name = "surname", columnDefinition = "varchar(256) default 'Etternavn'")
    public String      surname = null;
    public String      middle_name = null;
    public String      email = null;
    public String      altemail = null;
    public String      website_url = null;
    public String      phone = null;
    public String      title = null; // Ph.D., Civ.Eng., Stud., Chief, Commander, General, Lord, Admiral, Vevsjef,...
    public String      profile_image_file_name = null;
    // public int         graduation_year = 0;

    // Privilege status
    @Column(name = "student", columnDefinition = "boolean default false")
    public Boolean             student = false;    // No special privileges except for file upload.
    @Column(name = "bedkom", columnDefinition = "boolean default false")
    public Boolean             bedkom = false;     // Control over bedpress.
    @Column(name = "admin", columnDefinition = "boolean default false")
    public Boolean             admin = false;      // For control over the entire page. Check your privilege
    @Column(name = "root", columnDefinition = "boolean default false")
    public Boolean             root = false;       // Powers too great for mere mortals.
    @Column(name = "sex", columnDefinition = "varchar(1) default '\0'")
    public Character           sex = '\0';         // For specific events.
    public Date                enrolled = null;    // For specific bedpresses requiring a year number.
    public Date                date_of_birth = null;

    // Misc. account info
    private Timestamp           last_login = null; // Used to avoid cookie-stealing schemes and MITM attacks. Combined with AES with time and RNG padded encryption.

    public User() {
        student = false;
    }

    public User(String username, String first_name, String surname) {
        this.username = username;
        this.first_name = first_name;
        this.surname = surname;
    }

    public User(String username, String first_name, String surname, String middle_name, String email, String website_url, String phone, String title, int graduation_year, String profile_image_file_name, Boolean student, Boolean bedkom, Boolean admin, Boolean root, Character sex, Date enrolled, Date date_of_birth) {
        this.username = username;
        this.first_name = first_name;
        this.surname = surname;
        this.middle_name = middle_name;
        this.email = email;
        this.website_url = website_url;
        this.phone = phone;
        this.title = title;
//        this.graduation_year = graduation_year;
        this.profile_image_file_name = profile_image_file_name;
        this.student = student;
        this.bedkom = bedkom;
        this.admin = admin;
        this.root = root;
        this.sex = sex;
        this.enrolled = enrolled;
        this.date_of_birth = date_of_birth;
    }

    public void setLastLoginTimeNow() {
        last_login = new Timestamp(new java.util.Date(System.currentTimeMillis()).getTime());
    }

    private boolean thisOrFalse(Boolean object) {
        return (object != null ? object : false);
    }

    public boolean canCreateNewArticle() {
        return thisOrFalse(bedkom) || thisOrFalse(admin) || thisOrFalse(root);
    }

    public boolean hasMiddleName() {
        return middle_name != null;
    }

    public boolean hasAltEmail() {
        return email != null;
    }

    public String getAltEmail() {
        return email;
    }

    public boolean hasWebsite() {
        return website_url != null;
    }

    public String getWebsite() {
        return website_url;
    }

    public boolean hasPhone() {
        return phone != null;
    }

    public String getPhone() {
        return phone;
    }

    public boolean hasProfileImage() {
        return profile_image_file_name != null;
    }

    public String getProfileImageFileName() {
        return profile_image_file_name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public Timestamp getLastLoginTime() {
        return last_login;
    }

    public String getName(boolean showMiddleName) {
        String m = "";
        if(showMiddleName) m = " " + middle_name;
        return first_name + m + " " + surname;
    }

    public String getName() {
        return getName(false);
    }

    public char getGender() {
        return sex;
    }

    public static Finder<Long, User> find = new Finder<>(
            Long.class, User.class
    );

    public Long getId(){
        return id;
    }

    // TODO: Check image size to be within a set range.
    public String uploadPicture() {
        if (student == false && bedkom == false && admin == false && root == false)
            throw new Error("You do not have the privilege as a non-student to upload files!");
        String userFolderPrefix = "public/upload/" + LoginState.getUser().getUsername();
        Http.MultipartFormData body = Controller.request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart picture = body.getFile("picture");
        if (picture != null) {
            String contentType = picture.getContentType();
            if (checkImageType(contentType)) {
                String fileName = picture.getFilename();
                //System.out.println(contentType);
                File file = picture.getFile();
                try {
                    System.out.println(userFolderPrefix);
                    File userFolder = new File(userFolderPrefix);
                    if (!userFolder.exists())
                        userFolder.mkdir();
                    Long prefix = -1L;
                    File destination = new File(userFolderPrefix + "/" + fileName);
                    while (destination.exists()) {
                        ++prefix;
                        destination = new File(userFolderPrefix + "/" + String.valueOf(prefix) + "_" + fileName);
                    }
                    FileUtils.moveFile(file, new File(userFolderPrefix, (prefix == -1L ? "" : String.valueOf(prefix) + "_") + fileName));
                } catch (IOException ioe) {
                    System.out.println("Problem operating on filesystem");
                }
                return "/assets/upload/" + LoginState.getUser().getUsername() + "/" + fileName;
            }
        }
        return null;
    }

    public static boolean checkImageType(String contentType){
        String[] type = contentType.split("/");
        return type[0].equals("image");
    }
}
