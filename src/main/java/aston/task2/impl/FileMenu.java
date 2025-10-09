package aston.task2.impl;

import aston.task2.service.FileExecutorProcess;
import aston.task2.service.FileExecutorProcessException;
import aston.task2.service.FileOperationType;

import java.util.Scanner;

public class FileMenu {
    private final FileExecutorProcess processor = new FileExecutorProcess();
    Scanner scanner = new Scanner(System.in);

    public void doAction() {
        while (true) {
            showMenu();
            String choiceMenu = scanner.nextLine();
            Integer menuNumber = Integer.parseInt(choiceMenu.split("\\.")[0]);
            validationAction(menuNumber);
            switch (menuNumber) {
                case 1:
                    handlerWrite();
                    System.out.println("Select the following menu to read from a file :)");
                    break;
                case 2:
                    handlerRead();
                    break;
                case 3:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choiceMenu. Try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\nChoose operation:");
        System.out.println("1. Write to file");
        System.out.println("2. Read from file");
        System.out.println("3. Exit");
        System.out.print("Your choice: ");
    }

    private void validationAction(Integer number) {
        if (number < 0 || number >= 4) {
            System.err.println("Menu not found!!!");
            scanner.close();
        }
    }

    private void handlerWrite() {
        System.out.print("Enter text to write: ");
        String text = scanner.nextLine();
        try {
            processor.executeProcess(FileOperationType.WRITE, text);
            System.out.println("Successfully written to file!");
        } catch (FileExecutorProcessException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private void handlerRead() {
        try {
            String content = processor.executeProcess(FileOperationType.READ, null);
            System.out.println("File content: " + content);
        } catch (FileExecutorProcessException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}
