package models;

import play.data.validation.Constraints;

/**
 * Created by ivarhk on 16.09.14.
 */
public class ExampleEbeanForm {
    @Constraints.Required
    public String name;

    public String create;
    public String clear;
}
