package ThreadOperationEx;


class UserThread extends Thread{
    public void run(){
        //task for thread
        System.out.println("This is User Defined Thread.");
    }
}
public class Demo {
    public static void main(String[] args) {
        System.out.println("Program Started...");
        int x = 56+34;
        System.out.println("Sum is: "+x);

        //Thread
        Thread t = Thread.currentThread();
        String tName = t.getName();
        System.out.println("Current running thread is: " + tName);

        //SetName
        t.setName("myMain");
        System.out.println("Set Name: " + t.getName());
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }


        System.out.println("Id: " + t.getId());

        //Going to Start user defined Thread.
        UserThread ut = new UserThread();
        ut.start();

        System.out.println("Program Ended.");
    }
}
