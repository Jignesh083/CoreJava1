package MultitaskByAnnonymousEx;


public class Demo {
    public static void main(String[] args) throws InterruptedException {
        // Task 1: Sum of numbers from 1 to 100 using an anonymous class
        Thread sumTask = new Thread(){
            public void run(){
                int sum = 0;
                for (int i=1;i<=100;i++){
                    sum += i;
                }
                System.out.println("Sum of numbers from 1 to 100: " + sum);
            }
        };



        // Task 2: Factorial calculation using an anonymous class
        Thread factTask = new Thread(){
          public void run(){
              int num = 5;
              long fact = 1;
              for (int i=1;i<=num;i++){
                  fact *= i;
              }
              System.out.println("Factorial of " + num + " is: " + fact);
          }
        };



        // Task 3: Printing messages using an anonymous class
        Thread printTask = new Thread(){
            public void run(){
                for (int i=0;i<5;i++){
                    System.out.println("Printing message " + (i + 1));
                    try{
                        Thread.sleep(5000);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };



        sumTask.start();
        factTask.start();
        printTask.start();



        sumTask.join();
        factTask.join();
        printTask.join();

        System.out.println("All tasks are completed!");
    }
}
