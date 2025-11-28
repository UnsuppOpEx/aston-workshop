package aston.task4.part1.deadlock;

public class DeadLock {
    private static final Object object1 = new Object();
    private static final Object object2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (object1) {
                System.out.println("Поток 1 захватил object1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
                synchronized (object2) {
                    System.out.println("Поток 1 захватил object2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (object2) {
                System.out.println("Поток 2 захватил object2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
                synchronized (object1) {
                    System.out.println("Поток 2 захватил object1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
