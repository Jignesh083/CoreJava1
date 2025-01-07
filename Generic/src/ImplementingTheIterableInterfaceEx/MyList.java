package ImplementingTheIterableInterfaceEx;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyList<T> implements Iterable<T>{
        private T[] elements;   // Array to store elements
        private int size;        // Current size of the list

        // Constructor to initialize the list with a fixed capacity
        public MyList(int capacity) {
            elements = (T[]) new Object[capacity]; // Create an array of type T
            size = 0;
        }

        // Method to add an element to the list
        public void add(T element) {
            if (size < elements.length) {
                elements[size] = element;
                size++;
            } else {
                System.out.println("List is full!");
            }
        }

        // Implementing the iterator() method to return an iterator
        @Override
        public Iterator<T> iterator() {
            return new MyIterator();
        }

        // A custom iterator class that implements Iterator<T>
        private class MyIterator implements Iterator<T> {
            private int currentIndex = 0; // Start at the beginning

            @Override
            public boolean hasNext() {
                return currentIndex < size;  // Check if there's more elements to iterate
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements in the list.");
                }
                return elements[currentIndex++];  // Return the current element and move the index
            }

            // Optional: Remove is not supported in this example
            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove operation is not supported.");
            }
        }

        // Method to get the size of the list
        public int size() {
            return size;
        }
    }


