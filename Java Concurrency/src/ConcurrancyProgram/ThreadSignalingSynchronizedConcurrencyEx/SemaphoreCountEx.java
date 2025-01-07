package ConcurrancyProgram.ThreadSignalingSynchronizedConcurrencyEx;

import java.util.concurrent.Semaphore;

public class SemaphoreCountEx {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        new IncrementCount("A",sem);
        new DecrementCount("B",sem);
    }
}


class Shared{
    static int count = 0;
}



class IncrementCount {
    String name;
    Semaphore sem;


    public IncrementCount(String name, Semaphore sem){
        this.name = name;
        this.sem = sem;
        new Thread(r1).start();
    }


    Runnable r1 = () -> {
        try {
            System.out.println(name + " is waiting for a permit.");
            sem.acquire();
            System.out.println(name + " gets a Permit.");
            for (int i=0;i<5;i++){
                Shared.count++;
                System.out.println(name+": "+Shared.count);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(name + " releases the permit.");
        sem.release();
    };
}



class DecrementCount{
    String name;
    Semaphore sem;

    public DecrementCount(String name,Semaphore sem){
        this.name = name;
        this.sem = sem;
        new Thread(r2).start(); //Using Thread Method
    }


    Runnable r2 = () -> {
        try{
            System.out.println(name+ " is waiting for a permit.");
            sem.acquire();
            System.out.println(name + " gets a permit.");
            for (int i=0;i<5;i++){
                Shared.count--;
                System.out.println(name+" "+Shared.count);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(name + " releases the permit.");
        sem.release();
    };
}
