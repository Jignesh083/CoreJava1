package ConcurrancyProgram.ExecutorsConcurrencyEx;

public class TraditionalApproachEx {
    public static void main(String[] args) {
        for (int i=0; i<10;i++){
            Thread t1 = new Thread(new Task(i));
            t1.start();
        }
    }
}


class Task implements Runnable {
    private int taskId;

    public Task(int taskId){
        this.taskId=taskId;
    }

    public void run() {
        System.out.println("Task "+taskId+" is running on Thread: "+Thread.currentThread().getName());
    }
}
