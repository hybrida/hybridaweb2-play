package bedpressblock;

import models.LoginState;
import models.Renders;
import models.User;
import models.Event;
import models.HttpRequestData;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;
import bedpressblock.views.html.*;
import java.util.List;

public class BedPresBlock extends Controller {
	public static Result index() {
		// Choose an event to inspect
		List<Event> bedpresses = Event.find.setMaxRows(10).where(
			).eq("bedpres", true).findList();
		return ok(pickbedpres.render(bedpresses));
	}

	public static Result pickUsers() {
		HttpRequestData post = new HttpRequestData();
		Long eventId = post.getLong("eventId");
		return pickUsers(eventId);
	}

	public static Result pickUsers(Long eventId) {
		if (eventId == 0)
			return redirect(bedpressblock.routes.BedPresBlock.index().url());
		Event event = Event.find.byId(eventId);
		return ok(selectUser.render(event));
	}

	public static Result blockUser() {
		HttpRequestData post = new HttpRequestData();
		Long eventId = post.getLong("eventId"),
			userId = post.getLong("userId");
		User user = User.find.byId(userId);
		user.setBlockedEvent(Event.find.byId(eventId));
		user.update();

		return pickUsers(eventId);
	}
}
