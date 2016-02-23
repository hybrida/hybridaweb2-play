package test;

import models.ArticleSQL;
import play.mvc.*;

public class TestDatabase extends Controller {
	public static Result index() {
		(new ArticleSQL()).createNewArticle(1L);
		return ok("ok");
	}
}
