package jonasasa;
import play.mvc.Result;
import play.mvc.Controller;
import views.html.layout;
public class Jonasasa extends Controller{
	public static Result index(){
		return ok(layout.render("Hello World", jonasasa.views.html.index.render()));
	}
}