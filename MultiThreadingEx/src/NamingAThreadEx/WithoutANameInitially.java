package NamingAThreadEx;

public class WithoutANameInitially {
    public static void main(String[] args) {
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        });


        // Setting the name of the thread after creation
        thread2.setName("Custom-Thread");

        thread2.start();
    }
}
