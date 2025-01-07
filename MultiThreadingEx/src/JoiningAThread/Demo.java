package JoiningAThread;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        // Create a new thread (Thread 1)
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 5; i++) {
                        System.out.println("Thread 1: " + i);
                        Thread.sleep(2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        // Create another thread (Thread 2)
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for (int i=1;i<=5;i++){
                        System.out.println("Thread 2: " + i);
                        Thread.sleep(2000);
                    }
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });


        thread1.start();
        thread2.start();



        // Calling join on thread1 and thread2
        thread1.join();  // Main thread waits for thread1 to finish
        thread2.join();  // Main thread waits for thread2 to finish

        // After both threads have finished, the main thread continues
        System.out.println("Both threads have finished execution.");
    }
}
