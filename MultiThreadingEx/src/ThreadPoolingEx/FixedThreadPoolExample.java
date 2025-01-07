package ThreadPoolingEx;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Submit tasks to the thread pool
        for (int i=0;i<5;i++){
            executorService.submit(new Task());
        }

        // Shut down the executor after tasks are finished
        executorService.shutdown();
    }
}


class Task implements Runnable{
    public void run(){
        try{
            Thread.sleep(1000);
            System.out.println("Task executed by: " + Thread.currentThread().getName());
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
