package DaemonThreadEx;

public class MyDaemonThreadEx extends Thread{
    public void run(){
        // Thread running in the background as a daemon thread
        try{
            int count = 0;
            while(true){
                count++;
                System.out.println("Daemon Thread is Running...Count: "+count);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e){
            System.out.println("Daemon Thread interrupted");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyDaemonThreadEx daemonThread = new MyDaemonThreadEx();

        // Set the thread as a daemon thread
        daemonThread.setDaemon(true);

        // Start the daemon thread
        daemonThread.start();

        // Main thread sleeps for a while to let the daemon thread run
        System.out.println("Main Thread is running...");
        Thread.sleep(5000);


        System.out.println("Main thread finished. Daemon thread will be stopped automatically.");

    }
}
