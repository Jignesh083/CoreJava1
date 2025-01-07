package MultiThreadExmple;
public class MyThread implements Runnable{
        public void run(){
            for(int i=1;i<=10;i++){
                System.out.println("Value of i is: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
//        myThread.run();
        thread.start();
    }
    }
