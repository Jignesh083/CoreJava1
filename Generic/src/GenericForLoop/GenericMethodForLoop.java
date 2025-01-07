package GenericForLoop;

import java.util.ArrayList;
import java.util.List;

public class GenericMethodForLoop {
        // Generic method to print a list of any type
        public static <T> void printList(List<T> list) {
            // Using a for-each loop to iterate over the list of type T
            for (T item : list) {
                System.out.println(item); // Print each item of the list
            }
        }

        public static void main(String[] args) {
            List<String> stringList = new ArrayList<>();
            stringList.add("Hello");
            stringList.add("World");

            List<Integer> intList = new ArrayList<>();
            intList.add(1);
            intList.add(2);

            // Calling the generic method with different types
            printList(stringList);  // Prints the list of Strings
            printList(intList);     // Prints the list of Integers
        }
    }
