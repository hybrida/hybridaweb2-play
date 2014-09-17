package models;

import play.data.validation.Constraints;
/**
 * Created by eliasbragstadhagen on 16.09.14.
 */
public class LolForm {
    @Constraints.Required
    public String gamertag;
}
