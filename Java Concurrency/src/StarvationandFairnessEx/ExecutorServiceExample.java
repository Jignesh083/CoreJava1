package StarvationandFairnessEx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
        public static void main(String[] args) {
            ExecutorService executor = Executors.newFixedThreadPool(2);

            Runnable task = () -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " is executing.");
                    try {
                        Thread.sleep(100); // Simulate work
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            };

            executor.submit(task);
            executor.submit(task);

            executor.shutdown();
        }
    }
