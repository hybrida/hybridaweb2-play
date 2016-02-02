package renders;

import java.util.*;

import application.Application;
import models.SearchForm;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;
import profile.models.User;
import renders.models.Renderable;
import views.html.layoutBoxPage;

import static play.data.Form.form;

/**
 * Created by ivar on 29.10.2015.
 */
public class Renders extends Controller {

	public static Result showRenders(String title, List<? extends Renderable> renderables, boolean big) {
		return showRenders(title, renderables, big, 0, "");
	}

	public static Result showRenders(String title, List<? extends Renderable> renderables, boolean big, int page, String searchterm) {
		List<Html> rendersHtml = new ArrayList<>();

		int count = 0;
		for (Renderable renderable : renderables) {
			if (count++ < 1 && big) rendersHtml.add(renders.views.html.renderBig.render(renderable.render()));
			else rendersHtml.add(renders.views.html.renderSmall.render(renderable.render()));
		}

		return ok(views.html.layoutWithHead.render(
				"Hybrida - " + title,
				renders.views.html.rendersBody.render(title, rendersHtml, page, searchterm),
				renders.views.html.rendersHead.render()));
	}

	public static Result search() {
		Form<SearchForm> input = form(SearchForm.class).bindFromRequest();

		SearchForm saved = new SearchForm();
		if (input.hasErrors()) {
			saved.term = "";
			saved.page = models.HttpRequestData.getLongStatic("page").toString();
			// return Application.showUnauthorizedAccess();
		} else {
			saved = input.get();
		}
		{

			String key = saved.term;
			key = "%" + key + "%";

			Integer page = saved.page == null || saved.page == "" ? null : Integer.parseInt(saved.page);
			if (page == null) page = 0;

			String head = "eventReference.articleRef.",
					art = "articleReference.";

			int pagesize = 10;

			List<User> renderableUsers = User.find.where().disjunction()
					.like("username", key)
					.like("first_name", key)
					.like("last_name", key)
					.like("middle_name", key)
					.like("title", key)
					.like("email", key)
					.like("phone", key)
					.endJunction().findPagingList(pagesize).getPage(page).getList();

			List<renders.models.Renders> renderableRenders = renders.models.Renders.find.where(
			).disjunction()
					.like(art + "ingress", key)
					.like(art + "title", key)
					.like(art + "text", key)
					.like(head + "ingress", key)
					.like(head + "title", key)
					.like(head + "text", key)
					.endJunction()
					.orderBy().desc("renderId").findPagingList(pagesize).getPage(page).getList();

			Collection<? extends Renderable> renderables = CollectionUtils.union(renderableUsers, renderableRenders);

			if (renderables.isEmpty()) {
				return ok(layoutBoxPage.render("Ingenting Funnet", renders.views.html.emptySearch.render()));
			} else {
				return showRenders("Søkeresultater", new ArrayList<>(renderables), false, page, saved.term);
			}
		}
	}

	public static Result newsfeed() {
		List<renders.models.Renders> articles = renders.models.Renders.getVisibleRenderables();
		return showRenders("Newsfeed", articles, true);
	}

}
