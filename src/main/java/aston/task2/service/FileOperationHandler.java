package aston.task2.service;

import java.nio.file.Path;

public interface FileOperationHandler {
    String executionProcess(Path filePath, String data) throws FileExecutorProcessException;
}
