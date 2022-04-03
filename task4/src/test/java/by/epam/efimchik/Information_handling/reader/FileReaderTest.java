package by.epam.efimchik.Information_handling.reader;

import by.epam.efimchik.Information_handling.exception.CompositeException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {
    private FileReader fileReader;

    @BeforeEach
    void setUp() {
        fileReader = new FileReader();
    }

    @Test
    void readFile() throws CompositeException {
        String actualString = fileReader.readFile("src\\main\\resources\\file\\test.txt");
        String expectedString = "   String to test the data provider  .";
        assertEquals(expectedString, actualString);
    }

    @Test()
    public void testReadIOException() throws CompositeException, IOException {
        Path tmpDir = Files.createTempDirectory("tmp");
        tmpDir.toFile().delete();
        try{
            Path tmpFile = Files.createTempFile(tmpDir, "test", ".txt");
            Assert.fail("Expected IOException");
        } catch (IOException thrown) {
            assertNotEquals("", thrown.getMessage());
        }
    }
}