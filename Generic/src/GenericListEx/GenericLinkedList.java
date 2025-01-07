package GenericListEx;

import java.sql.SQLOutput;
import java.util.LinkedList;

public class GenericLinkedList<T> {
        // LinkedList to hold generic items of type T
        private LinkedList<T> items;

        // Constructor to initialize the linked list
        public GenericLinkedList() {
            items = new LinkedList<>();
        }

        // Method to add an item to the linked list
        public void addItem(T item) {
            items.add(item);
        }

        // Method to remove an item from the linked list
        public void removeItem(T item) {
            items.remove(item);
        }

        // Method to get an item by index
        public T getItem(int index) {
            return items.get(index);
        }

        // Method to check if the list contains an item
        public boolean containsItem(T item) {
            return items.contains(item);
        }

        // Method to get the size of the linked list
        public int size() {
            return items.size();
        }

        // Method to check if the linked list is empty
        public boolean isEmpty() {
            return items.isEmpty();
        }

        // Method to iterate over the list and print each element
        public void printItems() {
            for (T item : items) {
                System.out.println(item);
            }
        }

        // Method to clear the linked list
        public void clearList() {
            items.clear();
        }

        // Main method to demonstrate the generic linked list and its methods
        public static void main(String[] args) {
            System.out.println("LinkedList");
            // Example 1: LinkedList of Strings (T = String)
            GenericLinkedList<String> fruitList = new GenericLinkedList<>();
            fruitList.addItem("Apple");
            fruitList.addItem("Banana");
            fruitList.addItem("Cherry");

            System.out.println("Fruit List:");
            fruitList.printItems();  // Outputs: Apple, Banana, Cherry

            // Get an item from the list
            System.out.println("Item at index 1: " + fruitList.getItem(1));  // Output: Banana

            // Remove an item
            fruitList.removeItem("Banana");
            System.out.println("After removing 'Banana':");
            fruitList.printItems();  // Outputs: Apple, Cherry

            // Check if an item is in the list
            System.out.println("Contains 'Apple': " + fruitList.containsItem("Apple"));  // true

            // Example 2: LinkedList of Integers (T = Integer)
            GenericLinkedList<Integer> numberList = new GenericLinkedList<>();
            numberList.addItem(10);
            numberList.addItem(20);
            numberList.addItem(30);

            System.out.println("Number List:");
            numberList.printItems();  // Outputs: 10, 20, 30

            // Example 3: LinkedList of custom objects (T = Person)
            GenericLinkedList<Person> personList = new GenericLinkedList<>();
            personList.addItem(new Person("Alice", 25));
            personList.addItem(new Person("Bob", 30));

            System.out.println("Person List:");
            personList.printItems();  // Outputs: Person{name='Alice', age=25}, Person{name='Bob', age=30}
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
