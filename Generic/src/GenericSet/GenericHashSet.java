package GenericSet;

import java.util.HashSet;
import java.util.Set;

public class GenericHashSet<T> {
        // Set to hold generic items of type T
        private Set<T> set;

        // Constructor to initialize the set
        public GenericHashSet() {
            set = new HashSet<>();
        }

        // Method to add an item to the set
        public void addItem(T item) {
            set.add(item);
        }

        // Method to remove an item from the set
        public boolean removeItem(T item) {
            return set.remove(item);
        }

        // Method to check if the set contains an item
        public boolean containsItem(T item) {
            return set.contains(item);
        }

        // Method to get the size of the set
        public int size() {
            return set.size();
        }

        // Method to check if the set is empty
        public boolean isEmpty() {
            return set.isEmpty();
        }

        // Method to print all items in the set
        public void printSet() {
            for (T item : set) {
                System.out.println(item);
            }
        }

        // Main method to demonstrate the generic set and its methods
        public static void main(String[] args) {
            // Example 1: Set of Strings (T = String)
            GenericHashSet<String> fruitSet = new GenericHashSet<>();
            fruitSet.addItem("Apple");
            fruitSet.addItem("Banana");
            fruitSet.addItem("Cherry");
            fruitSet.addItem("Apple");  // Duplicate item will not be added

            System.out.println("Fruit Set:");
            fruitSet.printSet();  // Outputs: Apple, Banana, Cherry

            // Check if an item exists in the set
            System.out.println("Contains 'Apple': " + fruitSet.containsItem("Apple"));  // true

            // Remove an item from the set
            fruitSet.removeItem("Banana");
            System.out.println("After removing 'Banana':");
            fruitSet.printSet();  // Outputs: Apple, Cherry

            // Example 2: Set of Integers (T = Integer)
            GenericHashSet<Integer> numberSet = new GenericHashSet<>();
            numberSet.addItem(10);
            numberSet.addItem(20);
            numberSet.addItem(30);
            numberSet.addItem(10);  // Duplicate item will not be added

            System.out.println("Number Set:");
            numberSet.printSet();  // Outputs: 10, 20, 30

            // Example 3: Set of custom objects (T = Person)
            GenericHashSet<Person> personSet = new GenericHashSet<>();
            personSet.addItem(new Person("Alice", 25));
            personSet.addItem(new Person("Bob", 30));
            personSet.addItem(new Person("Alice", 25));  // Duplicate object will not be added (based on equality)

            System.out.println("Person Set:");
            personSet.printSet();  // Outputs: Person{name='Alice', age=25}, Person{name='Bob', age=30}
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

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                Person person = (Person) obj;
                return age == person.age && name.equals(person.name);
            }

            @Override
            public int hashCode() {
                return 31 * name.hashCode() + age;
            }
        }
    }
