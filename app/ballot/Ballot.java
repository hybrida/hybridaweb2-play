package ballot;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;

public class Ballot {
    @JsonProperty
    public final String title;
    @JsonProperty
    public final List<Candidate> results;

    public Ballot(String title, List<Candidate> results) {
        this.title = title;
        this.results = results;
    }

    @JsonProperty
    public int total() {
        return results.stream().mapToInt(c->c.votes).sum();
    }
}
