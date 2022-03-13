package fields;

import entities.Bot;
import entities.Human;
import results.Results;
import xml.SaveToXML;

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
            SaveToXML.listStep.get(i).setTextContent(String.format("%d %d",Human.x+1,Human.y+1));
            i+=2;
            if (checkResultGame() == false)
                if (requestUserToRepeat() == true) {
                    TicTac ticTac = new TicTac();
                    countGames++;
                    ticTac.initTable();
                    ticTac.printTable();
                    continue;
                } else break;
            if (checkResultGame() == false) break;
            bot.turn();
            SaveToXML.listStep.get(j).setTextContent(String.format("%d %d",Bot.x+1,Bot.y+1));
            j+=2;
            printTable();
            if (checkResultGame() == false)
                if (requestUserToRepeat() == true) {
                    {
                        TicTac ticTac = new TicTac();
                        countGames++;
                        ticTac.initTable();
                        ticTac.printTable();
                        continue;
                    }
                } else break;
        }
    }

    private void outputNothing() {
        printTable();
        System.out.println("У вас ничья!");
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
}
