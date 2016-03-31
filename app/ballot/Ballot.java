package ballot;

import java.util.List;

public class Ballot {
    public final String title;
    public final List<Candidate> results;

    public Ballot(String title, List<Candidate> results) {
        this.title = title;
        this.results = results;
    }
}
