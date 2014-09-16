package controllers;

import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.article;
import views.html.layoutHtml;

import java.util.Date;

/**
 * Created by Ivar on 16.09.2014.
 */
public class Article extends Controller {
    public static Result index(){
        String title = "Dette er en artikkel";
        User author = new User("Kråbøl", "Ivar");
        Date posted = new Date(System.currentTimeMillis());
        String content = "ASDFIJASDKFJ KSJADF KJAHDKF JKDSAJF KAJSDKFJ KASDJFK AJSKDFJ KASJDFKJKSDJFKSAJ DKFJASDKJFKASJ FKJS KDF KDS KDFJ KDJF J KJD  KSJDF KJSDKFJ KS JKSDJF KAKSF JK ";
        return ok(layoutHtml.render("Article", article.render(title, author, posted, content)));
    }
}
