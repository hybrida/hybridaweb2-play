package article;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

import java.util.ArrayList;
import java.util.List;

import static play.data.Form.form;

/**
 * Created by eliasbragstadhagen on 04.02.15.
 */
public class Article extends Controller {

	public static Result index(String id) {
		if (models.Article.find.byId(Long.valueOf(id)) == null)
			return application.Application.show404(request().uri().replaceFirst("/", ""));
		Long lId = Long.parseLong(id);
		models.Article article = getArticle(lId);
		models.Event event = getEvent(article);

		List<String> resultList = new ArrayList<String>();
		resultList.add(article.getTitle());
		resultList.add(article.getIngress());
		resultList.add(article.getText());
		resultList.add(article.getImagePath());
		resultList.add(models.User.find.byId(article.getAuthor()).getName());
		resultList.add(article.getDateMade().toString());

		if(event != null) {
			resultList.add(event.getLocation());
			resultList.add(event.getEventHappens().toString());
			resultList.add("" + event.getMaxParticipants());
		}
		return ok(layout.render("hybrida", views.html.utils.centerBlock.render(views.html.ArticleOut.index.render(resultList))));
	}

	public static Result editArticle(String id) {
		Result error = application.Application.checkEditPrivilege(models.LoginState.getUser());
		if (error != null)
			return error;
		models.Article article = models.Article.find.byId(Long.valueOf(id));
		return ok(layout.render("Hybrida: Opprett Artikkel", views.html.ArticleIn.editArticle.render(article)));
	}

	public static Result viewArticle(String id) {
		application.Application x = new application.Application();
		try {
			if (models.Article.find.byId(Long.valueOf(id)) != null)
				return ok(layout.render("Artikkel", views.html.ArticleOut.viewArticle.render(models.Article.find.byId(Long.valueOf(id)))));
			else
				return application.Application.show404(request().uri().replaceFirst("/", ""));
		} catch (java.lang.NumberFormatException exception) {
			return application.Application.show400("Sent erroneous input to viewArticle: " + id);
		}
	}

	public static models.Article getArticle(long articleId) {
		models.Article article = models.Article.find.byId(articleId);
		return article;
	}

	public static models.Event getEvent(models.Article article) {
		//controllers.BackupDatabase.index();
		models.Event event = models.Event.find.where().eq("articleId", article.getId()).findUnique();
		return event;
	}

	public static Result joinEvent(String eventId) {
		return ok();
	}

	public static Result abandonEvent(String eventId) {
		return ok();
	}

	/**
	 * Writes a comment to the database, with a relation to the given article, and the user currently signed in
	 * @param articleId
	 * @return
	 */

	public static Result comment(String articleId){
		String comment = new models.HttpRequestData().get("comment");
		models.Comment newComment = new models.Comment(comment, models.Article.find.byId(Long.parseLong(articleId)));
		newComment.save();
		if(new models.HttpRequestData().get("isEvent") != null){
			return redirect("/event/ut/?id=" + (new models.HttpRequestData().get("isEvent")));
		}
		return redirect("/artikkel/" + articleId.toString());
	}

	/**
	 * Finds a comment by commentID, and deletes it from the database. Should be protected from misuse by using the POST method
	 * through routes.
	 * @param commentId
	 * @return
	 */
	public static Result deleteComment(String commentId){
		models.Comment thisComment = models.Comment.find.byId(Long.parseLong(commentId));
		models.Article article = thisComment.getArticle();
		thisComment.delete();
		if(new models.HttpRequestData().get("isEvent") != null){
			return redirect("/event/ut/" + new models.HttpRequestData().get("isEvent"));
		}
		return redirect("/artikkel/" + (article.getId().toString()));
	}
}
