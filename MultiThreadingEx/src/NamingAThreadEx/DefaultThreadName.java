package NamingAThreadEx;

public class DefaultThreadName {
    public static void main(String[] args) {
        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        });

        thread3.start();  // No name provided, default name will be assigned
    }
}
