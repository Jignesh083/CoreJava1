package ConcurrancyProgram.ConcurrentCollectionsEx;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapEx {
    public static void main(String[] args) {
        Map<String,Integer> map = new ConcurrentHashMap<>();
        map.put("A",1);
        map.put("B",2);
        map.put("C",3);
        map.put("D", 4);


//        Integer result = map.putIfAbsent("D",5);
//
//        System.out.println("Result: " + result);
//        map.remove("C",3);
//        map.replace("D",4,22);
//        System.out.println(map);
        //


        Thread readerThread = new Thread(() -> {
            for (String key : map.keySet()) {
                System.out.println("Key: " + key + ", value: " + map.get(key));
            }
        });

        Thread writerThread = new Thread(()->{
           map.put("E",5);
        });

        readerThread.start();
        writerThread.start();
    }
}
