package ImplementingTheIterableInterfaceEx;

import java.util.Iterator;

public class Main {
        public static void main(String[] args) {
            // Create an instance of MyList
            MyList<String> myList = new MyList<>(5);

            // Add some elements to the list
            myList.add("Java");
            myList.add("Python");
            myList.add("C++");

            // Using a for-each loop to iterate over MyList
            for (String language : myList) {
                System.out.println(language);  // It will print "Java", "Python", "C++"
            }

            // Alternatively, you can use the iterator explicitly
            Iterator<String> iterator = myList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());  // Same output: "Java", "Python", "C++"
            }
        }
    }