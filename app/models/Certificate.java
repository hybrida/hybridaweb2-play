package models;

/**
 * Holds the link to the certificate file and other information.
 */
public class Certificate {
    public static String getPath() {
        return "innsida.crt";
    }
    public static String getSignMethod() { return "X.509"; }
}
