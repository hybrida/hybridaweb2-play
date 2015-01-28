package trash.models;

import play.data.validation.Constraints;

public class CookieForm {
    @Constraints.Required
    public String key;
    public String value;
}
