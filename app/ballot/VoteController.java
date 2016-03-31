package ballot;

import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import profile.models.User;

import java.util.ArrayList;
import java.util.List;

public class VoteController extends Controller {

    private static String title = "Avstemning";
    private static List<String> votes = new ArrayList<>();
    private static List<String> choices = new ArrayList<>();
    private static List<Long> usersThatHasVoted = new ArrayList<>();

    public static Result index() {
        if (choices == null || choices.size() == 0) choices = generateGenericChoices();
        return ok(views.html.layout.render("Avstemning", ballot.views.html.voteview.render(choices, title)));
    }

    private static List<String> generateGenericChoices() {
        List<String> choices = new ArrayList<String>();
        choices.add("Blankt");
        choices.add("Vevkom");
        choices.add("Bedkom");
        choices.add("Arrkom");
        choices.add("Jentekom");
        return choices;
    }

    public static Result attemptVote() {

        if (!models.LoginState.isValidlyLoggedIn())
            return ok("Du må være innlogget for å stemme");

        User loginUser = models.LoginState.getUser();
        if (usersThatHasVoted.contains(loginUser.getId())) {//TODO: add isMember check
            return ok("Du har allerede stemt");
        }

        String vote = Form.form().bindFromRequest().get("option");
        if (choices.contains(vote)) {
            usersThatHasVoted.add(loginUser.getId());
            votes.add(vote);
            return ok("Du stemte på: " + vote);
        }

        return ok("Du avga ingen stemme");
    }

    public static Result overview() {

        if (!models.LoginState.isValidlyLoggedIn())
            return redirect(sso.routes.SSOLogin.login(play.mvc.Http.Context.current().request().path()).url());

        User loginUser = models.LoginState.getUser();
        if (!loginUser.isAdmin()) {//should get changed to a specific user or something
            return redirect(application.routes.Application.showUnauthorizedAccess().url());
        }

        return ok(views.html.layout.render("Oversikt", ballot.views.html.overview.render()));
    }

    private static List<Candidate> createCandidatesFromChoices() {
        List<Candidate> candidates = new ArrayList<>();
        for (String choice : choices) {
            candidates.add(new Candidate(choice));
        }
        return candidates;
    }

    public static Result getResults() {
        User loginUser = models.LoginState.getUser();
        if (!loginUser.isAdmin()) {//should get changed to a specific user or something
            List<Candidate> candidates = new ArrayList<>();
            candidates.add(new Candidate("vevkom"));
            candidates.get(0).votes = 9001;
            candidates.add(new Candidate("andre"));
            return ok(Json.toJson(candidates));
        }

        List<Candidate> candidates = createCandidatesFromChoices();
        countVotes(candidates);
        return ok(Json.toJson(new Ballot(title, candidates)));
    }

    private static void countVotes(List<Candidate> candidates) {//TODO: using outputparameter, should find better solution
        for (String vote : votes) {
            for (Candidate candidate : candidates) {
                if (vote.equals(candidate.name)) {
                    candidate.votes += 1;
                }
            }
        }
    }

    public static Result newBallot() {

        if (!models.LoginState.isValidlyLoggedIn())
            return redirect(sso.routes.SSOLogin.login(play.mvc.Http.Context.current().request().path()).url());

        User loginUser = models.LoginState.getUser();
        if (!loginUser.isAdmin()) {//should get changed to a specific user or something
            return redirect(application.routes.Application.showUnauthorizedAccess().url());
        }

        createBallot(Form.form().bindFromRequest());
        return redirect(ballot.routes.VoteController.index());
    }

    private static void createBallot(DynamicForm dynamicForm) {
        title = dynamicForm.data().get("title");
        dynamicForm.data().remove("title");
        choices = new ArrayList<String>(dynamicForm.data().values());
        votes = new ArrayList<>();
        usersThatHasVoted = new ArrayList<>();
    }
}
