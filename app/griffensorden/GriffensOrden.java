package griffensorden;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layoutWithHead;


/**
 * Created by Torsten on 11.02.15
 */
public class GriffensOrden extends Controller {
    static public Result index() {  return ok(layoutWithHead.render("Griffens Orden", griffensorden.views.html.griffensOrdenBody.render(), griffensorden.views.html.griffensOrdenHead.render()));
    }

    static public Result riddere() {
        return ok(
                layoutWithHead.render(
                        "Griffens Orden",
                        griffensorden.views.html.riddereBody.render(),
                        griffensorden.views.html.griffensOrdenHead.render()
                )
        );
    }
    static public Result nomination() {  return ok(layoutWithHead.render(
            "Griffens Orden Nominasjon",
            griffensorden.views.html.nominationBody.render(),
            griffensorden.views.html.griffensOrdenHead.render()));

    }
/**
 public static Result save() {
 try {
 User user = LoginState.getUser();
 if (user == null || !user.canCreateNewArticle())
 return application.Application.showUnauthorizedAccess();
 models.Article art = saveArticle();
 if (!(new HttpRequestData().get("event") == null)) {
 ResultAndEId res = saveEvent(art, null);
 if (res.result != null)
 return res.result;
 Renders.addEvent(res.event);
 return redirect(article.routes.Event.viewEvent("" + res.event.getId()));
 }
 else {
 Renders.addArticle(art);
 return redirect(article.routes.Article.viewArticle("" + art.getId()));
 }
 }
 catch (IllegalStateException e) {
 return application.Application.show400("ugyldig data oppgitt: " + e);
 }
 catch (Exception e) {
 e.printStackTrace();
 return ok(e.toString());
 }
 } **/
}
