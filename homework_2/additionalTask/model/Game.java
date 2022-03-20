package model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import results.SaveToXML;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect
public class Game {
    @JsonProperty("Step")
    public List<Step> step = new ArrayList<>();

    public Game() {
        for(int i = 0; i < 9; i++){
        Step step1 = new Step();

        step1.num = String.valueOf(i+1); //
        step1.playerId = String.valueOf(i%2==0? 1:2);
        step1.text = String.valueOf(SaveToXML.listStep.get(i).getTextContent()); //

        step.add(step1);
        }
    }
}
