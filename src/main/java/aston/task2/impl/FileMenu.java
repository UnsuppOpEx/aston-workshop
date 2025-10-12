package aston.task2.impl;

import aston.task2.service.FileExecutorProcess;

import java.util.Map;
import java.util.Scanner;

public class FileMenu {
    private final Map<UserChoice, UserChoiceHandler> choiceHandlerMap;
    Scanner scanner = new Scanner(System.in);

    public FileMenu() {
        FileExecutorProcess processor = new FileExecutorProcess();
        choiceHandlerMap = Map.of(
                UserChoice.WRITE, new UserWriteHandler(processor),
                UserChoice.READ, new UserWriteHandler(processor),
                UserChoice.EXIT, new UserWriteHandler(processor));
    }

    public void doAction() {
        while (true) {
            showMenu();
            try {
                String choiceMenu = scanner.nextLine();
                int menuNumber = Integer.parseInt(choiceMenu.split("\\.")[0]);
                UserChoice choice = UserChoice.getChoice(menuNumber);
                choiceHandlerMap.get(choice).execute(scanner);
                validationAction(menuNumber);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
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
}
