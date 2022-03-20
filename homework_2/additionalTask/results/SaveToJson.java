package results;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.GamePlay;

import java.io.File;
import java.io.IOException;



public class SaveToJson implements SaveTo {
    @JsonProperty("GamePlay")
    public GamePlay gamePlay = new GamePlay();

    @Override
    public void getTransformer() {
        SaveToJson saveToJson = new SaveToJson();
        /* Путь к файлу поменял*/
        File file = new File("C:\\Users\\musoc\\Desktop\\JavaRush\\Ylab\\Ylab\\homework_2\\additionalTask\\files\\js.json");
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(file, saveToJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

