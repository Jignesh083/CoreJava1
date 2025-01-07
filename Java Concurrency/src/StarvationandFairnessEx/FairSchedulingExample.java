package StarvationandFairnessEx;

public class FairSchedulingExample {
        public static void main(String[] args) {
            Runnable task = () -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " is executing.");
                    try {
                        Thread.sleep(10); // Give other threads a chance to execute
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
