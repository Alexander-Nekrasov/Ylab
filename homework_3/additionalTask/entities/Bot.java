package entities;

import fields.TicTac;
import xml.SaveToXML;

import java.util.Random;

public class Bot implements Entity {
    public static final int id = 2;
    private Random random = new Random();
    public final String name = "Al_Bot";
    public static int x, y;
    public static int i = 0;

    public Bot() {
        SaveToXML.player2.setAttribute("id", String.valueOf(id));
        SaveToXML.player2.setAttribute("name", name);
        SaveToXML.player2.setAttribute("symbol",String.valueOf(TicTac.SIGN_O));
    }

    @Override
    public void turn() {
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);

        } while (!isCellValid(x, y));
        TicTac.table[y][x] = TicTac.SIGN_O;
    }

    @Override
    public boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 3 || y >= 3) {
            return false;
        }
        return TicTac.table[y][x] == TicTac.SIGN_EMPTY;
    }
}
