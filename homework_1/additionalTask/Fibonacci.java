import java.util.ArrayList;

public class Fibonacci {
    private int value;
    public ArrayList<Integer> listFibonacci = new ArrayList<>();

    public int getFibonacci(){
        if (value <= 1) return value;
        else if (value == 2) return value - 1;
        else return getFibRecursion(value - 1) + getFibRecursion(value - 2);
    }

    public void printFibValues() {
        int j = 0;

        for (int i = 0; i < value; i++) {
            if (i < 2) listFibonacci.add(i, j++);
            else listFibonacci.add(i, listFibonacci.get(i - 1) + listFibonacci.get(i - 2));
        }

        for (int val : listFibonacci) {
            System.out.print(val + " ");
        }

        System.out.println();
    }

    public int getFibRecursion(int value) {
        if (value <= 1) return value;
        else if (value == 2) return value - 1;
        else return getFibRecursion(value - 1) + getFibRecursion(value - 2);
    }

    public int getFibCycle(int value) {
        int first = 0;
        int second = 1;
        int three;

        for (int i = 3; i <= value; i++) {
            three = first + second;
            first = second;
            second = three;
        }

        return second;
    }

    public void printFibRecursionValues(int value) {
        ArrayList<Integer> valuesFibonacci = new ArrayList<>();
        int j = 0;

        for (int i = 0; i < value; i++) {
            if (i < 2) valuesFibonacci.add(i, j++);
            else valuesFibonacci.add(i, valuesFibonacci.get(i - 1) + valuesFibonacci.get(i - 2));
        }

        for (int val : valuesFibonacci) {
            System.out.print(val + " ");
        }

        System.out.println();
    }

    public void printFibCycleValues(int value) {
        int first = 0;
        int second = 1;
        int three;

        System.out.print(first + " " + second + " ");

        for (int i = 3; i <= value; i++) {
            three = first + second;

            System.out.print(three + " ");

            first = second;
            second = three;
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
