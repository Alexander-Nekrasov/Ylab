package fields;

import results.Results;

import java.util.Scanner;

public class TicTac extends Field {
    public TicTac() {
        super();
    }

    public void game() {
        initTable();
        printTable();
        while (true) {
            human.turn();
            if (checkResultGame() == false) 
                if (requestUserToRepeat() == true)
                    new TicTac().game();
                else break;
            if(checkResultGame() == false) break;
            bot.turn();
            printTable();
            if (checkResultGame() == false)
                if (requestUserToRepeat() == true){
                    new TicTac().game();
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
            return false;
        } else if (checkWin(SIGN_O)) {
            System.out.println("Компьютер выиграл!");
            Results.countBot++;
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
