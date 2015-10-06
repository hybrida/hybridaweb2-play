package bedriftTest;

/**
 * Created by TrulsElg on 22/09/15.
 */
public class BedriftTest extends play.mvc.Controller {
    public static play.mvc.Result index() {
        return ok(
                views.html.layout.render(
                        "BedriftTest",
                        bedriftTest.views.html.index.render()
                )
        );
    }
}