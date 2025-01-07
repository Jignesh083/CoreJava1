package SlippedConditionsEx;

public class ExceptionHandlingSlippedConditionExample {
        public void readFile(String fileName) {
            try {
                // Simulating reading from a file (this could throw FileNotFoundException)
                System.out.println("Reading file: " + fileName);
            } catch (Exception e) {
                // Missed specific exception handling
                System.out.println("An error occurred.");
            }
        }

        public static void main(String[] args) {
            ExceptionHandlingSlippedConditionExample example = new ExceptionHandlingSlippedConditionExample();
            example.readFile("nonexistentfile.txt");
        }

}
