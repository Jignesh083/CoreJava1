package ThreadPriorityEx;

public class Demo {
    public static void main(String[] args) {

        // Creating a thread with the lowest priority (MIN_PRIORITY)
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " with priority " + Thread.currentThread().getPriority());
                    try {
                        Thread.sleep(500); // Sleep for 0.5 second
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // Creating a thread with normal priority (NORM_PRIORITY)
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " with priority " + Thread.currentThread().getPriority());
                    try {
                        Thread.sleep(500); // Sleep for 0.5 second
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // Creating a thread with the highest priority (MAX_PRIORITY)
        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " with priority " + Thread.currentThread().getPriority());
                    try {
                        Thread.sleep(500); // Sleep for 0.5 second
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // Setting thread priorities
        thread1.setPriority(Thread.MIN_PRIORITY);  // Set to lowest priority
        thread2.setPriority(Thread.NORM_PRIORITY); // Set to default priority
        thread3.setPriority(Thread.MAX_PRIORITY);  // Set to highest priority

        // Starting threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
