package entities;

public interface Entity {
    void turn();
    boolean isCellValid(int x, int y);
}
