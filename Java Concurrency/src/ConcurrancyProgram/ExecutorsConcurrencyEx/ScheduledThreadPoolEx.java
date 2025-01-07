package ConcurrancyProgram.ExecutorsConcurrencyEx;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolEx {
    public static void main(String[] args) {
        ScheduledExecutorService ex = Executors.newScheduledThreadPool(3);
        ex.scheduleAtFixedRate(new Task3(9),0,1, TimeUnit.SECONDS);
    }
}


class Task3 implements Runnable{
    private int taskId;

    public Task3(int taskId){
        this.taskId = taskId;
    }

    public void run() {
        System.out.println("Task "+taskId+" is running on Thread: "+Thread.currentThread().getName());
    }

}