package StarvationandFairnessEx;

public class ThreadPriorityExample {
        public static void main(String[] args) {
            Runnable task = () -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " is executing.");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            };

            Thread thread1 = new Thread(task);
            Thread thread2 = new Thread(task);
            thread1.setPriority(Thread.MIN_PRIORITY); // Low priority
            thread2.setPriority(Thread.MAX_PRIORITY); // High priority

            thread1.start();
            thread2.start();
        }
    }

