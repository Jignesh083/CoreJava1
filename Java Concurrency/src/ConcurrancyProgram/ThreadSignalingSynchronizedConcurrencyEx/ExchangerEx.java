package ConcurrancyProgram.ThreadSignalingSynchronizedConcurrencyEx;

import java.util.concurrent.Exchanger;

public class ExchangerEx {

    public static final Exchanger<String> exchanger = new Exchanger<>();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread( ()->{
            exchangeData("Thread 1: Sending data"," Data from Thread 1");
        });


        Thread t2 = new Thread( ()->{
            exchangeData("Thread 2: Sending data"," Data from Thread 2");
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    private static void exchangeData(String message, String dataToSend) {
        try{
            System.out.println(message+" : "+dataToSend);
            String receiveData = exchanger.exchange(dataToSend); //Exchange Data
            System.out.println(message+": Received - "+receiveData);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
