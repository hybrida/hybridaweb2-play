package quiz;

import com.avaje.ebean.Ebean;
import models.QuizSeason;
import models.QuizTeam;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;
import views.html.layoutPage;

import java.util.List;

import static play.mvc.Results.ok;

public class QuizController extends Controller {
	public static Result index() {
		return ok(layoutPage.render(
			"Quiz",
			quiz.views.html.index.render(),
			quiz.views.html.head.render(),
			null,
			null,
			null,
			null));
	}

	public static Result quizTeams() {
		List<QuizTeam> teams = QuizTeam.findAllTeams();
		return ok(Json.toJson(teams));
	}

	public static Result putTeam() {
		JsonNode json = request().body().asJson();

		QuizTeam edited = Json.fromJson(json, QuizTeam.class);
		QuizTeam toBeSaved;

		if (edited.id == null) {
			toBeSaved = edited;
		} else {
			toBeSaved = QuizTeam.findById(edited.id);
			toBeSaved.name = edited.name;
			toBeSaved.description = edited.description;
		}

		toBeSaved.save();

		return ok(Json.toJson(toBeSaved));
	}

	public static Result deleteTeamById(Long id){
		QuizTeam team = QuizTeam.findById(id);

		if (team != null) {
			Ebean.delete(team);
			return ok("Deleted " + id);
		} else {
			return badRequest("Error: could not find any team with id=<" + id + ">.");
		}
	}

	public static Result quizSeasons() {
		List<QuizSeason> seasons = QuizSeason.findAllSeasons();
		return ok(Json.toJson(seasons));
	}

	/**
	 * If id is specifies, attempts to update existing entity. Does nothing
	 * if there is no matching entity.
	 *
	 * If id is not specified, creates new entity.
	 *
	 * @return the entity as it is saved to the database
	 */
	public static Result putSeason() {
		JsonNode json = request().body().asJson();

		QuizSeason edited = Json.fromJson(json, QuizSeason.class);
		QuizSeason toBeSaved;

		if (edited.id == null) {
			toBeSaved = edited;
		} else {
			toBeSaved = QuizSeason.findById(edited.id);
			toBeSaved.seasonNumber = edited.seasonNumber;
			toBeSaved.description = edited.description;
		}

		toBeSaved.save();

		return ok(Json.toJson(toBeSaved));
	}

	public static Result deleteSeasonById(Long id) {
		QuizSeason season = QuizSeason.findById(id);

		if (season != null) {
			Ebean.delete(season);
			return ok("Deleted " + id);
		} else {
			return badRequest("Error: could not find any quiz seasonNumber with id=<" + id + ">.");
		}
	}

}
