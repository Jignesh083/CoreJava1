package GenericMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class GenericLinkedHashMap<T,U> {
        // LinkedHashMap to store key-value pairs (T = Key, U = Value)
        private Map<T, U> linkedHashMap;

        // Constructor to initialize the LinkedHashMap
        public GenericLinkedHashMap() {
            linkedHashMap = new LinkedHashMap<>();
        }

        // Method to add a key-value pair to the map
        public void addEntry(T key, U value) {
            linkedHashMap.put(key, value);
        }

        // Method to remove an entry by key
        public U removeEntry(T key) {
            return linkedHashMap.remove(key);
        }

        // Method to get the value associated with a key
        public U getValue(T key) {
            return linkedHashMap.get(key);
        }

        // Method to check if the map contains a key
        public boolean containsKey(T key) {
            return linkedHashMap.containsKey(key);
        }

        // Method to get the size of the map
        public int size() {
            return linkedHashMap.size();
        }

        // Method to print all key-value pairs in the map (in insertion order)
        public void printMap() {
            for (Map.Entry<T, U> entry : linkedHashMap.entrySet()) {
                System.out.println(entry.getKey() + " => " + entry.getValue());
            }
        }

        // Main method to demonstrate the generic LinkedHashMap and its methods
        public static void main(String[] args) {
            // Example 1: LinkedHashMap of String (key) and Integer (value)
            GenericLinkedHashMap<String, Integer> ageMap = new GenericLinkedHashMap<>();
            ageMap.addEntry("Alice", 25);
            ageMap.addEntry("Bob", 30);
            ageMap.addEntry("Charlie", 35);
            ageMap.addEntry("Alice", 26);  // Updating Alice's age

            System.out.println("Age Map (Insertion Order):");
            ageMap.printMap();  // Outputs: Alice => 26, Bob => 30, Charlie => 35

            // Example 2: LinkedHashMap of Integer (key) and String (value)
            GenericLinkedHashMap<Integer, String> idMap = new GenericLinkedHashMap<>();
            idMap.addEntry(101, "Alice");
            idMap.addEntry(102, "Bob");
            idMap.addEntry(103, "Charlie");

            System.out.println("\nID Map (Insertion Order):");
            idMap.printMap();  // Outputs: 101 => Alice, 102 => Bob, 103 => Charlie

            // Example 3: LinkedHashMap of String (key) and custom class Person (value)
            GenericLinkedHashMap<String, Person> personMap = new GenericLinkedHashMap<>();
            personMap.addEntry("P1", new Person("Alice", 25));
            personMap.addEntry("P2", new Person("Bob", 30));

            System.out.println("\nPerson Map (Insertion Order):");
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
