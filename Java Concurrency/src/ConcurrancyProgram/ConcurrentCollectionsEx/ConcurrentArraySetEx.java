package ConcurrancyProgram.ConcurrentCollectionsEx;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConcurrentArraySetEx {
    public static void main(String[] args) {
        Set<String> set = new CopyOnWriteArraySet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");


        Thread readThread = new Thread(()->{
            System.out.println("Read Thread Started.");
            for (String e : set){
                System.out.println("Read: "+e);
            }
        });



        Thread writeThread = new Thread(()->{
            System.out.println("Modify Thread Started.");
            set.add("E");
        });


        readThread.start();
        writeThread.start();

    }
}
