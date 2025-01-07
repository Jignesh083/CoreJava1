package ForkJoinPoolEx;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SimpleForkJoinExample {

    // Task to sum up the elements of a subarray
    static class sumTask extends RecursiveTask<Integer> {
        private final int[] arr;
        private final int start;
        private final int end;


        // Constructor for the task
        public sumTask(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }


        @Override
        protected Integer compute() {
            // If the subarray is small, just sum it directly
            if (end - start <= 10) { // If the range is 10 or fewer elements
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += arr[i];
                }
                return sum;
            } else {
                // Otherwise, split the task into two smaller tasks
                int mid = (start + end) / 2;
                sumTask leftTask = new sumTask(arr, start, mid);
                sumTask rightTask = new sumTask(arr, mid, end);

                // Fork both subtasks
                leftTask.fork();
                rightTask.fork();

                // Wait for both tasks to finish and join their results
                int leftResult = leftTask.join();
                int rightResult = rightTask.join();

                // Combine the results of both tasks
                return leftResult + rightResult;
            }
        }
    }


    public static void main(String[] args) {
        int arr[] = new int[100];
        for (int i=0;i<100;i++){
            arr[i] = i+1; // Fill the array with values from 1 to 100
        }

        // Create a ForkJoinPool to manage parallel tasks
        ForkJoinPool pool = new ForkJoinPool(); //Divide Task using Fork Method


        // Create the main task to sum the entire array
        sumTask task = new sumTask(arr,0,arr.length);

        // Submit the task to the pool and get the result
        int result = pool.invoke(task);
        System.out.println("The sum of the array is: " + result);

        // Shutdown the pool after use
        pool.shutdown();
    }

}