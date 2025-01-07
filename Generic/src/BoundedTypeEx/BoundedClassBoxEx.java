package BoundedTypeEx;

public class BoundedClassBoxEx<T extends Number> { // That is Bounded Parameter
    private T value;
    public T getValue(){
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }
}



 class Main {
    public static void main(String[] args) {
//        BoundedClassBoxEx<String> box = new BoundedClassBoxEx<>(); // Show error because T extends Number not a String
        BoundedClassBoxEx<Integer> box = new BoundedClassBoxEx<>();
    }
}
