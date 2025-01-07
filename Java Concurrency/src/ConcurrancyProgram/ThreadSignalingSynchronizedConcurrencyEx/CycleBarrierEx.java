package ConcurrancyProgram.ThreadSignalingSynchronizedConcurrencyEx;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CycleBarrierEx {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3,()->{
            System.out.println("Barrier reached...");
        });
        System.out.println("Starting...");
        new MyThread(cb,"A");
        new MyThread(cb,"B");
//        new MyThread(cb,"C");
    }
}

class MyThread{
    CyclicBarrier cbar;
    String name;

    public MyThread(CyclicBarrier c,String n){
        this.cbar = c;
        this.name = n;
        new Thread(r).start();
    }

    Runnable r = () -> {
        System.out.println(name);
        try {
            cbar.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    };
}
