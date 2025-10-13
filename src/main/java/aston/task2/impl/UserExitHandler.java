package aston.task2.impl;

import aston.task2.service.FileExecutorProcess;

import java.util.Scanner;

public class UserExitHandler implements UserChoiceHandler {
    private final FileExecutorProcess fileExecutorProcess;

    UserExitHandler(FileExecutorProcess fileExecutorProcess) {
        this.fileExecutorProcess = new FileExecutorProcess();
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Exiting program...");
        scanner.close();
        System.exit(0);

    }
}
