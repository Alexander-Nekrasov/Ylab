package fields;

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
            if (check() == false) break;

            bot.turn();
            printTable();
            if (check() == false) break;

        }
    }

    private void outputNothing() {
        printTable();
        System.out.println("У вас ничья!");
    }

    private boolean win() {
        if (checkWin(SIGN_X)) {
            printTable();
            System.out.println("Вы выиграли!");
            Results.countHuman++;
            return false;
        } else if (checkWin(SIGN_O)) {
            System.out.println("Компьютер выиграл!");
            Results.countBot++;
            return false;
        }
        return true;
    }

    private boolean check() {
        if (win() == false) return false;
        else if (isTableFull()) {
            outputNothing();
            return false;
        }
        return true;
    }
}
