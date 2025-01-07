public class IntroductionOfGeneric {
    public static void main(String[] args) {
        Box<Integer> box = new Box(); //Box is now Type Safety
        box.setValue(1);
//        String i = (String) box.getValue(); //compiled Time error show Because Box class Is a Type Safe.
        int i = box.getValue();
        System.out.println(i);
    }
}

class Box<T>{ //T means Type
    private T value;

    public T getValue(){
        return value;
    }


    public void setValue(T value){
        this.value = value;
    }
}