package model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class Step {
    @JsonProperty("-num")
    public String num;
    @JsonProperty("-playerId")
    public String playerId;
    @JsonProperty("#text")
    public String text;

    public Step() {}
}
