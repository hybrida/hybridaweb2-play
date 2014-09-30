package controllers;

import models.HttpRequestData;
import play.mvc.Controller;
import scala.util.matching.Regex$;
import views.html.*;
import play.mvc.Result;

import java.io.FileInputStream;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.util.regex.Pattern;

public class ExampleSSO extends Controller {

    public static String innsida_login_link = "https://innsida.ntnu.no/sso/?target=hybridaweb&returnargs=";

    public static Result redirect() {
        return ok("");
    }

    // TODO: Put most code into a model class
    public static Result verifylogin() throws java.io.IOException, java.security.cert.CertificateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchProviderException {
        HttpRequestData http_data = new HttpRequestData();
        String data = http_data.get("data");
        String sign = http_data.get("sign");
        String clientip = http_data.get("clientip");

        String sign64 = javax.xml.bind.DatatypeConverter.printBase64Binary(sign.getBytes());

        // Create a hashmap of all the data.
        String[] data_separated = data.split(",");
        java.util.Map<String, String> values = new java.util.HashMap<String, String>();
        for (int i = 0; i < data_separated.length; ++i) {
            if (i + 1 < data_separated.length)
                values.put(data_separated[i + 0], data_separated[i + 1]);
        }
        String username = values.get("username");
        String encrypted_username = play.api.libs.Crypto.encryptAES(username);

        java.io.FileInputStream filestream = new java.io.FileInputStream(new java.io.File("innsida.crt"));
        java.security.cert.CertificateFactory cf = java.security.cert.CertificateFactory.getInstance("X.509");
        java.security.cert.Certificate cert = cf.generateCertificate(filestream);

        java.security.PublicKey pubkey = cert.getPublicKey();
        cert.verify(pubkey, sign64);

        session("LOGGED IN COMPLETED", encrypted_username);

        return redirect(routes.Application.index().url());
    }

    public static Result index() {
        return redirect(innsida_login_link); // returnargs is void here, later we must add the return page.
    }
}

