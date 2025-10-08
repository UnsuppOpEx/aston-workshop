package aston.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriteHandler implements FileOperationHandler {
    @Override
    public String executionProcess(Path filePath, String data) throws FileExecutorProcessException {
        try {
            Files.writeString(filePath, data);
            return null;
        } catch (IOException e) {
            throw new FileExecutorProcessException("Could not write to file: " + filePath, e);
        }
    }
}
