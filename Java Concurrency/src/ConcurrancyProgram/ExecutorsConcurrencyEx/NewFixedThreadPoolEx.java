package ConcurrancyProgram.ExecutorsConcurrencyEx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewFixedThreadPoolEx {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(3);
        for (int i=1;i<=10;i++){
            ex.execute(new Task1(i));
        }
        ex.shutdown();
    }
}


class Task1 implements Runnable {
    private int taskId;

    public Task1(int taskId){
        this.taskId=taskId;
    }

    public void run() {
        System.out.println("Task "+taskId+" is running on Thread: "+Thread.currentThread().getName());
    }
}

