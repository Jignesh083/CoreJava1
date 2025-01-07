package GenericSet;

import java.sql.SQLOutput;
import java.util.LinkedHashSet;
import java.util.Set;

public class GenericLinkedHashSet<T> {
        // LinkedHashSet to hold generic items of type T
        private Set<T> linkedHashSet;

        // Constructor to initialize the LinkedHashSet
        public GenericLinkedHashSet() {
            linkedHashSet = new LinkedHashSet<>();
        }

        // Method to add an item to the set
        public void addItem(T item) {
            linkedHashSet.add(item);
        }

        // Method to remove an item from the set
        public boolean removeItem(T item) {
            return linkedHashSet.remove(item);
        }

        // Method to check if the set contains an item
        public boolean containsItem(T item) {
            return linkedHashSet.contains(item);
        }

        // Method to get the size of the set
        public int size() {
            return linkedHashSet.size();
        }

        // Method to check if the set is empty
        public boolean isEmpty() {
            return linkedHashSet.isEmpty();
        }

        // Method to print all items in the set (in insertion order)
        public void printSet() {
            for (T item : linkedHashSet) {
                System.out.println(item);
            }
        }

        // Main method to demonstrate the generic LinkedHashSet and its methods
        public static void main(String[] args) {
            // Example 1: LinkedHashSet of Strings (T = String)
            GenericLinkedHashSet<String> fruitSet = new GenericLinkedHashSet<>();
            fruitSet.addItem("Apple");
            fruitSet.addItem("Banana");
            fruitSet.addItem("Cherry");
            fruitSet.addItem("Apple");  // Duplicate item will not be added

            System.out.println("Fruit Set (in insertion order):");
            fruitSet.printSet();  // Outputs: Apple, Banana, Cherry

            // Example 2: LinkedHashSet of Integers (T = Integer)
            GenericLinkedHashSet<Integer> numberSet = new GenericLinkedHashSet<>();
            numberSet.addItem(10);
            numberSet.addItem(20);
            numberSet.addItem(30);
            numberSet.addItem(10);  // Duplicate item will not be added

            System.out.println("Number Set (in insertion order):");
            numberSet.printSet();  // Outputs: 10, 20, 30

            // Example 3: LinkedHashSet of custom objects (T = Person)
            GenericLinkedHashSet<Person> personSet = new GenericLinkedHashSet<>();
            personSet.addItem(new Person("Alice", 25));
            personSet.addItem(new Person("Bob", 30));
            personSet.addItem(new Person("Alice", 25));  // Duplicate object will not be added

            System.out.println("Person Set (in insertion order):");
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
                if (this == obj)
                    return true;
                if (obj == null || getClass() != obj.getClass())
                    return false;
                Person person = (Person) obj;
                return age == person.age && name.equals(person.name);
            }

            @Override
            public int hashCode() {
                System.out.println("name "+name);
                System.out.println("HashCode: "+name.hashCode());
                return 31 * name.hashCode() + age;
            }
        }
    }
