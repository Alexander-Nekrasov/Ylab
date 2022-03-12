import fields.TicTac;
import results.Results;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TicTac ticTac = new TicTac();
        ticTac.game();
        new Results();
    }
}
