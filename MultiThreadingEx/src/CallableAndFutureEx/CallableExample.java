package CallableAndFutureEx;

import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {
        // Create a callable task that computes the sum of numbers from 1 to 10
        Callable<Integer> collableTask = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
             int sum = 0;
                for (int i = 0; i <= 10; i++) {
                    sum += i;
                    Thread.sleep(1000);
                }
                return sum;
            }
        };

        // Create a thread pool to execute the task
        ExecutorService service = Executors.newSingleThreadExecutor();

        // Submit the callable task to the executor and get a Future object
        Future<Integer> future = service.submit(collableTask);

        try{
            // Get the result of the computation (this will block until the task completes)
            Integer result = future.get();
            System.out.println("Sum of numbers from 1 to 10 is: " + result);
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }finally {
            // Shut down the executor
            service.shutdown();
        }
    }
}
