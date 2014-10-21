package models;

import play.db.ebean.Model;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(
        name="USER",
        uniqueConstraints=
            @UniqueConstraint(columnNames={"id", "username"})
)
public class User extends Model {

    @Id @GeneratedValue
    private Long        id;

    // Name, identification, contact
    private String      username;  // Assigned by NTNU
    private String      first_name = null;
    private String      surname = null;
    private String      email = null;
    private String      title = null; // Ph.D., Civ.Eng., Stud., Chief, Commander, General,...

    // Privilege status
    private Boolean             student = true;    // No special privileges.
    private Boolean             bedkom = false;    // Control over bedpress.
    private Boolean             admin = false;     // For control over the entire page.
    private Boolean             root = false;      // Powers too great for mere mortals.
    private Character           sex = '\0';        // For specific events.
    private java.util.Date      enrolled = null;   // For specific bedpresses.
    private Date                date_of_birth = null;

    // Misc. account info
    private Timestamp           last_login = null; // Used to avoid cookie-stealing schemes and MITM attacks. Combined with AES with time and RNG padded encryption.

    public User(String first_name, String surname) {
        this.first_name = first_name;
        this.surname = surname;
    }

    public void setLastLoginTimeNow() {
        last_login = new Timestamp(new java.util.Date(System.currentTimeMillis()).getTime());
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

    public String getName() {
        return first_name + " " + surname;
    }

    public static Finder<Long, User> find = new Finder<>(
            Long.class, User.class
    );
}
