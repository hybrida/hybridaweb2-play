package controllers;

import com.google.common.collect.Lists;
import models.*;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.layout;

import static models.Article.getArticleData;

public class Application extends Controller {

    /**
     * \brief Application class, handles basic site functionality.
     *
     * Handles basic functionality and responses. Handles index site,
     * unauthorized access requests, 404 and 400 results, etc.
     *
     */

    /**
     * \brief Index entry point of the website.
     */
    public static Result index() {
        java.util.List<Renderable> articles = models.Renders.getVisibleRenderables();
        String concatenation = "";
        int i = 0;
        for (Renderable renderable : Lists.reverse(articles)) {
            ++i;
            if (i <= 2)
                concatenation += "<div class='col-md-6' style='padding: 1%'>";
            else
                concatenation += "<div class='col-md-3'style='padding: 1%'>";
            concatenation += renderable.renderFrontPageSample();
            concatenation += "</div>";
        }
        return ok(layout.render("Hybrida", views.html.Application.index.render(views.html.utils.toHtml.render(concatenation))));
    }

    /**
     * Useful functions to use to return standard messages to the client.
     * @return
     */
    public static Result showUnauthorizedAccess() {
        return unauthorized(layout.render("Unauthorized", views.html.Application.showUnauthorizedAccess.render()));
    }

    public static Result show404(String get_value) {
    	return notFound(layout.render("404", views.html.Application.show404.render(get_value)));
    }

    public static Result show400(String get_value) {
        return badRequest(layout.render("400", views.html.Application.show400.render(get_value)));
    }

    public static Result checkEditPrivilege(User user) {
        if (user.isDefault()) {
            return controllers.Application.show400("Du må logge inn for å endre arransjement.");
        } if (!user.canCreateNewArticle()) {
          return controllers.Application.show400("Du har ikke rettighetene til å endre på arransjementer.");
        }
        return null;
    }

    /**
     * Experimental code
     * @return
     * @throws java.sql.SQLException
     */
    public static Result proto()  throws java.sql.SQLException {
        java.util.List<Renderable> articles = models.Renders.getVisibleRenderables();
        String concatenation = "";
        for (Renderable renderable : articles) {
            concatenation += renderable.renderFrontPageSample();
        }
        if (true)
            return ok(views.html.protoFrontPage.render(play.twirl.api.Html.apply(concatenation)));
        return ok(views.html.protoFrontPage.render(play.twirl.api.Html.apply(getArticleData())));

        //return ok(views.html.Application.index.render(play.twirl.api.Html.apply("This is some stuff")));
    }

    public static Result bootstrapTest() {
        return ok(views.html.BootTest.render());
    }
}
