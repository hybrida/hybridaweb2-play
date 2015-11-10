package iktringen;

/**
 * Created by Andreas on 13/10/2015.
 */
public class IKTringen extends play.mvc.Controller {
    public static play.mvc.Result index() {
        return ok(
                views.html.layout.render(
                        "IKTringen",
                        iktringen.views.html.index.render()
                )
        );
    }
}