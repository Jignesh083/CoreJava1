package GenericForLoop;

public class GenericForLoopArray {
        public static void main(String[] args) {
            // Array of Strings
            String[] languages = {"Java", "Python", "C++"};

            // Using a generic for-loop (for-each loop) to print each element
            for (String language : languages) {
                System.out.println(language); // Automatically treated as String
            }
        }
    }

