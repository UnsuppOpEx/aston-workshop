package aston.task2;

import java.nio.file.Path;

public interface FileOperationHandler {
    String executionProcess(Path filePath, String data) throws FileExecutorProcessException;
}
