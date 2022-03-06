import java.util.Random;
import java.util.Scanner;

public class TicTac {
    final char SIGN_X = 'X';
    final char SIGN_O = 'O';
    final char SIGN_EMPTY = '-';

    char[][] table;
    Random random;
    Scanner scanner;

    TicTac() {
        random = new Random();
        scanner = new Scanner(System.in);
        table = new char[][]{
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };
    }

    void game() {
        initTable();
        printTable();
        while (true) {
            turnHuman();
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

            turnBot();
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

    void turnHuman() {
        Human human = new Human();
        Human.readName();

        do {
            System.out.println(human.getName() + ": введите два значения по Х и Y от 1..3");
            human.x = scanner.nextInt() - 1;
            human.y = scanner.nextInt() - 1;
        } while (!isCellValid(human.x, human.y));
        table[human.y][human.x] = SIGN_X;
    }

    void turnBot() {
        int x, y;

        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x, y));
        table[y][x] = SIGN_O;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 3 || y >= 3) {
            return false;
        }
        return table[y][x] == SIGN_EMPTY;
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
