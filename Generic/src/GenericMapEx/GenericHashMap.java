package GenericMap;

import java.util.HashMap;
import java.util.Map;

public class GenericHashMap <T,U>{
    // HashMap to store key-value pairs (T = Key, U = Value)
        private Map<T, U> map;

        // Constructor to initialize the HashMap
        public GenericHashMap() {
            map = new HashMap<>();
        }

        // Method to add a key-value pair to the map
        public void addEntry(T key, U value) {
            map.put(key, value);
        }

        // Method to remove an entry by key
        public U removeEntry(T key) {
            return map.remove(key);
        }

        // Method to get the value associated with a key
        public U getValue(T key) {
            return map.get(key);
        }

        // Method to check if the map contains a key
        public boolean containsKey(T key) {
            return map.containsKey(key);
        }

        // Method to get the size of the map
        public int size() {
            return map.size();
        }

        // Method to print all key-value pairs in the map
        public void printMap() {
            for (Map.Entry<T, U> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " => " + entry.getValue());
            }
        }

        // Main method to demonstrate the generic Map and its methods
        public static void main(String[] args) {
            // Example 1: Map of String (key) and Integer (value)
            GenericHashMap<String, Integer> ageMap = new GenericHashMap<>();
            ageMap.addEntry("Alice", 25);
            ageMap.addEntry("Bob", 30);
            ageMap.addEntry("Charlie", 35);
            ageMap.addEntry("Alice", 26);  // Updating Alice's age

            System.out.println("Age Map:");
            ageMap.printMap();  // Outputs: Alice => 26, Bob => 30, Charlie => 35

            // Example 2: Map of Integer (key) and String (value)
            GenericHashMap<Integer, String> idMap = new GenericHashMap<>();
            idMap.addEntry(101, "Alice");
            idMap.addEntry(102, "Bob");
            idMap.addEntry(103, "Charlie");

            System.out.println("\nID Map:");
            idMap.printMap();  // Outputs: 101 => Alice, 102 => Bob, 103 => Charlie

            // Example 3: Map of String (key) and custom class Person (value)
            GenericHashMap<String, Person> personMap = new GenericHashMap<>();
            personMap.addEntry("P1", new Person("Alice", 25));
            personMap.addEntry("P2", new Person("Bob", 30));

            System.out.println("\nPerson Map:");
            personMap.printMap();  // Outputs: P1 => Person{name='Alice', age=25}, P2 => Person{name='Bob', age=30}
        }

        // Custom Person class for demonstration
        static class Person {
            String name;
            int age;

            Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public String toString() {
                return "Person{name='" + name + "', age=" + age + "}";
            }
        }
    }
