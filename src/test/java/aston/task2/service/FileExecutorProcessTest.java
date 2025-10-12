package aston.task2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class FileExecutorProcessTest {
    private FileWriteHandler writeHandler;
    private FileRiderHandler readHandler;


    @BeforeEach
    void init() {
        writeHandler = new FileWriteHandler();
        readHandler = new FileRiderHandler();
    }

    @Test
    void whenWriteExecuteProcess_thenTempFileContainsText() throws IOException {
        Path tempFile = Files.createTempFile("test", ".txt");
        String expectedText = "Hello World!";

        writeHandler.executionProcess(tempFile, expectedText);
        String actualResult = Files.readString(tempFile);

        Assertions.assertEquals(expectedText, actualResult);

        Files.deleteIfExists(tempFile);
    }

    @Test
    void whenReadExecuteProcess_thenResultContainsText() throws IOException {
        String expectedText = "Hello World!";
        Path tempFile = Files.createTempFile("test", ".txt");
        Files.writeString(tempFile, expectedText);

        String actualResult = readHandler.executionProcess(tempFile, null);

        Assertions.assertEquals(expectedText, actualResult);

        Files.deleteIfExists(tempFile);
    }

    @Test
    void whenReadExecuteProcessWithInvalidPath_thenThrowException() {
        Path invalidFilePath = Path.of("/root/text.txt");

        FileExecutorProcessException exception = Assertions.assertThrows(FileExecutorProcessException.class,
                () -> readHandler.executionProcess(invalidFilePath, null));

        Assertions.assertTrue(exception.getMessage().contains("Error reading file: " + invalidFilePath));
    }
}
