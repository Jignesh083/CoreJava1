package MethodGenricEx;

public class MethodsEx {
    public static void main(String[] args) {
        MethodsEx methodsEx = new MethodsEx();
        Integer[] intArray = {1, 2, 3, 4};
        String[] stringArray = {"Hello","Rahul","Sosa"};
        methodsEx.printArray(intArray);
        methodsEx.printArray(stringArray);

        display(12);
        display("Chinmay");
     }


     public static <T> void display(T element){
         System.out.println("Generic Display: "+element);
     }


     public static void display(Integer element){
         System.out.println("Integer Display: "+element);
     }

    public <T> void printArray(T[] array){
        for (T ele : array){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
}
