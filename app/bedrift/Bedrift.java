package bedrift;

/**
 * Created by TrulsElg on 22/09/15.
 */
public class Bedrift extends play.mvc.Controller {
    public static play.mvc.Result index() {
        return ok(
                views.html.layout.render(
                        "Bedrift",
                        bedrift.views.html.index.render()
                )
        );
    }
}