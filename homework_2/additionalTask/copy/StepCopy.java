package copy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StepCopy {
    @JsonProperty("-num")
    public String num;
    @JsonProperty("-playerId")
    public String playerId;
    @JsonProperty("#text")
    public String text;
}
