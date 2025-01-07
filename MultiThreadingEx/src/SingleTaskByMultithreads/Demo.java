package SingleTaskByMultithreads;

class singleTaskEx implements Runnable{
    int start;
    int end;

    public singleTaskEx(int start,int end){
        this.start=start;
        this.end=end;
    }

    public void run(){
        for (int i=start;i<=end;i++){
            System.out.println(Thread.currentThread().getName()+" - count: "+i);
        }
    }
}
public class Demo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new singleTaskEx(1,5));
        Thread t2 = new Thread(new singleTaskEx(6,10));
        Thread t3 = new Thread(new singleTaskEx(11,15));

        t1.setName("T1");
        t2.setName("T2");
        t3.setName("T3");


        t1.start();
        t2.start();
        t3.start();
    }
}
