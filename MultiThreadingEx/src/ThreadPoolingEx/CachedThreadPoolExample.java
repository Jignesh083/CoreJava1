package ThreadPoolingEx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {
    public static void main(String[] args) {
        // Create a cached thread pool
        ExecutorService executorService = Executors.newCachedThreadPool();

        // Submit tasks to the thread pool
        for (int i=0;i<5;i++){
            executorService.submit(new Task1());
        }
        executorService.shutdown();
    }
}



class Task1 implements Runnable{
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
