import java.util.Scanner;

public class Human implements Entity {
    private String name;
    private Scanner scanner = new Scanner(System.in);
    public int x, y;

    public void readName() {
        if (name == null) {
            System.out.println("Введите имя игрока:");
            name = scanner.nextLine();
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
}
