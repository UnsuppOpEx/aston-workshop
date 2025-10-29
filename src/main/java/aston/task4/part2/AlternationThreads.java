package aston.task4.part2;

public class AlternationThreads {
    private static final Object object = new Object();
    private static boolean turnForThread1 = true;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (object) {
                    while (!turnForThread1) {
                        try {
                            object.wait();
                        } catch (InterruptedException ignored) {
                        }
                    }
                    System.out.print("1");
                    turnForThread1 = false;
                    object.notifyAll();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (object) {
                    while (turnForThread1) {
                        try {
                            object.wait();
                        } catch (InterruptedException ignored) {
                        }
                    }
                    System.out.print("2");
                    turnForThread1 = true;
                    object.notifyAll();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
