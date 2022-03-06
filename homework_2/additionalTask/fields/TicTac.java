package fields;

import entities.Bot;
import entities.Human;
import results.Results;

public class TicTac {
   public static final char SIGN_X = 'X';
   public static final char SIGN_O = 'O';
   public static final char SIGN_EMPTY = '-';
   public static char[][] table;

    Human human;
    Bot bot;

    public TicTac() {
        human = new Human();
        bot = new Bot();
        table = new char[][]{
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };
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

    void initTable() {
        for (int ord = 0; ord < 3; ord++) {
            for (int abs = 0; abs < 1; abs++) {
                table[ord][abs] = SIGN_EMPTY;
            }
        }
    }

    void printTable() {
        for (int ord = 0; ord < 3; ord++) {
            System.out.print("|");
            for (int abs = 0; abs < 3; abs++) {
                System.out.print(table[ord][abs] + "|");
            }
            System.out.println();
        }
    }

    boolean checkWin(char dash) {
        for (int i = 0; i < 3; i++) {
            if ((table[i][0] == dash && table[i][1] == dash && table[i][2] == dash) ||
                    (table[0][i] == dash && table[1][i] == dash && table[2][i] == dash))
                return true;// ||| ___
            if ((table[0][0] == dash && table[1][1] == dash && table[2][2] == dash) ||
                    (table[2][0] == dash && table[1][1] == dash && table[0][2] == dash))
                return true; // X
        }
        return false;
    }

    boolean isTableFull() {
        for (int ord = 0; ord < 3; ord++) {
            for (int abs = 0; abs < 3; abs++) {
                if (table[ord][abs] == SIGN_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
