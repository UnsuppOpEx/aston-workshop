package aston.task2.impl;

import aston.task2.service.FileExecutorProcess;
import aston.task2.service.FileExecutorProcessException;
import aston.task2.service.FileOperationType;

import java.util.Scanner;

public class UserWriteHandler implements UserChoiceHandler {
    private final FileExecutorProcess fileExecutorProcess;

    public UserWriteHandler(FileExecutorProcess fileExecutorProcess) {
        this.fileExecutorProcess = fileExecutorProcess;
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.print("Enter text to write: ");
        String text = scanner.nextLine();
        try {
            fileExecutorProcess.executeProcess(FileOperationType.WRITE, text);
            System.out.println("Successfully written to file!");
        } catch (FileExecutorProcessException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
