import java.io.*;

public class Results {
    private BufferedWriter writerFile;
    private BufferedReader readerFile;
    static int countHuman;
    static int countBot;

    Results() throws IOException {
        readerFile = new BufferedReader(new FileReader(getClass().getResource("/").getPath()
                .substring(1).replace("out/production/Ylab","homework_2/additionalTask")+"results.txt"));
        writerFile = new BufferedWriter(new FileWriter(getClass().getResource("/").getPath()
                .substring(1).replace("out/production/Ylab","homework_2/additionalTask")+"results.txt", true));

        if (readerFile.ready()) writerFile.write("\n");
        writerFile.write(textResults());
        writerFile.close();
    }

    private static String textResults() {
        String human = "Результат человека: ";
        String bot = "Результат бота: ";

        return String.format(human + "%d" + "\n" + bot + "%d", countHuman, countBot);
    }

}
