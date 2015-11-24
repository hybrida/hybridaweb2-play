package omiktringen;

/**
 * Created by Andreas on 17/11/2015.
 */
public class omIKTRingen extends play.mvc.Controller {
    public static play.mvc.Result index() {

        return ok(
                views.html.layoutWithHead.render(
                        "omiktringen",
                        omiktringen.views.html.index.render(),
                        omiktringen.views.html.head.render()
                )
        );
    }
}