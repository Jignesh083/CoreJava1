package ConcurrancyProgram.ExecutorsConcurrencyEx;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureEx {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newSingleThreadExecutor();

        Runnable task = () -> {
            try {
                System.out.println("Waiting...");
                Thread.sleep(1000);
                System.out.println("Task Completed.");
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        };


//        ex.submit(task);

        Future<?> future = ex.submit(task);
        future.get(); //

//        System.out.println("Future Value: "+future.get());
        System.out.println("Task has Completed Successfully.");
    }
}
