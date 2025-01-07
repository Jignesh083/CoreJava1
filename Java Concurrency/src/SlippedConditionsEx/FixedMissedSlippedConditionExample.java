package SlippedConditionsEx;

public class FixedMissedSlippedConditionExample {
        public void checkConditions(int age) {
            if (age < 0) {
                System.out.println("Invalid age.");
            } else if (age > 18) {
                System.out.println("You are an adult.");
            } else if (age > 0) {
                System.out.println("You are a minor.");
            } else {
                System.out.println("Age cannot be zero.");
            }
        }

        public static void main(String[] args) {
            FixedMissedSlippedConditionExample example = new FixedMissedSlippedConditionExample();
            example.checkConditions(16);  // Output: "You are a minor."
            example.checkConditions(0);   // Output: "Age cannot be zero."
            example.checkConditions(-1);  // Output: "Invalid age."
        }
    }
