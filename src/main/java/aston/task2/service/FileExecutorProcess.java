package aston.task2.service;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class FileExecutorProcess {
    private final Map<FileOperationType, FileOperationHandler> typeToHandlerMap = new HashMap<>();

    public FileExecutorProcess() {
        typeToHandlerMap.put(FileOperationType.READ, new FileRiderHandler());
        typeToHandlerMap.put(FileOperationType.WRITE, new FileWriteHandler());
    }

    public String executeProcess(FileOperationType fileOperationType, String text) throws FileExecutorProcessException {
        Path filePath = getFilePath();
        FileOperationHandler handler = typeToHandlerMap.get(fileOperationType);
        return handler.executionProcess(filePath, text);
    }

    private Path getFilePath() throws FileExecutorProcessException {
        String filePath = System.getenv("FILE_PATH");
        if (filePath == null || filePath.isEmpty()) {
            throw new FileExecutorProcessException("Environment variable FILE_PATH is required");
        }
        return Path.of(filePath);
    }
}
