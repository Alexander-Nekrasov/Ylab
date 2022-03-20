package files;

import java.nio.file.Paths;

public class PathFiles {
    private String nameFile;

    public PathFiles(String nameFile) {
        this.nameFile = nameFile;
    }

    public String absolutePath(){
        return Paths.get(PathFiles.class.getResource("/").getPath()
                .substring(1).replace("target/classes", "homework_2/additionalTask/files")) +"\\"+ nameFile;
    }
}
