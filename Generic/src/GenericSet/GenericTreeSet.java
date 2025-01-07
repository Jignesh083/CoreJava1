package GenericSet;

import java.util.TreeSet;

public class GenericTreeSet<T> {
        // TreeSet to hold generic items of type T
        private TreeSet<T> treeSet;

        // Constructor to initialize the TreeSet
        public GenericTreeSet() {
            treeSet = new TreeSet<>();
        }

        // Method to add an item to the set
        public void addItem(T item) {
            treeSet.add(item);
        }

        // Method to remove an item from the set
        public boolean removeItem(T item) {
            return treeSet.remove(item);
        }

        // Method to check if the set contains an item
        public boolean containsItem(T item) {
            return treeSet.contains(item);
        }

        // Method to get the size of the set
        public int size() {
            return treeSet.size();
        }

        // Method to check if the set is empty
        public boolean isEmpty() {
            return treeSet.isEmpty();
        }

        // Method to print all items in the set (sorted order)
        public void printSet() {
            for (T item : treeSet) {
                System.out.println(item);
            }
        }

        // Main method to demonstrate the generic TreeSet and its methods
        public static void main(String[] args) {
            // Example 1: TreeSet of Strings (T = String)
            GenericTreeSet<String> fruitSet = new GenericTreeSet<>();
            fruitSet.addItem("Apple");
            fruitSet.addItem("Banana");
            fruitSet.addItem("Cherry");
            fruitSet.addItem("Apple");  // Duplicate item will not be added

            System.out.println("Fruit Set (sorted):");
            fruitSet.printSet();  // Outputs: Apple, Banana, Cherry

            // Example 2: TreeSet of Integers (T = Integer)
            GenericTreeSet<Integer> numberSet = new GenericTreeSet<>();
            numberSet.addItem(10);
            numberSet.addItem(20);
            numberSet.addItem(30);
            numberSet.addItem(10);  // Duplicate item will not be added

            System.out.println("Number Set (sorted):");
            numberSet.printSet();  // Outputs: 10, 20, 30

            // Example 3: TreeSet of custom objects (T = Person)
            GenericTreeSet<Person> personSet = new GenericTreeSet<>();
            personSet.addItem(new Person("Alice", 25));
            personSet.addItem(new Person("Bob", 30));
            personSet.addItem(new Person("Alice", 25));  // Duplicate object will not be added

            System.out.println("Person Set (sorted):");
            personSet.printSet();  // Outputs: Person{name='Alice', age=25}, Person{name='Bob', age=30}
        }

        // Custom Person class for demonstration
        static class Person implements Comparable<Person> {
            String name;
            int age;

            Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            // Implementing compareTo method for sorting by name and age
            @Override
            public int compareTo(Person other) {
                // First compare by name
                int nameComparison = this.name.compareTo(other.name);
                if (nameComparison != 0) {
                    return nameComparison; // If names are different, return the result
                }
                // If names are the same, compare by age
                return Integer.compare(this.age, other.age);
            }

            @Override
            public String toString() {
                return "Person{name='" + name + "', age=" + age + "}";
            }
        }
    }
