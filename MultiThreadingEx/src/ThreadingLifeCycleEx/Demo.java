package ThreadingLifeCycleEx;

public class Demo extends Thread{

//    public void run(){
//        try{
//            System.out.println("Thread is in Runnable State: "+Thread.currentThread().getName());
//            System.out.println("Thread is going to sleep for 2 second.");
//            Thread.sleep(2000);
//
//            synchronized (this){
//                System.out.println("Thread is in Blocked State (Waiting for lock).");
//                Thread.sleep(1000);
//            }
//
//            System.out.println("Thread is in Waiting State. Waiting for other Thread to finish.");
//            synchronized (this){
//                this.wait();
//            }
//
//            System.out.println("Thread has been notified and is back to Runnable state.");
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println("Thread has completed execution and is in Terminated state: " + Thread.currentThread().getName());
//    }









    public void run(){
        System.out.println("RUNNING");
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}


class Main{
    public static void main(String[] args) throws InterruptedException {
        Demo thread1 = new Demo();
//
//        thread1.start();
//
//        Thread.sleep(3000);
//
//        synchronized (thread1){
//            thread1.notify();
//        }


        System.out.println(thread1.getState());

        thread1.start();
        System.out.println(thread1.getState());
        Thread.sleep(1000);
        System.out.println(thread1.getState());
        thread1.join();
        System.out.println(thread1.getState());
    }
}
