package models;

/**
 * \brief Utility class to handle everything to do with SSO.
 *
 * The login public interface handles SSO input from Innsida (Feide).
 * The data is separated into a map for easy access. In other words,
 * this class separates the SSO data according to SSO standard (which is not strictly following
 * HTTP GET standard.).
 * We check if the login time. If the provided time is much larger than our current unix time.
 * If it is; we return false: the login fails.
 *
 * We then generate a public key from our certificate and verify the signature to be
 * correct. If it happens to be correct, we return true. Else, false.
 *
 * This class does not check for immutable logins via the database.
 * This class does not check for correct IP addresses.
 * This class does no bookkeeping of any kind.
 */
public class SSOData extends play.db.ebean.Model {

    private java.util.Map<String, String> login_info;

    public java.util.Map<String, String> getLoginInfo() {
        return login_info;
    }

    /**
     *
     * @return true upon successful login.
     * @throws Exception
     */
    public boolean login() throws Exception {
        return login(new HttpRequestData());
    }

    public boolean login(HttpRequestData request_data_header) throws Exception {
        return login(request_data_header.get("data"), request_data_header.get("sign"), request_data_header.get("clientip"));
    }

    public boolean login(String data, String sign64, String clientip) throws Exception {
        long current_unix_time = System.currentTimeMillis() / 1000L;

        byte[] sign = java.util.Base64.getDecoder().decode(sign64);

        // Create a hashmap of all the http data.
        String[] data_separated = data.split(",");
        login_info = new java.util.HashMap<String, String>();
        for (int i = 0; i < data_separated.length; ++i) {
            if (i + 1 < data_separated.length)
                login_info.put(data_separated[i + 0], data_separated[i + 1]);
        }

        // Check some common arguments for soundness and validity.
        if (Long.valueOf(login_info.get("time")) > current_unix_time + 10) {
            return false;
        } if (!login_info.get("target").equals("hybridawebtest")) {
            return false;
        } if (!login_info.get("authdom").equals("ntnu.no")) {
            return false;
        }

        // Generate our public key from innsida.crt. innsida.crt is ONLY available on the server. It MUST REMAIN PRIVATE. DO NOT COMMIT IT. EVER.
        java.io.FileInputStream filestream = new java.io.FileInputStream(new java.io.File(models.Certificate.getPath()));
        java.security.cert.CertificateFactory cf = java.security.cert.CertificateFactory.getInstance("X.509");
        java.security.cert.Certificate cert = cf.generateCertificate(filestream);
        java.security.PublicKey pubkey = cert.getPublicKey();

        return verifySignature(data, pubkey, sign);
    }

    private static boolean verifySignature(String data, java.security.PublicKey key, byte[] signature) throws Exception {
        java.security.Signature signer = java.security.Signature.getInstance("SHA1withRSA");
        signer.initVerify(key);
        signer.update(data.getBytes());
        return (signer.verify(signature));
    }
}
