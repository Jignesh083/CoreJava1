package WildCardGenericEx;

import java.util.ArrayList;

public class WildEx {
    public static void main(String[] args) {
//        ArrayList<?> arrayList = new ArrayList<String>();
//        arrayList.add(12); // show error cause wild card only read karta hain add nahi kar sakte usme



    }


//    public Object getFirst(ArrayList<?> list) //That is wild card


    public <T> T getFirst(ArrayList<T> list) {
        return list.get(0);
    }


    public <T> void copy(ArrayList<T> source, ArrayList<T> destination) {
        for (T item : source) {
            destination.add(item);
        }
    }


//-> wild card ka use kab karenge jab aap read only karte ho aur jab kuch return na karte ho

//public Object void copy1(ArrayList<?> source, ArrayList<?> destination) {
//    for (Object item : source) {
//        destination.add(item); // show error
//    }
//}
}
