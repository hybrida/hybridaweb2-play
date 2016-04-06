package renders.models;

import play.data.validation.Constraints;

public class SearchForm {
	@Constraints.Required
	public String term;
	public Integer page = 0;

	public SearchForm() {}
	public SearchForm(Integer page) {
		this.page = page;
	}
}
