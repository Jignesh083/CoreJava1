package ClassGeneric;

public class newExampleIntroductionEx {
    public static void main(String[] args) {
        Pair<String,Integer> pair = new Pair<>("Age",22);
        System.out.println(pair.getKey() + " " + pair.getValue());

        /*
        T: Type
        E: Elements (Used in collection)
        K: Key (Used in maps)
        V: Value (Used in maps)
        N: Number
         */
    }
}


class Pair<K,V>{
    private K key;
    private V value;

    public Pair(K key,V value){
        this.key = key;
        this.value = value;
    }


    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }
}
