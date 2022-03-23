package fields;

import entities.Bot;
import entities.Human;
import model.Game;
import results.Results;
import results.SaveToJson;
import results.SaveToXML;

import java.util.Scanner;

public class TicTac extends Field {
    public static int countGames = 1;
    public static int i = 0;
    public static int j = 1;

    public TicTac() {
        super();
    }

    public void game() {
        initTable();
        printTable();
        while (true) {
            human.turn();
            SaveToXML.listStep.get(i).setTextContent(String.format("%d %d", Human.x + 1, Human.y + 1));
            new Game(); //
            i += 2;
            if (checkResultGame() == false)
                if (requestUserToRepeat() == true) {
                    startNewGame();
                    continue;

                } else break;
            if (checkResultGame() == false) break;
            bot.turn();
            SaveToXML.listStep.get(j).setTextContent(String.format("%d %d", Bot.x + 1, Bot.y + 1));
            new Game(); //
            j += 2;
            printTable();
            if (checkResultGame() == false)
                if (requestUserToRepeat() == true) {
                    {
                        startNewGame();
                        continue;

                    }
                } else break;
        }
    }

    private void outputNothing() {
        printTable();
        System.out.println("У вас ничья!");
        SaveToXML.winPlayer.setTextContent("DRAW!");
        SaveToXML.winPlayer.setAttribute("id", null);
        SaveToXML.winPlayer.setAttribute("name", null);
        SaveToXML.winPlayer.setAttribute("symbol", null);
    }

    private boolean requestUserToRepeat() {
        System.out.println("Хотите сыграть? Ответьте: " + "\n\t" + "1 - ДА" + "\n\t" + "2 - НЕТ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextInt() == 1) return true;
        else return false;
    }

    private boolean winEntity() {
        if (checkWin(SIGN_X)) {
            printTable();
            System.out.println("Вы выиграли!");
            Results.countHuman++;
            SaveToXML.winPlayer.setAttribute("id", String.valueOf(Human.id));
            SaveToXML.winPlayer.setAttribute("name", human.getName());
            SaveToXML.winPlayer.setAttribute("symbol", String.valueOf(TicTac.SIGN_X));
            return false;
        } else if (checkWin(SIGN_O)) {
            System.out.println("Компьютер выиграл!");
            Results.countBot++;
            SaveToXML.winPlayer.setAttribute("id", String.valueOf(Bot.id));
            SaveToXML.winPlayer.setAttribute("name", bot.name);
            SaveToXML.winPlayer.setAttribute("symbol", String.valueOf(TicTac.SIGN_O));
            return false;
        }
        return true;
    }

    private boolean checkResultGame() {
        if (winEntity() == false) return false;
        else if (isTableFull()) {
            outputNothing();
            return false;
        }
        return true;
    }

    private void startNewGame() {
        TicTac ticTac = new TicTac();
        countGames++;
        i = 0;
        j = 1;
        ticTac.initTable();
        ticTac.printTable();
    }
    public void gameAuto(){
        SaveToJson saveToJson = new SaveToJson();
        saveToJson.initGamePlay();
        for(int k = 0; k < 9; k++){
        String step = saveToJson.gamePlay.game.step.get(k).text;
        String id = saveToJson.gamePlay.game.step.get(k).playerId;
        char[] num = step.toCharArray(); // 0 2
            int x = Character.getNumericValue(num[0]);
            int y = Character.getNumericValue(num[2]);
            if(x == 0 && y == 0) break;
            TicTac.table[y-1][x-1] = id.equals("1") ? TicTac.SIGN_X : TicTac.SIGN_O;
            printTable();
        }
        String name = saveToJson.gamePlay.gameResult.player.name;
        if(name.equals("")) System.out.println(" DRAW!");
        else if(name.equals("Al_Bot")) System.out.println("Player 2 -> Al_bot is winner as 'O'!");
        else {System.out.println("Player 1 -> "+name+" is winner as 'X'!");}
    }
}
