package nomination;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.layoutWithHead;
import play.libs.*;

import play.data.Form;
import static play.data.Form.form;

import java.text.ParseException;

import article.views.html.*;
import views.html.layout;
import views.html.utils.centerBlock;
import models.*;


/**
 * Created by Torsten on 22.09.15
 */
public class Nomination extends Controller {
    final static public Result index() {  return ok(layoutWithHead.render(
                                                            "Griffens Orden Nominasjon",
                                                             nomination.views.html.nominasjonbody.render(),
                                                             nomination.views.html.griffensOrdenhead.render()));

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
    }
**/
 }

