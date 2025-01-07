package MutiThreadingAllMethodEx;

public class YieldDemoMethodEx extends Thread{

    public void run(){
        Thread.yield(); //current thread stop
        for (int i=0;i<=5;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }


    public static void main(String[] args) {
        YieldDemoMethodEx th = new YieldDemoMethodEx();
        th.start();

//        Thread.yield();
        for (int i=0;i<=5;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
        }

    }
}
