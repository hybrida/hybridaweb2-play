package models;

import play.data.validation.Constraints;

public class SearchForm {
	@Constraints.Required
	public String term;
}
