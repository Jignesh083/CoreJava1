package GenericMap;

import java.util.Map;
import java.util.TreeMap;

public class GenericTreeMap<T extends Comparable<T>, U> {
    // TreeMap to store key-value pairs (T = Key, U = Value)
        private Map<T, U> treeMap;

        // Constructor to initialize the TreeMap
        public GenericTreeMap() {
            treeMap = new TreeMap<>();
        }

        // Method to add a key-value pair to the map
        public void addEntry(T key, U value) {
            treeMap.put(key, value);
        }

        // Method to remove an entry by key
        public U removeEntry(T key) {
            return treeMap.remove(key);
        }

        // Method to get the value associated with a key
        public U getValue(T key) {
            return treeMap.get(key);
        }

        // Method to check if the map contains a key
        public boolean containsKey(T key) {
            return treeMap.containsKey(key);
        }

        // Method to get the size of the map
        public int size() {
            return treeMap.size();
        }

        // Method to print all key-value pairs in the map (in sorted order)
        public void printMap() {
            for (Map.Entry<T, U> entry : treeMap.entrySet()) {
                System.out.println(entry.getKey() + " => " + entry.getValue());
            }
        }

        // Main method to demonstrate the generic TreeMap and its methods
        public static void main(String[] args) {
            // Example 1: TreeMap of String (key) and Integer (value)
            GenericTreeMap<String, Integer> ageMap = new GenericTreeMap<>();
            ageMap.addEntry("Alice", 25);
            ageMap.addEntry("Charlie", 35);
            ageMap.addEntry("Bob", 30);
            ageMap.addEntry("Alice", 26);  // Updating Alice's age

            System.out.println("Age Map (Sorted Order):");
            ageMap.printMap();  // Outputs: Alice => 26, Bob => 30, Charlie => 35

            // Example 2: TreeMap of Integer (key) and String (value)
            GenericTreeMap<Integer, String> idMap = new GenericTreeMap<>();
            idMap.addEntry(101, "Alice");
            idMap.addEntry(103, "Charlie");
            idMap.addEntry(102, "Bob");

            System.out.println("\nID Map (Sorted Order):");
            idMap.printMap();  // Outputs: 101 => Alice, 102 => Bob, 103 => Charlie

            // Example 3: TreeMap of String (key) and custom class Person (value)
            GenericTreeMap<String, Person> personMap = new GenericTreeMap<>();
            personMap.addEntry("P1", new Person("Alice", 25));
            personMap.addEntry("p3",new Person("Chinmay",25));
            personMap.addEntry("P2", new Person("Bob", 30));

            System.out.println("\nPerson Map (Sorted Order):");
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


