package aston.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class FileExecutorProcessTest {
    private FileWriteHandler writeHandler;
    private FileRiderHandler readHandler;


    @BeforeEach
    void init() throws IOException {
        writeHandler = new FileWriteHandler();
        readHandler = new FileRiderHandler();
        Path tempFile = Files.createTempFile("test", ".txt");
    }

    @Test
    void writeExecuteProcess() throws IOException {

    }
}
