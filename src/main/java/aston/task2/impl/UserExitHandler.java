package aston.task2.impl;

import java.util.Scanner;

public class UserExitHandler implements UserChoiceHandler {
    @Override
    public void execute(Scanner scanner) {
        System.out.println("Exiting program...");
        scanner.close();
        System.exit(0);

    }
}
