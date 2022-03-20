package model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import entities.Bot;
import entities.Human;
import fields.TicTac;
import results.SaveToXML;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect
@JsonRootName("GamePlay") //
public class GamePlay {
    @JsonIgnore
    public Player player1 = new Player();
    @JsonIgnore
    public Player player2 = new Player();
    @JsonProperty("Player")
    public List<Player> player = new ArrayList<>();
    @JsonProperty("Game")
    public Game game = new Game();
    @JsonIgnore
    public Step step = new Step();
    @JsonProperty("GameResult")
    public GameResult gameResult = new GameResult(); //

    public GamePlay(){
        Human human = new Human();
        player1.id = String.valueOf(Human.id);
        player1.name = SaveToXML.player1.getAttribute("name");
        player1.symbol = String.valueOf(TicTac.SIGN_X);
        player.add(player1);


        Bot bot = new Bot();
        player2.id = String.valueOf(Bot.id);
        player2.name = bot.name;
        player2.symbol = String.valueOf(TicTac.SIGN_O);
        player.add(player2);


    }
}
