package voting;

import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

import play.data.DynamicForm;
import play.data.Form;
import profile.models.User;

import static play.mvc.Results.ok;
import static play.mvc.Results.redirect;

public class VoteController extends Controller {

    private static List<String> votes = new ArrayList<>();
    private static List<String> choices = new ArrayList<>();
    private static List<Long> usersThatHasVoted = new ArrayList<>();//TODO: alternatives to List

    public static Result index() {
        if (choices == null) choices = generateGenericChoices();
        return ok(views.html.layout.render("stemming", voting.views.html.voteview.render(choices)));
    }
    private static List<String> generateGenericChoices() {
        List<String> choices = new ArrayList<String>();
        choices.add("blankt");
        choices.add("Simen");
        choices.add("Kia");
        choices.add("Truls");
        return choices;
    }

    public static Result attemptVote() {
        if (!models.LoginState.isValidlyLoggedIn())
            return redirect(application.routes.Application.showUnauthorizedAccess().url());//TODO: redirect to login page instead
        User loginUser = models.LoginState.getUser();
        if (!usersThatHasVoted.contains(loginUser.getId())) {//TODO: add isMember check
            usersThatHasVoted.add(loginUser.getId());
            vote(Form.form().bindFromRequest());
        }
        return redirect(voting.routes.VoteController.index());
    }
    private static void vote(DynamicForm dynamicForm) {
        votes.add(dynamicForm.get("selected"));
    }


    public static Result overview() {
        User loginUser = models.LoginState.getUser();

        //should get changed to a specific user or something
        if (!loginUser.isAdmin()) return redirect(application.routes.Application.showUnauthorizedAccess().url());

        List<Candidate> candidates = createCandidatesFromChoices();
        countVotes(candidates);
        return ok(views.html.layout.render("Oversikt", voting.views.html.overview.render(candidates)));
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
            if (vote == null) continue;//TODO: fix properly
            for (Candidate candidate : candidates) {
                if (vote.equals(candidate.name)) {
                    candidate.votes += 1;
                }
            }
        }
    }

    public static Result newVoting() {
        User loginUser = models.LoginState.getUser();
        if (!loginUser.isAdmin()) {//should get changed to a specific user or something
            return redirect(application.routes.Application.showUnauthorizedAccess().url());
        }
        DynamicForm dynamicForm = Form.form().bindFromRequest();
        choices = new ArrayList<String>(dynamicForm.data().values());
        return redirect(voting.routes.VoteController.index());
    }
}
