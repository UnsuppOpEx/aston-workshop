package aston.task2;

import java.io.IOException;

public class FileExecutorProcessException extends IOException {
    public FileExecutorProcessException(String message) {
        super(message);
    }

    public FileExecutorProcessException(String message, Throwable cause) {
        super(message, cause);
    }
}
