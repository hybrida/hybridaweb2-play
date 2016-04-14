package ballot;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BallotChoices {
    @JsonProperty
    public final int nr;
    @JsonProperty
    public final String title;
    @JsonProperty
    public final List<String> choices;

    public BallotChoices(int nr, String title, List<String> choices) {
        this.nr = nr;
        this.title = title;
        this.choices = choices;
    }

}
