package company;

/**
 * Created by Bourgond on 3/17/2015.
 */
public class Company extends play.mvc.Controller {
	public static play.mvc.Result index() {
		return ok(
			views.html.layout.render(
				"Bedrift",
				company.views.html.index.render()
			)
		);
	}
}
