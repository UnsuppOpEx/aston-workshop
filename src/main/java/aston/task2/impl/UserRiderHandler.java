package aston.task2.impl;

import aston.task2.service.FileExecutorProcess;
import aston.task2.service.FileExecutorProcessException;
import aston.task2.service.FileOperationType;

import java.util.Scanner;

public class UserRiderHandler implements UserChoiceHandler {
    private final FileExecutorProcess fileExecutorProcess;

    public UserRiderHandler(FileExecutorProcess fileExecutorProcess) {
        this.fileExecutorProcess = fileExecutorProcess;
    }

    @Override
    public void execute(Scanner scanner) {
        try {
            String content = fileExecutorProcess.executeProcess(FileOperationType.READ, null);
            System.out.println("File content: " + content);
        } catch (FileExecutorProcessException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}
