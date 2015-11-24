package models;

import play.db.ebean.Model;
import profile.models.User;

import static play.data.Form.form;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.*;

@Entity
public class EventWaitingUsers extends Model {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;

	@ManyToMany
	private List<User> waitingUsers;

	public EventWaitingUsers() {}

	public EventWaitingUsers(EventWaitingUsers evtusers) {
		waitingUsers = new ArrayList<>();
		if (evtusers.waitingUsers != null)
			for (User user : evtusers.waitingUsers) {
				waitingUsers.add(user);
			}
		Collections.reverse(waitingUsers);
	}

	public List<User> getList() {
		return waitingUsers;
	}
}
