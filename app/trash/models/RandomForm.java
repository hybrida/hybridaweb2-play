package trash.models;

import play.data.validation.Constraints;

public class RandomForm {
    @Constraints.Required
    public int numberFrom;
    public int numberTo;
}
