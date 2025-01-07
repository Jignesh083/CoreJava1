package ConcurrancyProgram.ExecutorsConcurrencyEx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewChachedThreadPoolEx {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newCachedThreadPool(); //Thread will be terminated after 60 seconds
        for (int i=0;i<=10;i++){
            ex.execute(new Task2(i));
        }
    }
}


class Task2 implements Runnable{
    private int taskId;

    public Task2(int taskId){
        this.taskId = taskId;
    }

    public void run() {
        System.out.println("Task "+taskId+" is running on Thread: "+Thread.currentThread().getName());
    }

}
