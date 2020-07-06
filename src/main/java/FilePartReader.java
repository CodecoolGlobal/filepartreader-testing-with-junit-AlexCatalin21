import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FilePartReader {
    private String filePath;
    private int fromLine;
    private int toLine;


    public FilePartReader() {
        this.filePath = "filePath";
        this.fromLine = 0;
        this.toLine = -1;
    }

    public void setup (String filePath, int fromLine, int toLine){
        if (toLine < fromLine || fromLine < 1 ) throw new IllegalArgumentException();
        else {
            this.filePath = filePath;
            this.fromLine = fromLine;
            this.toLine = toLine;
        }
    }

    public String getFilePath() {
        return filePath;
    }

    public int getFromLine() {
        return fromLine;
    }

    public int getToLine() {
        return toLine;
    }

    public String read()
            throws IOException {

        return Files.readString(Path.of(filePath));
    }

    public String readLines() throws IOException {
        try {
            String fileText = read();
            List<String> lineOfText = Arrays.asList(fileText.split("\\n"));

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < lineOfText.size(); i++) {
                if ((i >= fromLine - 1) && (i <= toLine - 1)) {
                    result.append(lineOfText.get(i)).append(" ");
                }
            }
            return result.toString();

        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }
}
