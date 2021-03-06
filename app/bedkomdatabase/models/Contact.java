package bedkomdatabase.models;

import com.avaje.ebean.annotation.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import play.db.ebean.Model;

import javax.persistence.*;
import java.lang.String;
import java.sql.Timestamp;

import models.*;
import profile.models.User;


@Entity
public class Contact extends Model {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(nullable = false)
	long contactId;

	@CreatedTimestamp
	private Timestamp dateMade;

	@UpdatedTimestamp
	private Timestamp whenUpdated;

	private String contact;
	private String telephone;
	private String email;
	@Column(columnDefinition = "text")
	private String other;

	private User madeBy;

	@ManyToOne()
	@JsonBackReference
	private Bedrift bedrift;

	public Contact(String telephone, String contact, String other, String email, Bedrift bedrift) {
		this.telephone = telephone;
		this.contact = contact;
		this.other = other;
		this.email = email;
		this.bedrift = bedrift;
		this.madeBy = LoginState.getUser();
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public static Finder<Long, Contact> find = new Finder<>(
		Long.class, Contact.class
	);

	public long getContactId() {
		return contactId;
	}
}
