package ConcurrancyProgram.ThreadSignalingSynchronizedConcurrencyEx;

import java.util.concurrent.Phaser;

public class PhaserExample {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        int currPhase;
        System.out.println("Starting...");
        new MyThread1(phaser,"A");
        new MyThread1(phaser,"B");
        new MyThread1(phaser,"C");


        currPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase "+currPhase+" Completed.");


        currPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase "+currPhase+" Completed.");


        currPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase "+currPhase+" Completed.");


        phaser.arriveAndDeregister();
        if(phaser.isTerminated()){
            System.out.println("The Phaser is Terminated.");
        }
    }
}

class MyThread1{
    Phaser phaser;
    String name;


    public MyThread1(Phaser phaser,String name){
        this.phaser = phaser;
        this.name = name;
        phaser.register();
        new Thread(r).start();
    }

    Runnable r = ()->{
        System.out.println("Thread " + name + " Beginning phase one.");
        phaser.arriveAndAwaitAdvance();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread "+name+" Beginning phase two.");
        phaser.arriveAndAwaitAdvance();

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Thread " + name + " Beginning phase three.");
        phaser.arriveAndDeregister();

    };
}
