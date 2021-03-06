package bedpressblock;

import models.LoginState;
import renders.models.Renders;
import profile.models.User;
import models.Event;
import models.HttpRequestData;
import play.mvc.Controller;
import play.mvc.Result;
import bedpressblock.views.html.*;
import java.util.List;
import views.html.*;

public class BedPresBlock extends Controller {

	private static boolean checkAccess() {
		return !LoginState.getUser().isInBedkom();
	}

	private static Result unauthorize() {
		return redirect(application.routes.Application.showUnauthorizedAccess());
	}

	public static Result index() {
		if (checkAccess()) return unauthorize();

		List<Renders> bedpresses = Renders.find.setMaxRows(10).where(
			).eq("eventReference.bedpres", true).findList();
		return ok(layoutBoxPage.render("Bedpres Prikking", pickbedpres.render(bedpresses,
			-1L)));
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
		return ok(layoutBoxPage.render("Bedpres Prikking", selectUser.render(event)));
	}

	public static Result blockUser() {
		if (checkAccess()) return unauthorize();

		HttpRequestData post = new HttpRequestData();
		Long eventId = post.getLong("eventId"),
			userId = post.getLong("userId");
		User user = User.find.byId(userId);
		Event event = Event.find.byId(eventId);
		Event blocked = user.getBlockedEvent();
		if (blocked != null && blocked.getId() == eventId)
			user.setBlockedEvent(null);
		else
			user.setBlockedEvent(event);
		user.update();

		return pickUsers(eventId);
	}
}
