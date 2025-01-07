package MutiThreadingAllMethodEx;

import java.sql.SQLOutput;

public class InterruptingMethodEx extends Thread {
    public void run(){
//        System.out.println(Thread.interrupted()); // make false interrupted method
        System.out.println(Thread.currentThread().isInterrupted()); //check this method
            try {
                for (int i = 0; i <= 5; i++) {
//                    Thread.sleep(1000);
                    System.out.println("Hello");
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    public static void main(String[] args) {
        InterruptingMethodEx th = new InterruptingMethodEx();
        th.start();
        th.interrupt(); //Stop Thread
    }
}
