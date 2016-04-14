package article;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;
import views.html.layoutWithHead;

/**
 * Created by eliasbragstadhagen on 04.02.15.
 */
public class Article extends Controller {

	public static Result editArticle(String id) {
		Result error = application.Application.checkEditPrivilege(
			models.LoginState.getUser());
		if (error != null)
			return error;

		models.Article inarticle = models.Article.find.byId(Long.valueOf(id));
		return ok(layoutWithHead.render(
				"Hybrida: Opprett Artikkel"
				, article.views.html.editArticle.render(inarticle)
		    , article.views.html.editHead.render()));
	}

	public static Result viewArticle(String id) {
		application.Application x = new application.Application();
		try {
			models.ArticleSQL articlesql = new models.ArticleSQL();
			articlesql.viewArticle(id);
			if (models.Article.find.byId(Long.valueOf(id)) != null)
				return ok(layout.render("Artikkel",
					article.views.html.viewArticle.render(
						models.Article.find.byId(Long.valueOf(id)))));
			else
				return application.Application.show404(request().uri().replaceFirst("/", ""));
		} catch (java.lang.NumberFormatException exception) {
			return application.Application.show400(
				"Sent erroneous input to viewArticle: " + id);
		}
	}

	public static models.Article getArticle(long articleId) {
		models.Article article = models.Article.find.byId(articleId);
		return article;
	}

	public static models.Event getEvent(models.Article article) {
		models.Event event = models.Event.find.where().eq(
			"articleId", article.getId()).findUnique();
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
		models.Comment newComment = new models.Comment(
			comment, models.Article.find.byId(Long.parseLong(articleId)));
		newComment.save();
		if (new models.HttpRequestData().get("isEvent") != null){
			return redirect(article.routes.Event.viewEvent(new models.HttpRequestData().get("isEvent")));
		}
		return redirect(article.routes.Article.viewArticle(articleId.toString()));
	}

	/**
	 * Finds a comment by commentID, and deletes it from the database. Should be protected from misuse by using the POST method
	 * through routes.
	 * @param commentId
	 * @return
	 */
	public static Result deleteComment(String commentId){
		models.Comment thisComment = models.Comment.find.byId(
			Long.parseLong(commentId));
		models.Article local_article = thisComment.getArticle();
		thisComment.delete();
		if (new models.HttpRequestData().get("isEvent") != null){
			return redirect(article.routes.Event.viewEvent(new models.HttpRequestData().get("isEvent")));
		}
		return redirect(article.routes.Article.viewArticle(local_article.getId().toString()));
	}
}
