package aston.task4.part1.livelock;

public class Main {
    public static void main(String[] args) {
        LiveLock.Worker worker1 = new LiveLock.Worker(true);
        LiveLock.Worker worker2 = new LiveLock.Worker(true);

        Thread thread1 = new Thread(() -> worker1.work(worker2), "Рабочий 1");
        Thread thread2 = new Thread(() -> worker2.work(worker1), "Рабочий 2");

        thread1.start();
        thread2.start();
    }
}
