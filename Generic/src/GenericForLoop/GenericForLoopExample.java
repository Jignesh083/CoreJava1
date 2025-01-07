package GenericForLoop;

import java.util.ArrayList;
import java.util.List;

    public class GenericForLoopExample {
        public static void main(String[] args) {
            // Create a list of Strings
            List<String> stringList = new ArrayList<>();
            stringList.add("Java");
            stringList.add("Python");
            stringList.add("JavaScript");

            // Using a generic for-each loop to iterate through the list
            for (String language : stringList) {
                System.out.println(language); // Automatically infers String type
            }
        }
    }