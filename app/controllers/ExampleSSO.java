package controllers;

import models.HttpRequestData;
import play.mvc.Controller;
import scala.util.matching.Regex$;
import views.html.*;
import play.mvc.Result;

import java.nio.file.Paths;
import java.util.regex.Pattern;

public class ExampleSSO extends Controller {

    public static String innsida_login_link = "https://innsida.ntnu.no/sso/?target=hybridaweb&returnargs=";

    public static Result redirect() {
        return ok("");
    }

    // TODO: Put most code into a model class
    public static Result verify() throws java.io.IOException {
        HttpRequestData http_data = new HttpRequestData();
        String data = http_data.get("data");
        String sign64 = http_data.get("sign64");
        String clientip = http_data.get("clientip");

        String sign = javax.xml.bind.DatatypeConverter.printBase64Binary(sign64.getBytes());

        // Create a hashmap of all the data.
        String[] data_separated = data.split(",");
        java.util.Map<String, String> values = new java.util.HashMap<String, String>();
        for (int i = 0; i < data_separated.length; ++i) {
            if (i + 1 < data_separated.length)
                values.put(data_separated[i + 0], data_separated[i + 1]);
        }
        String username = values.get("username");

        // Get the public key of the crt file:
        //java.util.Scanner scanner = new java.util.Scanner(Paths.get("crtfile"));

        return ok(username);
    }

    public static Result index() {
        return redirect(innsida_login_link); // returnargs is void here, later we must add the return page.
    }
}

