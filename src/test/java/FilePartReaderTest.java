import org.junit.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class FilePartReaderTest {
    FilePartReader  fileReader = new FilePartReader();


    @Test
    void setup() {
        assertThrows(IllegalArgumentException.class, () -> fileReader.setup("src/testfile/testfile.txt", 1, 0) );
    }


    @Test
    void getFilePath() throws IOException {
        assertEquals("filePath", fileReader.getFilePath());

    }

    @Test
    void getFromLine() {
        assertEquals(0, fileReader.getFromLine());

    }

    @Test
    void getToLine() {
        assertEquals(-1, fileReader.getToLine());
    }

    @Test
    void read() throws IOException {
        fileReader.setup("src/testfile/testfile.txt",1,1);
        String expectedR = "line 1 ";
        assertEquals(expectedR, fileReader.readLines());
    }

    @Test
    void readLines() throws IOException {
        fileReader.setup("src/testfile/testfile.txt",1,4);
        String expected = "line 1 line 2 line 3 line 4 ";
        assertEquals(expected, fileReader.readLines());
    }
}
