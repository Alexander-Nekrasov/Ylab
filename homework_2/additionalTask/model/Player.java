package model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class Player {
    @JsonProperty("-id")
    public String id;
    @JsonProperty("-name")
    public String name;
    @JsonProperty("-symbol")
    public String symbol;

    public Player() {}
}
