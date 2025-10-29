package aston.task4.livelock;

import aston.task4.part1.livelock.LiveLock;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class LiveLockTest {

    @Test
    void whenBothWorkersBusy_thenThreadsEnterLiveLock() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            LiveLock.Worker worker1 = new LiveLock.Worker(true);
            LiveLock.Worker worker2 = new LiveLock.Worker(true);

            Thread thread1 = new Thread(() -> worker1.work(worker2), "Рабочий 1");
            Thread thread2 = new Thread(() -> worker2.work(worker1), "Рабочий 2");

            thread1.start();
            thread2.start();

            Thread.sleep(2000);

            boolean t1Alive = thread1.isAlive();
            boolean t2Alive = thread2.isAlive();

            thread1.interrupt();
            thread2.interrupt();

            assertTrue(t1Alive || t2Alive);
        });
    }
}
