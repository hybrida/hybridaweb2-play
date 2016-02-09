package bedkom;

/**
 * Created by TrulsElg on 03/11/15.
 */
public class Bedkom extends play.mvc.Controller {
    public static play.mvc.Result index() {

        return ok(
                views.html.layoutWithHead.render(
                        "Bedkom",
                        bedkom.views.html.bedkomHead.render(),
                        bedkom.views.html.bedkomBody.render()
                )
        );
    }
}
