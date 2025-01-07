package ThreadSchedularEx;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    System.out.println("Thread 1 is running");
                    try{
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });




        // Thread 2 - Low Priority
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    System.out.println("Thread 2 is running");
                    try{
                        Thread.sleep(3000);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });


        // Set priorities
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread1.setPriority(Thread.MIN_PRIORITY);


        thread1.start();
        thread2.start();


        thread1.join();
        thread2.join();


        thread1.yield();
        thread2.yield();


        System.out.println("Both threads have finished execution");

    }
}
