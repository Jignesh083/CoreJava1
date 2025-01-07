package NamingAThreadEx;

public class NameUsingTheThreadConstructor {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is Running.");
            }
        },   "Thread-1"); //Naming the Thread

        thread1.start();
    }
}
