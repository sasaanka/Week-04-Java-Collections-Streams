import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class FileHandling {
	public void writetoFile(String filename,String content) throws IOException  {
		Path path = Paths.get(filename);
        Files.writeString(path, content);
	}
	public String readFromFile(String filename) throws IOException {
        Path path = Paths.get(filename);
        return Files.readString(path);
    }
}
public class TestingFileHandling {

    private FileHandling processor;

    @BeforeEach
    public void setUp() {
        processor = new FileHandling();
    }

    @TempDir
    Path tempDir;  // Temporary directory created for each test

    @Test
    public void testWriteAndReadFile() throws IOException {
        Path filePath = tempDir.resolve("test.txt");
        String content = "JUnit File Test";

        processor.writetoFile(filePath.toString(), content);
        String readContent = processor.readFromFile(filePath.toString());

        assertEquals(content, readContent, "Content should match after reading the file.");
    }

    @Test
    public void testFileExistsAfterWrite() throws IOException {
        Path filePath = tempDir.resolve("checkfile.txt");
        processor.writetoFile(filePath.toString(), "some content");

        assertTrue(Files.exists(filePath), "File should exist after write.");
    }

    @Test
    public void testReadFromNonExistentFileThrowsException() {
        Path filePath = tempDir.resolve("missing.txt");

        assertThrows(IOException.class, () -> {
            processor.readFromFile(filePath.toString());
        }, "Should throw IOException for non-existent file.");
    }
}
