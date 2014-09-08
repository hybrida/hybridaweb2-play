package models;

import play.db.ebean.Model;
import play.data.validation.Constraints;

public class Search extends Model {
	@Constraints.Required
	public String term;
}