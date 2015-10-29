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

	private static boolean checkAccess() {
		return !LoginState.getUser().isInBedkom();
	}

	private static Result unauthorize() {
		return redirect(application.routes.Application.showUnauthorizedAccess());
	}

	public static Result index() {
		if (checkAccess()) return unauthorize();

		List<Event> bedpresses = Event.find.setMaxRows(10).where(
			).eq("bedpres", true).findList();
		return ok(pickbedpres.render(bedpresses));
	}

	public static Result pickUsers() {
		if (checkAccess()) return unauthorize();

		HttpRequestData post = new HttpRequestData();
		Long eventId = post.getLong("eventId");
		return pickUsers(eventId);
	}

	public static Result pickUsers(Long eventId) {
		if (checkAccess()) return unauthorize();

		if (eventId == 0)
			return redirect(bedpressblock.routes.BedPresBlock.index().url());
		Event event = Event.find.byId(eventId);
		return ok(selectUser.render(event));
	}

	public static Result blockUser() {
		if (checkAccess()) return unauthorize();

		HttpRequestData post = new HttpRequestData();
		Long eventId = post.getLong("eventId"),
			userId = post.getLong("userId");
		User user = User.find.byId(userId);
		user.setBlockedEvent(Event.find.byId(eventId));
		user.update();

		return pickUsers(eventId);
	}
}
