package models;

import play.db.ebean.Model;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(
        name="USER",
        uniqueConstraints=
            @UniqueConstraint(columnNames={"id", "username"})
)
public class User extends Model {
    @Id
    @GeneratedValue
    private Long        id;
    private String      username;
    private String      lName;
    private String      fName;
    private boolean     student;
    private boolean     admin;
    private boolean     bedkom;
    private String      email;
    private Timestamp   last_login;

    public User(String lName, String fName) {
        this.lName = lName;
        this.fName = fName;
        this.student = true;
        this.admin = false;
        this.bedkom = false;
        this.last_login = null;
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
        return fName + " " + lName;
    }

    public static Finder<Long, User> find = new Finder<>(
            Long.class, User.class
    );
}
