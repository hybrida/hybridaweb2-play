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

    private static int nr;
    private static String title = "Avstemning";
    private static List<String> votes = new ArrayList<>();
    private static List<String> choices = new ArrayList<>();
    private static List<Long> usersThatHasVoted = new ArrayList<>();
    private static boolean member;

    public static Result index() {
        if (choices == null || choices.size() == 0) choices = generateGenericChoices();
        return ok(views.html.layout.render("Avstemning", ballot.views.html.voteview.render(choices, title, nr)));
    }

    public static Result lazyRedirect() {
        return redirect(ballot.routes.VoteController.index());
    }

    private static List<String> generateGenericChoices() {
        List<String> choices = new ArrayList<String>();
        choices.add("Blank");
        choices.add("Vevkom");
        choices.add("Bedkom");
        choices.add("Arrkom");
        choices.add("Jentekom");
        return choices;
    }

    public static Result getChoices() {
        if (choices == null || choices.size() == 0) choices = generateGenericChoices();
        return ok(Json.toJson(new BallotChoices(nr, title, choices)));
    }

    public static Result attemptVote() {

        if (!models.LoginState.isValidlyLoggedIn())
            return ok("Du må være innlogget for å stemme");

        User loginUser = models.LoginState.getUser();
        if (loginUser.getId() < 2) return ok("Rotbrukeren kan ikke stemme");
        if (member && !loginUser.isMember()) return ok("Kun medlemmer av Hybrida kan stemme");
        if (usersThatHasVoted.contains(loginUser.getId())) return ok("Du har allerede stemt");

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
        if (!loginUser.getUsername().equals("simennje")) {
            return redirect(application.routes.Application.showUnauthorizedAccess().url());
        }

        return ok(views.html.layout.render("Oversikt", ballot.views.html.overview.render()));
    }

    public static Result getResults() {
        if (!models.LoginState.isValidlyLoggedIn())
            return redirect(sso.routes.SSOLogin.login(play.mvc.Http.Context.current().request().path()).url());

        User loginUser = models.LoginState.getUser();
        if (!loginUser.getUsername().equals("simennje")) {
            List<Candidate> candidates = new ArrayList<>();
            candidates.add(new Candidate("vevkom"));
            candidates.get(0).votes = 9001;
            candidates.add(new Candidate("andre"));
            return ok(Json.toJson(new BallotResult("Hvem er best?", candidates)));
        }

        List<Candidate> candidates = createCandidatesFromChoices();
        countVotes(candidates);
        return ok(Json.toJson(new BallotResult(title, candidates)));
    }

    private static List<Candidate> createCandidatesFromChoices() {
        List<Candidate> candidates = new ArrayList<>();
        for (String choice : choices) {
            candidates.add(new Candidate(choice));
        }
        return candidates;
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
        if (!loginUser.getUsername().equals("simennje")) {
            return redirect(application.routes.Application.showUnauthorizedAccess().url());
        }

        createBallot(Form.form().bindFromRequest());
        return redirect(ballot.routes.VoteController.overview());
    }

    private static void createBallot(DynamicForm dynamicForm) {
        title = dynamicForm.data().remove("title");
        member = dynamicForm.data().remove("member") != null;
        choices = new ArrayList<String>(dynamicForm.data().values()); //TODO: input sanitizing (f.eks. ")
        votes = new ArrayList<>();
        usersThatHasVoted = new ArrayList<>();
        nr++;
    }
}
