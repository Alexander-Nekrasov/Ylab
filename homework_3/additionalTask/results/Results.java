package results;

import fields.TicTac;

import java.io.*;

public class Results {
    private BufferedWriter writerFile;
    private BufferedReader readerFile;
    public static int countHuman;
    public static int countBot;

    public Results() throws IOException {
        readerFile = new BufferedReader(new FileReader(getClass().getResource("/").getPath()
                .substring(1).replace("out/production/Ylab", "homework_3/additionalTask") + "results.txt"));
        writerFile = new BufferedWriter(new FileWriter(getClass().getResource("/").getPath()
                .substring(1).replace("out/production/Ylab", "homework_3/additionalTask") + "results.txt"));

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
