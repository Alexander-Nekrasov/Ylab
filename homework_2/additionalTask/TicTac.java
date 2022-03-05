import java.util.Random;
import java.util.Scanner;

public class TicTac {
    final char SIGN_X = 'X';
    final char SIGN_O = 'O';
    final char SIGN_EMPTY = '-';

    char[][] table;
    Random random;
    Scanner scanner;

    public static void main(String[] args) {

    }

    TicTac() {
        random = new Random();
        scanner = new Scanner(System.in);
        table = new char[3][3];
    }

    /*
    // Инициализируем таблицу
    (Цикл)
     ход человека
     проверка: если победа человека или ничья:
        сообщить и выйти из цикла
     ход компьютера
     проверка: если победа компьютера или ничья:
        сообщить и выйти из цикла
     */
    void game() {
        initTable();
        while (true) {
            turnHuman();

            turnBot();
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
            for (int abs = 0; abs < 3; abs++) {
                System.out.print(table[ord][abs] + " ");
            }
            System.out.println();
        }
    }

    void turnHuman() {
        int x, y;

        do {
            System.out.println("Введите два значения по Х и Y от 1..3");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        table[y][x] = SIGN_X;
    }

    void turnBot(){
        int x, y;

        do{
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x,y));
        table[y][x] = SIGN_O;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 3 || y >= 3) {
            return false;
        }
        return table[y][x] == SIGN_EMPTY;
    }

}
