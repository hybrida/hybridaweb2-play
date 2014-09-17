package controllers;

import play.mvc.Controller;
import scala.util.matching.Regex$;
import views.html.*;
import play.mvc.Result;

import java.util.regex.Pattern;

public class ExampleSSO extends Controller {

    public static String innsida_login_link = "https://innsida.ntnu.no/sso/?target=hybridaweb&returnargs=";

    public static Result redirect() {
        return ok("");
    }

    public static Result verify(String data, String sign64, String clientip) {
        String sign = javax.xml.bind.DatatypeConverter.printBase64Binary(sign64.getBytes());
        return ok(data);
    }

    public static Result index() {
        /*String to_route = routes.ExampleSSO.verify().absoluteURL(request());
        to_route = to_route.replaceFirst("^https?://", "");
        System.out.println(innsida_login_link + to_route + "," + "/info/henrik");
        return redirect("https://innsida.ntnu.no/sso/?target=hybridaweb&returnargs=");
        */
        return ok(layoutHtml.render("Hybrida", escapeText.render("")));
    }
}

