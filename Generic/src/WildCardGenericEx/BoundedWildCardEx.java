package WildCardGenericEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoundedWildCardEx {
    public static void main(String[] args) {
//        System.out.println(findSum(Arrays.asList(1,2.2,34.50)));

        List<? extends Number> numbers = Arrays.asList(1, 1.1, 2);
//        numbers.add(23);  //Show error
        numbers.add(null);


        List<? super Integer> numbers1 = Arrays.asList(1, 2, 3);
        numbers1.add(34);

    }

    public static double findSum(List<? extends Number> numbers){ //LowerBound
        double sum = 0;
        for (Number o:numbers){
            sum += o.doubleValue();
        }
        return sum;
    }


    public static void printNumber(List<? super Integer> list){ //That is upperBound
        for (Object obj:list){
            System.out.println(obj);
        }
    }
}
