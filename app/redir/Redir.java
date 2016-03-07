package redir;

import application.Application;
import play.mvc.Call;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Redir extends Controller {

	private static HashMap<Integer, Call> artiklerMap;
	private static Pattern artiklerPattern = Pattern.compile("^(\\d+)(/|$)");
	private static Result noResult() { return Application.showNotFound();}

	private static void buildArtiklerMap() {
		artiklerMap = new HashMap<>();
		artiklerMap.put(1, staticpages.routes.About.index());
		artiklerMap.put(2, staticpages.routes.Bedrift.index());
		artiklerMap.put(62, staticpages.routes.Ringen.index());
		//TODO: Add more redirections
	}

	public static Result artikler(String path) {
		Matcher matcher = artiklerPattern.matcher(path);
		if(!matcher.find()) return noResult();
		Integer id;
		try {
			id = Integer.parseInt(matcher.group(1));
		} catch(IllegalStateException | NumberFormatException e){
			return noResult();
		}
		if(artiklerMap == null) buildArtiklerMap();
		if(!artiklerMap.containsKey(id)) return noResult();
		return redirect(artiklerMap.get(id));
	}


	public static Result nyheter() {
		return redirect(application.routes.Application.index());
	}


}
