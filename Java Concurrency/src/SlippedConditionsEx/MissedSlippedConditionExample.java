package SlippedConditionsEx;

public class MissedSlippedConditionExample {
        public void checkConditions(int age) {
            if (age > 18) {
                System.out.println("You are an adult.");
            } else if (age > 0) {
                System.out.println("You are a minor.");
            }
            // Missed condition: what if age is 0 or negative?
        }

        public static void main(String[] args) {
            MissedSlippedConditionExample example = new MissedSlippedConditionExample();
            example.checkConditions(16);  // Output: "You are a minor."
            example.checkConditions(0);   // No output (slipped condition)
        }
    }


