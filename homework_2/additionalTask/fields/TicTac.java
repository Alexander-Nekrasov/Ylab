package fields;

import entities.Bot;
import entities.Human;
import results.Results;

public class TicTac extends Field {
    public TicTac() {
        super();
    }

    public void game() {
        initTable();
        printTable();
        while (true) {
            human.turn();
            if (checkWin(SIGN_X)) {
                printTable();
                System.out.println("Вы выиграли!");
                Results.countHuman++;
                break;
            }
            if (isTableFull()) {
                printTable();
                System.out.println("У вас ничья!");
                break;
            }

            bot.turn();
            printTable();
            if (checkWin(SIGN_O)) {
                System.out.println("Компьютер выиграл!");
                Results.countBot++;
                break;
            }
            if (isTableFull()) {
                printTable();
                System.out.println("У вас ничья!");
                break;
            }
        }
    }

}
