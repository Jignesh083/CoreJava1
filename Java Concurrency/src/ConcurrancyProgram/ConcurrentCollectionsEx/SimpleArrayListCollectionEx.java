package ConcurrancyProgram.ConcurrentCollectionsEx;

import java.util.ArrayList;
import java.util.List;

public class SimpleArrayListCollectionEx {

//    concurrent Collection:
//    using for handling multiple Thread
    //Syncronized method are taken particular time then step by step execute program. and one time one task execute
    //concurrent collection are used one time to multiple task like read,write etc.


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        Thread readerThread = new Thread(()->{
            System.out.println("Read Thread Started...");
            for (String str:list) {
                System.out.println("Read: "+str);
            }
        });


        Thread writerThread = new Thread(()->{
            System.out.println("Modify Thread Started...");
            list.add("five"); //Throw ConcurrentModificationException
        });


        readerThread.start();
        writerThread.start();
    }
}
