package models;

import play.db.ebean.Model;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

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
    public String      first_name = null;
    public String      surname = null;
    public String      email = null;
    public String      title = null; // Ph.D., Civ.Eng., Stud., Chief, Commander, General, Lord, Admiral, Vevsjef,...

    // Privilege status
    public Boolean             student = false;    // No special privileges.
    public Boolean             bedkom = false;    // Control over bedpress.
    public Boolean             admin = false;     // For control over the entire page. Check your privilege
    public Boolean             root = false;      // Powers too great for mere mortals.
    public Character           sex = '\0';        // For specific events.
    public java.util.Date      enrolled = null;   // For specific bedpresses requiring a year number.
    public Date                date_of_birth = null;

    // Misc. account info
    private Timestamp           last_login = null; // Used to avoid cookie-stealing schemes and MITM attacks. Combined with AES with time and RNG padded encryption.

    public User() {
        
    }

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
