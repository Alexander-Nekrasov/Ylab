package results;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import model.GamePlay;
import copy.Copy;

import java.io.File;
import java.io.IOException;



public class SaveToJson implements SaveTo {
    @JsonProperty("GamePlay")
    public GamePlay gamePlay = new GamePlay();

    @Override
    public void getTransformer() {
        SaveToJson saveToJson = new SaveToJson();
        /* Путь к файлу поменял*/
        File file = new File(new PathFiles("js.json").absolutePath());
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(file, saveToJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initGamePlay(){
            File file = new File(new PathFiles("js.json").absolutePath());

            ObjectMapper mapper = new ObjectMapper();
            Copy copy = null;
            try {
                copy = mapper.readValue(file, Copy.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            gamePlay = copy.GamePlay;
    }

//    public static void main(String[] args) {
//        SaveToJson saveToJson = new SaveToJson();
//        saveToJson.initGamePlay();
//
//        System.out.println(saveToJson.gamePlay.player.get(0).name);
//    }

}

