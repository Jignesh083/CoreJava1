package ConcurrancyProgram.ForkAndJoinConcurrentEx;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class RecursiveActionEx {
    // Define the size of the array and the threshold for dividing tasks
        static final int THRESHOLD = 10;  // If the array part is smaller than this, just sum it directly
        static final int SIZE = 100;  // Size of the array to sum

        public static void main(String[] args) {
            // Create an array of SIZE elements and initialize it with random values
            int[] array = new int[SIZE];
            for (int i = 0; i < SIZE; i++) {
                array[i] = i + 1;  // Filling array with numbers 1 to SIZE
            }

            // Create a ForkJoinPool to manage the recursive tasks
            ForkJoinPool pool = new ForkJoinPool();

            // Create the main recursive task and execute it
            SumTask task = new SumTask(array, 0, SIZE);
            pool.invoke(task); //invoke means execute

            // Print the sum after completion
            System.out.println("Sum of array: " + task.getSum());
        }

        // RecursiveAction that sums a part of the array
        static class SumTask extends RecursiveAction {
            int[] array;
            int start, end;
            int sum;

            // Constructor to initialize task with array and range to process
            SumTask(int[] array, int start, int end) {
                this.array = array;
                this.start = start;
                this.end = end;
                this.sum = 0;
            }

            // Method that does the actual work: divide and conquer
            @Override
            protected void compute() {
                if (end - start <= THRESHOLD) {
                    // Base case: if the range is small enough, sum the elements directly
                    for (int i = start; i < end; i++) {
                        sum += array[i];
                    }
                } else {
                    // Recursive case: divide the task into two subtasks
                    int middle = (start + end) / 2;

                    // Create two subtasks to handle each half of the range
                    SumTask leftTask = new SumTask(array, start, middle);
                    SumTask rightTask = new SumTask(array, middle, end);

                    // Fork the left and right tasks to be executed concurrently
                    leftTask.fork();
                    rightTask.fork();

                    // Wait for the subtasks to finish and combine their results
                    leftTask.join();
                    rightTask.join();

                    // Combine the results (in this case, just adding the sums)
                    sum = leftTask.sum + rightTask.sum;
                }
            }

            // Getter for the result (sum)
            public int getSum() {
                return sum;
            }
        }
    }
