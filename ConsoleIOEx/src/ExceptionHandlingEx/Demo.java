package ExceptionHandlingEx;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = null;
        int age = 0;

        try{
            System.out.println("Enter your Name: ");
            name = sc.nextLine();
            if(name.isEmpty()){
                throw new IllegalArgumentException("Name cannot be empty.");
            }
        }
        catch (Exception e){
            System.out.println("Error while reading name: " + e.getMessage());
        }

        try{
            System.out.println("Enter your Age: ");
            age = sc.nextInt();
            if(age<=0){
                throw new IllegalArgumentException("Age must be a positive number.");
            }
        }
        catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter a valid number for age.");
            return;
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
            return;
        }

    }
}
