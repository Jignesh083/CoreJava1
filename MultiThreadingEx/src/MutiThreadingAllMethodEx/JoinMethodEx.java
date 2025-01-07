package MutiThreadingAllMethodEx;

public class JoinMethodEx extends Thread{
    public void run(){
        try{
            for(int i=0;i<10;i++){
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        JoinMethodEx th = new JoinMethodEx();
        th.start();

        th.join();
        try{
            for (int i=0;i<10;i++){
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
