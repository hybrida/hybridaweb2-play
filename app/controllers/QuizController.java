package controllers;

import com.avaje.ebean.Ebean;
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
                views.html.Quiz.index.render(),
                views.html.Quiz.head.render(),
                null,
                null,
                null,
                null
        ));
    }

    public static Result quizTeams() {
        List<QuizTeam> teams = QuizTeam.findAllTeams();
        return ok(Json.toJson(teams));
    }

    public static Result saveTeam() {
        JsonNode json = request().body().asJson();

        QuizTeam edited = Json.fromJson(json, QuizTeam.class);
        QuizTeam saved;
        if (edited.id == null) {
            edited.save();
            saved = edited;
        } else {
            saved = QuizTeam.findById(edited.id);
            saved.name = edited.name;
            saved.description = edited.description;
            saved.save();
        }
        return ok(Json.toJson(saved));
    }

    public static Result deleteTeamById(Long id){
        QuizTeam team = QuizTeam.findById(id);
        if (team != null) {
            Ebean.delete(team);
            return ok("Deleted " + id);
        } else {
            return badRequest("Error: could not find any team with id " + id);
        }
    }

}
