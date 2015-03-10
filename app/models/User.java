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
    public String      first_name;
    @Column(name = "surname", columnDefinition = "varchar(256) default 'Etternavn'")
    public String      surname;
    public String      middle_name;
    public String      email;
    public String      website_url;
    public String      phone;
    public String      title; // Ph.D., Civ.Eng., Stud., Chief, Commander, General, Lord, Admiral, Vevsjef,...
    public String      profile_image_file_name;
    // public int         graduation_year = 0;

    // Privilege status
    @Column(name = "student", columnDefinition = "boolean default false")
    public Boolean             student;    // No special privileges except for file upload.
    @Column(name = "bedkom", columnDefinition = "boolean default false")
    public Boolean             bedkom;     // Control over bedpress.
    @Column(name = "admin", columnDefinition = "boolean default false")
    public Boolean             admin;      // For control over the entire page. Check your privilege
    @Column(name = "root", columnDefinition = "boolean default false")
    public Boolean             root;       // Powers too great for mere mortals.
    @Column(name = "sex", columnDefinition = "varchar(1) default '\0'")
    public Character           sex;         // For specific events.
    public Date                enrolled;    // For specific bedpresses requiring a year number.
    public Date                date_of_birth;

    // Misc. account info
    private Timestamp          last_login; // Used to avoid cookie-stealing schemes and MITM attacks. Combined with AES with time and RNG padded encryption.

    public User() {}

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

    public boolean isDefault() {
        return (id == null);
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
        return middle_name != null && !middle_name.equals("");
    }

    public boolean hasAltEmail() {
        return email != null && !email.equals("");
    }

    public String getAltEmail() {
        return email;
    }

    public boolean hasWebsite() {
        return website_url != null && !website_url.equals("");
    }

    public String getWebsite() {
        return website_url;
    }

    public boolean hasPhone() {
        return phone != null && !phone.equals("");
    }

    public String getPhone() {
        return phone;
    }

    public boolean hasProfileImage() {
        return profile_image_file_name != null && !profile_image_file_name.equals("");
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

    public Long getId() {
        return id;
    }

    // TODO: Check image size to be within a set range.
    public String uploadPicture() {
        if (isDefault())
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

    public static boolean checkImageType(String contentType) {
        String[] type = contentType.split("/");
        return type[0].equals("image");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("USER[\n");
        if(id != null) sb.append("\tid: " + id.toString() + ", \n");
        if(email != null) sb.append("\temail: " + email.toString() + ", \n");
        if(phone != null) sb.append("\tphone: " + phone.toString() + ", \n");
        if(title != null) sb.append("\ttitle: " + title.toString() + ", \n");
        if(username != null) sb.append("\tusername: " + username.toString() + ", \n");
        if(surname != null)  sb.append("\tsurname: " + surname.toString() + ", \n");
        if(first_name != null) sb.append("\tfirst_name: " + first_name.toString() + ", \n");
        if(middle_name != null) sb.append("\tmiddle_name: " + middle_name.toString() + ", \n");
        if(profile_image_file_name != null) sb.append("\tprofile_image_file_name: " + profile_image_file_name.toString() + ", \n");
        if(website_url != null) sb.append("\twebsite_url: " + website_url.toString() + ", \n");
        if(student != null) sb.append("\tstudent: " + student.toString() + ", \n");
        if(bedkom != null) sb.append("\tbedkom: " + bedkom.toString() + ", \n");
        if(admin != null) sb.append("\tadmin: " + admin.toString() + ", \n");
        if(root != null) sb.append("\troot: " + root.toString() + ", \n");
        if(sex != null) sb.append("\tsex: " + sex.toString() + ", \n");
        if(enrolled != null) sb.append("\tenrollied: " + enrolled.toString() + ", \n");
        if(date_of_birth != null) sb.append("\tdate_of_birth: " + date_of_birth.toString() + ", \n");
        if(last_login != null) sb.append("\tlast_login: " + last_login.toString() + ", \n");
        sb.append("]");
        return sb.toString();
    }

    public static Model.Finder<Long, User> find = new Finder<>(
            Long.class, User.class
    );
}
