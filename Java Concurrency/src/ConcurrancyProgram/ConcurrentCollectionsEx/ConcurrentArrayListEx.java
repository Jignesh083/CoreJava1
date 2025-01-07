package ConcurrancyProgram.ConcurrentCollectionsEx;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentArrayListEx {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        Thread th1 = new Thread(()->{
            System.out.println("Read Thread Started...");
            for (String str:list) {
                System.out.println("Read: "+str);
            }
        });

        Thread th2 = new Thread(()->{
            System.out.println("Modify Thread Started...");
            list.add("five");
        });


        th1.start();
        th2.start();


        try{
            Thread.sleep(1000);
        }catch (ConcurrentModificationException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(list);
    }
}
