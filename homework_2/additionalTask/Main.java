import fields.TicTac;
import results.Results;
import xml.SaveToXML;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TicTac ticTac = new TicTac();
        ticTac.game();
        new Results();
        new AddDataGameToXml().appendChild();
        SaveToXML.getTransformer();
        SaveToXML.XmlToConsole();
    }
}

class AddDataGameToXml{
    void appendChild(){
        SaveToXML.root.appendChild(SaveToXML.player1);
        SaveToXML.root.appendChild(SaveToXML.player2);
        SaveToXML.root.appendChild(SaveToXML.game);
        for(int i = 0; i < 9; i++) SaveToXML.game.appendChild(SaveToXML.listStep.get(i));
        SaveToXML.root.appendChild(SaveToXML.gameResult);
        SaveToXML.gameResult.appendChild(SaveToXML.winPlayer);
        SaveToXML.doc.appendChild(SaveToXML.root);
    }
}