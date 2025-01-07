package GenericListEx;

import java.util.Vector;

public class GenericVector<T> {
        // Vector to hold generic items of type T
        private Vector<T> items;

        // Constructor to initialize the vector
        public GenericVector() {
            items = new Vector<>();
        }

        // Method to add an item to the vector
        public void addItem(T item) {
            items.add(item);
        }

        // Method to remove an item from the vector
        public void removeItem(T item) {
            items.remove(item);
        }

        // Method to get an item by index
        public T getItem(int index) {
            return items.get(index);
        }

        // Method to check if the vector contains an item
        public boolean containsItem(T item) {
            return items.contains(item);
        }

        // Method to get the size of the vector
        public int size() {
            return items.size();
        }

        // Method to check if the vector is empty
        public boolean isEmpty() {
            return items.isEmpty();
        }

        // Method to iterate over the vector and print each element
        public void printItems() {
            for (T item : items) {
                System.out.println(item);
            }
        }

        // Method to clear the vector
        public void clearVector() {
            items.clear();
        }

        // Main method to demonstrate the generic vector and its methods
        public static void main(String[] args) {
            // Example 1: Vector of Strings (T = String)
            GenericVector<String> fruitVector = new GenericVector<>();
            fruitVector.addItem("Apple");
            fruitVector.addItem("Banana");
            fruitVector.addItem("Cherry");

            System.out.println("Fruit Vector:");
            fruitVector.printItems();  // Outputs: Apple, Banana, Cherry

            // Get an item from the vector
            System.out.println("Item at index 1: " + fruitVector.getItem(1));  // Output: Banana

            // Remove an item
            fruitVector.removeItem("Banana");
            System.out.println("After removing 'Banana':");
            fruitVector.printItems();  // Outputs: Apple, Cherry

            // Check if an item is in the vector
            System.out.println("Contains 'Apple': " + fruitVector.containsItem("Apple"));  // true

            // Example 2: Vector of Integers (T = Integer)
            GenericVector<Integer> numberVector = new GenericVector<>();
            numberVector.addItem(10);
            numberVector.addItem(20);
            numberVector.addItem(30);

            System.out.println("Number Vector:");
            numberVector.printItems();  // Outputs: 10, 20, 30

            // Example 3: Vector of custom objects (T = Person)
            GenericVector<Person> personVector = new GenericVector<>();
            personVector.addItem(new Person("Alice", 25));
            personVector.addItem(new Person("Bob", 30));

            System.out.println("Person Vector:");
            personVector.printItems();  // Outputs: Person{name='Alice', age=25}, Person{name='Bob', age=30}
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

