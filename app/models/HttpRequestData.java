package models;


/**
 * \brief Class used to retrieve all HTTP request data.
 *
 * When this class is instantiated; it fetches the global HTTP request header.
 * Then it parses out both POST and GET data and puts that into a HashMap of
 * Strings. The native Map<String, String> should be used. This class also contains
 * a toString method as to grant the ability to quickly print out all data
 * in the entire HTTP request header.
 */
public class HttpRequestData extends java.util.HashMap<String, String> {

    public HttpRequestData () {
        if (play.data.Form.form().bindFromRequest().data() != null)
            super.putAll(play.data.Form.form().bindFromRequest().data());
    }

    public String toString() {
        String total = "";
        if (!super.isEmpty()) {
            java.util.Set<String> keyset = super.keySet();
            for (String element : keyset) {
                total += element;
                total += '=';
                total += super.get(element);
                total += '\n';
            }
        }
        return total;
    }


}
