package aston.task2.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileRiderHandler implements FileOperationHandler {
    @Override
    public String executionProcess(Path filePath, String data) throws FileExecutorProcessException {
        try {
            return Files.readString(filePath);
        } catch (IOException e) {
            throw new FileExecutorProcessException("Error reading file: " + e.getMessage());
        }
    }
}
