import java.util.Scanner;

public class Human {
    private static String name;
    private static Scanner scanner = new Scanner(System.in);
    public int x, y;

    public static void readName() {
        if (name == null) {
            System.out.println("Введите имя игрока:");
            name = scanner.nextLine();
        } else return;
    }



    public String getName() {
        return name;
    }
}
