package ThreadPoolingEx;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTaskDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        scheduledExecutorService.schedule(()->{
            System.out.println("Delayed Task executed");
        },5, TimeUnit.SECONDS);


        scheduledExecutorService.scheduleAtFixedRate(()->{
            System.out.println("Periodic Task executed");
        },0,3,TimeUnit.SECONDS);
    }
}
