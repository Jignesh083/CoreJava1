package ConcurrancyProgram.LockEx;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockEx {
    public static void main(String[] args) {
        Greeting greet = new Greeting();
        MyThread th1 = new MyThread(greet,"Rahul");
        MyThread th2 = new MyThread(greet,"Sosa");

        th1.start();
        th2.start();

    }
}

class Greeting{
    ReentrantLock rl = new ReentrantLock();

    public void wish(String name) throws InterruptedException {
//        rl.lock();
        System.out.println(name+" - Come First");
        if(rl.tryLock(10, TimeUnit.SECONDS)) {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.println("Hello " + name);
            }
            rl.unlock();
        }
        else{
            System.out.println("Bye bye "+name);
        }
//        rl.unlock();
    }
}



class MyThread extends Thread{
    Greeting greet;
    String name;

    public MyThread(Greeting greet,String name){
        this.greet = greet;
        this.name = name;
    }


    public void run(){
        try {
            greet.wish(name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}