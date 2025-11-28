package aston.task4.deadlock;

import aston.task4.part1.deadlock.DeadLock;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class DeadLockTest {

    @Test
    void whenTheadOneLockedAndTheadTwoLocked_thenThreadsEnterDeadLock() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            DeadLock.main(null);
            Thread.sleep(2000);
        });
    }
}
