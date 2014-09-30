package controllers;

import models.Article;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.articleview;
import views.html.layoutHtml;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Ivar on 16.09.2014.
 */
public class Articles extends Controller {
    public static Result index(){
        String title = "Dette er en artikkel";
        User author = new User("Kråbøl", "Ivar");
        Date posted = new Date(System.currentTimeMillis());
        String content = "ASDFIJASDKFJ KSJADF KJAHDKF JKDSAJF KAJSDKFJ KASDJFK AJSKDFJ KASJDFKJKSDJFKSAJ DKFJASDKJFKASJ FKJS KDF KDS KDFJ KDJF J KJD  KSJDF KJSDKFJ KS JKSDJF KAKSF JK ";
        Article article = new Article(title, content, author, new Timestamp(posted.getTime()));
        return ok(layoutHtml.render("Article", articleview.render(article)));
    }
}