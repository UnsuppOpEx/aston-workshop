package aston.task2.impl;

public enum UserChoice {
    WRITE(1), READ(2), EXIT(3);

    private final int number;

    UserChoice(int number) {
        this.number = number;
    }

    public static UserChoice getChoice(int number) {
        for (UserChoice choice : values()) {
            if (choice.number == number) {
                return choice;
            }
        }
        throw new IllegalArgumentException("Invalid choice number: " + number);
    }
}



