package entities;

import java.util.Scanner;

import fields.TicTac;
import results.SaveToXML;

public class Human implements Entity {
    public static final int id = 1;
    private String name;
    private Scanner scanner = new Scanner(System.in);
    public static int x, y;
    public static int i = 0;

    public Human() {
        SaveToXML.player1.setAttribute("id", String.valueOf(id));
        SaveToXML.player1.setAttribute("symbol", String.valueOf(TicTac.SIGN_X));

    }

    public void readName() {
        if (name == null) {
            System.out.println("Введите имя игрока:");
            setName(scanner.nextLine());
            SaveToXML.player1.setAttribute("name", getName());
        } else return;
    }

    public String getName() {
        return name;
    }

    @Override
    public void turn() {
        readName();
        do {

            System.out.println(getName() + ": введите два значения по Х и Y от 1..3");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;

        } while (!isCellValid(x, y));
        TicTac.table[y][x] = TicTac.SIGN_X;
    }

    @Override
    public boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 3 || y >= 3) {
            return false;
        }
        return TicTac.table[y][x] == TicTac.SIGN_EMPTY;
    }

    public void setName(String name) { //
        this.name = name;
    }
}
