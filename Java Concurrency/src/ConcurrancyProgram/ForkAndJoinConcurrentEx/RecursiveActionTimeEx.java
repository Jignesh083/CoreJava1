package ConcurrancyProgram.ForkAndJoinConcurrentEx;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class RecursiveActionTimeEx {
        public static void main(String[] args) {
            // Default values for level of parallelism and threshold
            int plevel = 4;  // Number of threads in ForkJoinPool
            int thresholder = 1000;  // Threshold for dividing tasks

            // Initialize ForkJoinPool
            ForkJoinPool pool = new ForkJoinPool(plevel);

            // Create an array of numbers to process (e.g., 0 to 99999)
            double[] nums = new double[100000];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = i;
            }

            // Create the task to process the array
            SqrTransform task = new SqrTransform(nums, 0, nums.length, thresholder);

            // Measure start time
            long startTime = System.currentTimeMillis();

            // Invoke the ForkJoinPool to process the task
            pool.invoke(task);

            // Measure end time
            long endTime = System.currentTimeMillis();

            // Output the results
            System.out.println("Parallelism Level: " + plevel);
            System.out.println("Threshold: " + thresholder);
            System.out.println("Elapsed Time: " + (endTime - startTime) + " ms");
        }
    }

    class SqrTransform extends RecursiveAction {
        private final double[] data;
        private final int start, end;
        private final int squThreshold;

        // Constructor to initialize task parameters
        SqrTransform(double[] data, int start, int end, int squThreshold) {
            this.data = data;
            this.start = start;
            this.end = end;
            this.squThreshold = squThreshold;
        }

        @Override
        protected void compute() {
            // If the task size is small enough, perform the computation
            if (end - start < squThreshold) {
                for (int i = start; i < end; i++) {
                    if (data[i] % 2 == 0) {
                        // Apply square root to even numbers
                        data[i] = Math.sqrt(data[i]);
                    } else {
                        // Apply cube root to odd numbers
                        data[i] = Math.cbrt(data[i]);
                    }
                }
            } else {
                // Split the task into two sub-tasks and process in parallel
                int middle = (start + end) / 2;
                invokeAll(new SqrTransform(data, start, middle, squThreshold),
                        new SqrTransform(data, middle, end, squThreshold));
            }
        }

    }