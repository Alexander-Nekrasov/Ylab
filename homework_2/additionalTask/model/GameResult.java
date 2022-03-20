package model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import results.SaveToXML;

@JsonAutoDetect
public class GameResult {
    @JsonProperty("Player")
    Player player = new Player();

    public GameResult() {
        player.id = String.valueOf(SaveToXML.winPlayer.getAttribute("id"));
        player.name = SaveToXML.winPlayer.getAttribute("name");
        player.symbol = String.valueOf(SaveToXML.winPlayer.getAttribute("symbol"));

    }
}
