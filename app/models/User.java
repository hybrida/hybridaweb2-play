package models;

import play.db.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by Ivar on 09.09.2014.
 */
@Entity
public class User extends Model {
    private String lName;
    private String fName;
    private boolean student;
    private boolean admin;
    private boolean bedkom;

    public User(String lName, String fName) {
        this.lName = lName;
        this.fName = fName;
        this.student = true;
        this.admin = false;
        this.bedkom = false;
    }

    public String getName() {
        return fName + " " + lName;
    }
}
