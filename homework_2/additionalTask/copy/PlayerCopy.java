package copy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerCopy {
    @JsonProperty("-id")
    public String id;
    @JsonProperty("-name")
    public String name;
    @JsonProperty("-symbol")
    public String symbol;
}
