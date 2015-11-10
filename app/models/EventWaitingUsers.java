package models;

import play.db.ebean.Model;
import play.data.format.Formats;
import play.twirl.api.Html;
import play.data.Form;
import static play.data.Form.form;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import javax.persistence.*;

@Entity
public class EventWaitingUsers extends Model {

	@Id
	private Long id;

	@ManyToMany
	private List<User> waitingUsers;

	public List<User> getList() {
		return waitingUsers;
	}
}
