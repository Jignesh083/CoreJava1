package GenericListEx;

import java.util.Stack;

public class GenericStack<T> {
        // Stack to hold generic items of type T
        private Stack<T> stack;

        // Constructor to initialize the stack
        public GenericStack() {
            stack = new Stack<>();
        }

        // Method to push an item onto the stack
        public void pushItem(T item) {
            stack.push(item);
        }

        // Method to pop an item from the stack
        public T popItem() {
            if (!stack.isEmpty()) {
                return stack.pop();
            } else {
                System.out.println("Stack is empty!");
                return null;
            }
        }

        // Method to peek the top item of the stack
        public T peekItem() {
            if (!stack.isEmpty()) {
                return stack.peek();
            } else {
                System.out.println("Stack is empty!");
                return null;
            }
        }

        // Method to check if the stack contains an item
        public boolean containsItem(T item) {
            return stack.contains(item);
        }

        // Method to get the size of the stack
        public int size() {
            return stack.size();
        }

        // Method to check if the stack is empty
        public boolean isEmpty() {
            return stack.isEmpty();
        }

        // Method to clear the stack
        public void clearStack() {
            stack.clear();
        }

        // Method to print all elements in the stack
        public void printStack() {
            for (T item : stack) {
                System.out.println(item);
            }
        }

        // Main method to demonstrate the generic stack and its methods
        public static void main(String[] args) {
            // Example 1: Stack of Strings (T = String)
            GenericStack<String> fruitStack = new GenericStack<>();
            fruitStack.pushItem("Apple");
            fruitStack.pushItem("Banana");
            fruitStack.pushItem("Cherry");

            System.out.println("Fruit Stack:");
            fruitStack.printStack();  // Outputs: Apple, Banana, Cherry

            // Peek the top item
            System.out.println("Peek top item: " + fruitStack.peekItem());  // Output: Cherry

            // Pop an item from the stack
            System.out.println("Popped item: " + fruitStack.popItem());  // Output: Cherry
            fruitStack.printStack();  // Outputs: Apple, Banana

            // Check if an item is in the stack
            System.out.println("Contains 'Apple': " + fruitStack.containsItem("Apple"));  // true

            // Example 2: Stack of Integers (T = Integer)
            GenericStack<Integer> numberStack = new GenericStack<>();
            numberStack.pushItem(10);
            numberStack.pushItem(20);
            numberStack.pushItem(30);

            System.out.println("Number Stack:");
            numberStack.printStack();  // Outputs: 10, 20, 30

            // Example 3: Stack of custom objects (T = Person)
            GenericStack<Person> personStack = new GenericStack<>();
            personStack.pushItem(new Person("Alice", 25));
            personStack.pushItem(new Person("Bob", 30));

            System.out.println("Person Stack:");
            personStack.printStack();  // Outputs: Person{name='Alice', age=25}, Person{name='Bob', age=30}
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
