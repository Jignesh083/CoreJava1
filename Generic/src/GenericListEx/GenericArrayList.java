package GenericListEx;

import java.util.ArrayList;
import java.util.List;

public class GenericArrayList<T>{

    // List to hold generic items of type T
    private List<T> items;

    // Constructor to initialize the list
    public GenericArrayList() {
        items = new ArrayList<>();
    }

    // Method to add an item to the list
    public void addItem(T item) {
        items.add(item);
    }

    // Method to remove an item from the list
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

    // Method to get the size of the list
    public int size() {
        return items.size();
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Method to iterate over the list and print each element
    public void printItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }

    // Method to clear the list
    public void clearList() {
        items.clear();
    }

    // Main method to demonstrate the generic class and its methods
    public static void main(String[] args) {
        // Example 1: List of Strings (T = String)
        GenericArrayList<String> fruitList = new GenericArrayList<>();
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

        // Example 2: List of Integers (T = Integer)
        GenericArrayList<Integer> numberList = new GenericArrayList<>();
        numberList.addItem(10);
        numberList.addItem(20);
        numberList.addItem(30);

        System.out.println("Number List:");
        numberList.printItems();  // Outputs: 10, 20, 30

        // Example 3: List of custom objects (T = Person)
        GenericArrayList<Person> personList = new GenericArrayList<>();
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
