package FileEx;

import java.io.*;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Enter your age: ");
        int age = sc.nextInt();

        String fileName = "user_data.txt";

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write("Name: " + name);
            writer.newLine();
            writer.write("Age: "+age);
            writer.newLine();
            System.out.println("Data has been written to the file.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            System.out.println("\nContents of the file:");
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        sc.close();
    }
}
