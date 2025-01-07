package ConcurrancyProgram.ThreadSignalingSynchronizedConcurrencyEx;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchEx {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        for (int i=0;i<3;i++){
            new Thread(()->{
                System.out.println("Task Completed by Thread " + Thread.currentThread().getId());
                latch.countDown();
            }).start();
        }
        try {
            latch.await();
            System.out.println("All Task Completed. Processing to the next Step!");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
