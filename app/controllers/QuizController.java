package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.QuizSeason;
import models.QuizTeam;
import play.libs.Json;
import play.mvc.BodyParser;
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

//        return ok(views.html.layoutWithHead.render(
//                    "Quiz"
//                    , views.html.Quiz.index.render()
//                    , views.html.Quiz.head.render()
//            ));
    }

    public static Result quizTeams() {
        List<QuizTeam> teams = QuizTeam.findAllTeams();
        return ok(Json.toJson(teams));
    }

    public static Result addQuizTeam() {
        JsonNode json = request().body().asJson();

        QuizTeam team = Json.fromJson(json, QuizTeam.class);
        team.save();
        return ok("Team " + team.teamName + " saved.");
    }

}
