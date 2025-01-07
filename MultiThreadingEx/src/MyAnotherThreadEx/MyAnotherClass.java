package MyAnotherThreadEx;

import MultiThreadExmple.MyThread;

public class MyAnotherClass extends Thread{
    public void run(){
        for (int i=10;i>=0;i--){
            System.out.println("Another Thread: " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void main(String[] args) {
        MyAnotherClass myAnotherClass = new MyAnotherClass();
        MyThread myThread =new MyThread();
        Thread thread = new Thread(myThread);

        thread.start();
        myAnotherClass.start();

    }
}
