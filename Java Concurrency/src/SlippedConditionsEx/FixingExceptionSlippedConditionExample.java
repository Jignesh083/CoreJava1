package SlippedConditionsEx;

import java.lang.reflect.Constructor;

public class FixingExceptionSlippedConditionExample {
        public void readFile(String fileName) {

            try {
                // Simulating reading from a file
                System.out.println("Reading file: " + fileName);
                // In reality, file I/O operations would be here.
                if (fileName.equals("nonexistentfile.txt")) {
                    throw new java.io.FileNotFoundException("File not found!");
                }
            } catch (java.io.FileNotFoundException e) {
                System.out.println("Error: File not found.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred.");
            }
        }

        public static void main(String[] args) {
            FixingExceptionSlippedConditionExample example = new FixingExceptionSlippedConditionExample();
            example.readFile("nonexistentfile.txt");  // Output: "Error: File not found."
        }
}
