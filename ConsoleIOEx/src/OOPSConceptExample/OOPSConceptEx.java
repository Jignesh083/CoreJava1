package OOPSConceptExample;


import java.util.Scanner;

class Person{
    private String name;
    private int age;


    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }


    public void displayInfo(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
    }
}









class Employee extends Person{
    private double salary;

    public Employee(String name,int age,double salary){
        super(name,age);
        this.salary = salary;
    }


    public double getSalary(){
        return salary;
    }


    public void displayInfo(){
        super.displayInfo();
        System.out.println("Salary: "+salary);
    }

}




public class OOPSConceptEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        Person person = new Person(name,age);
        System.out.println("\nPerson Info: ");
        person.displayInfo();

        System.out.println("\nEnter salary for Employee: ");
        double salary = sc.nextDouble();



        Employee emp = new Employee(name,age,salary);
        System.out.println("\nEmployee Info: ");
        emp.displayInfo();

        sc.close();
    }
}
