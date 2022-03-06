package entities;

import fields.TicTac;

import java.util.Random;

public class Bot implements Entity {
    private Random random = new Random();
    public int x, y;

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
