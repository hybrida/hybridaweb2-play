package renders;

import renders.models.SearchForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import profile.models.User;
import renders.models.Renderable;
import renders.models.Searchable;
import views.html.layoutBoxPage;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static play.data.Form.form;

public class Search extends Controller {

	private static final int PAGE_SIZE = 10;

	private static HashMap<Searchable, Double> cache = new HashMap<>();

	public static Result search(String term, int page) {
		Form<SearchForm> inputForm = form(SearchForm.class).bindFromRequest();
		if (inputForm.hasErrors()) return showEmptySearch();
//		SearchForm input = inputForm.get();
//		String term = input.term;
//		int page = input.page;
		String[] subTerms = term.split("\\s");

		Set<Searchable> resultSet = new HashSet<>();
		for (String subTerm : subTerms) {
			resultSet.addAll(User.search(subTerm));
			resultSet.addAll(renders.models.Renders.search(subTerm));
		}
		if (resultSet.isEmpty()) return showEmptySearch();
		int results = resultSet.size();

		List<Searchable> resultList = new ArrayList<>(resultSet);
		resultList.sort((res1, res2) -> -Double.compare(rate(res1, term), rate(res2, term)));
		for (Searchable res : resultList) {
			System.out.println(res.getSearchHandle() + ": " + rate(res, term));
		}

		cache = new HashMap<>();
		int fromIndex = PAGE_SIZE * page;
		int toIndex = fromIndex + PAGE_SIZE > results ? results : fromIndex + PAGE_SIZE;
		if(fromIndex >= toIndex) return redirect(renders.routes.Search.search(term, (results - 1) / PAGE_SIZE));
		return showResults("Søkeresultater", resultList.subList(fromIndex, toIndex), false, page, term);
	}

	public static double rate(Searchable searchable, String term) {
		if(cache.containsKey(searchable)) return cache.get(searchable);
		String matchString = searchable.getMatchString();
		double score = subRate(matchString, term);
		for (String subTerm : term.split("\\s")) score += subRate(matchString, subTerm);
		cache.put(searchable, score);
		return score;
	}

	private static double subRate(String matchString, String subTerm) {
		String safeTerm = "\\Q" + subTerm + "\\E";
		if(matchString.matches("^" + safeTerm + "$")) return 1;
		double notScore = 1;
		Matcher asWhole = Pattern.compile("\\b" + safeTerm + "\\b").matcher(matchString);
		while(asWhole.find()) notScore *= 0.5;
		Matcher asPart = Pattern.compile(safeTerm).matcher(matchString);
		while(asPart.find()) notScore *= 0.9;
		return 1 - notScore;
	}

	public static Result showResults(String title, List<? extends Renderable> renderables, boolean big, int page, String searchterm) {
		return ok(views.html.layoutWithHead.render(
				"Hybrida - " + title,
				renders.views.html.searchBody.render(title, Renders.rendersHtml(renderables, big), page, searchterm),
				renders.views.html.rendersHead.render()));
	}

	public static Result showEmptySearch() {
		return ok(layoutBoxPage.render("Ingenting Funnet", renders.views.html.emptySearch.render()));
	}
}
