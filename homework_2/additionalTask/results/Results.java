package results;

import fields.TicTac;
import files.PathFiles;

import java.io.*;

public class Results {
    private BufferedWriter writerFile;
    private BufferedReader readerFile;
    public static int countHuman;
    public static int countBot;

    public Results() throws IOException {
        readerFile = new BufferedReader(new FileReader(new PathFiles("results.txt").absolutePath()));
        writerFile = new BufferedWriter(new FileWriter(new PathFiles("results.txt").absolutePath()));

        if (readerFile.ready()) writerFile.write("\n");
        writerFile.write(textResults());
        writerFile.close();
    }

    private static String textResults() {
        String human = "Результат человека: ";
        String bot = "Результат бота: ";
        String countGames = "Вы сыграли: "+ TicTac.countGames;

        return String.format(human + "%d" + "\n" + bot + "%d" + "\n" + countGames, countHuman, countBot);
    }

}
