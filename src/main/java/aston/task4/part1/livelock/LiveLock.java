package aston.task4.part1.livelock;

public class LiveLock {
    static class Worker {
        private volatile boolean active;

        public Worker(boolean active) {
            this.active = active;
        }

        public boolean isActive() {
            return active;
        }

        public void work(Worker partner) {
            while (active) {
                if (partner.isActive()) {
                    System.out.println(Thread.currentThread().getName() + ": уступаю партнёру");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {}
                    continue;
                }

                System.out.println(Thread.currentThread().getName() + ": начинаю работу");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
                active = false;
                System.out.println(Thread.currentThread().getName() + ": закончил работу");
            }
        }
    }
}
