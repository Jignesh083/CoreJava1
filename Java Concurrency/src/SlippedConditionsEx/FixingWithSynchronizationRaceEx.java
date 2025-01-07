package SlippedConditionsEx;

public class FixingWithSynchronizationRaceEx {
        private int counter = 0;

        public synchronized void increment() {
            counter++;  // This is now atomic
        }

        public int getCounter() {
            return counter;
        }

        public static void main(String[] args) throws InterruptedException {
            RaceConditionExample example = new RaceConditionExample();

            // Create multiple threads that will increment the counter
            Thread t1 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    example.increment();
                }
            });

            Thread t2 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    example.increment();
                }
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();

            // Now, the result will consistently be 2000
            System.out.println("Counter: " + example.getCounter());
        }
    }

