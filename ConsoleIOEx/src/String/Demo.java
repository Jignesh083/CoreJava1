package String;

import java.util.Locale;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        name = name.toUpperCase();
        System.out.println("Hello " + name + "! Welcome to the Program.");
        sc.close();
    }
}
