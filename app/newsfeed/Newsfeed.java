package newsfeed;

import com.google.common.collect.Lists;
import models.LoginState;
import models.Renders;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;

/**
 * Created by ivar on 29.10.2015.
 */
public class Newsfeed extends Controller {
    public static Result index() {
        java.util.List<Renders> articles = models.Renders.getVisibleRenderables();
        String concatenation = "";
        int count = 0;
        for (Renders renderable : Lists.reverse(articles)) {
            Html curcatenation = Html.apply("");
            models.Article art = renderable.articleReference;
            models.Event evt = renderable.eventReference;
            if (renderable.articleReference != null) {
                curcatenation = newsfeed.views.html.articleRenderFrontPageSample.render(art);
            } else if (renderable.eventReference != null) {
                art = evt.getArticle();
                curcatenation = newsfeed.views.html.eventRenderFrontPageSample.render(art, evt);
            }

            if (++count < 2) {
                concatenation += newsfeed.views.html.bigthumbnail.render(curcatenation);
            } else {
                concatenation += newsfeed.views.html.smallthumbnail.render(curcatenation);
            }
        }
        //Example for user access check:
        System.out.println(User.hasAccess(LoginState.getUser(), true, User.Access.BEDKOM, User.Access.ADMIN));
        return ok(views.html.layoutWithHead.render(
                "Hybrida - Newsfeed",
                newsfeed.views.html.newsfeedBody.render(views.html.utils.toHtml.render(concatenation)),
                newsfeed.views.html.newsfeedHead.render()));
    }
}
