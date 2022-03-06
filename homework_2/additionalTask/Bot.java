import java.util.Random;

public class Bot {
    private Random random = new Random();
    public int x, y;

    void turnBot() {
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x, y));
        TicTac.table[y][x] =TicTac.SIGN_O;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 3 || y >= 3) {
            return false;
        }
        return TicTac.table[y][x] == TicTac.SIGN_EMPTY;
    }
}
