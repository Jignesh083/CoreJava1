package MultitaskByMultithreadsEx;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        // Task 1: Sum of numbers
        Thread sumTask = new Thread(()->{
            int sum = 0;
            for(int i=0;i<=100;i++){
                sum+=i;
            }
            System.out.println("Sum of numbers from 1 to 100: " + sum);
        });

        // Task 2: Factorial Calculation
        Thread factorialTask = new Thread(()->{
           int num = 5;
           long fact = 1;
           for(int i=1;i<=num;i++){
               fact *= i;
           }
            System.out.println("Factorial of " + num + " is: " + fact);
        });


        // Task 3: Print messages
        Thread printTask = new Thread(()->{
            for(int i=0;i<5;i++){
                System.out.println("Printing message " + (i + 1));
                try{
                    Thread.sleep(5000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });


        // Start all tasks
        sumTask.start();
        factorialTask.start();
        printTask.start();



        // Wait for all threads to finish
        sumTask.join();
        factorialTask.join();
        printTask.join();


        System.out.println("All tasks are completed!");
    }
}
