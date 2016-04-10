package examples.models;

import play.data.validation.Constraints;

public class ExampleEbeanForm {
    @Constraints.Required
    public String name;

    public String create;
    public String clear;
}
