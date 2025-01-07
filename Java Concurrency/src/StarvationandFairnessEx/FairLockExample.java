package StarvationandFairnessEx;

import java.util.concurrent.locks.ReentrantLock;

public class FairLockExample {
        private final ReentrantLock lock = new ReentrantLock(true); // 'true' enforces fairness

        public void criticalSection() {
            lock.lock();
            try {
                // Perform critical section tasks
                System.out.println(Thread.currentThread().getName() + " is working in the critical section.");
            } finally {
                lock.unlock();
            }
        }

        public static void main(String[] args) {
            FairLockExample example = new FairLockExample();
            Runnable task = () -> {
                for (int i = 0; i < 5; i++) {
                    example.criticalSection();
                    try {
                        Thread.sleep(100); // Simulate work
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            };

            Thread thread1 = new Thread(task);
            Thread thread2 = new Thread(task);
            thread1.start();
            thread2.start();
        }
}
