package ConcurrancyProgram.ForkAndJoinConcurrentEx;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskEx {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        double[] nums = new double[5000];
        for (int i=0;i<nums.length;i++){
            nums[i]  = ((i%2) == 0 ? i : -i);
        }
        Sum task = new Sum(nums,0,nums.length);
        double result = pool.invoke(task);
        System.out.println("Result: "+result);
    }
}

class Sum extends RecursiveTask<Double> {

    final int thresholder = 500;
    double[] data;
    int start,end;


    Sum(double[] data,int start,int end){
        this.data = data;
        this.start = start;
        this.end =end;
    }


    @Override
    protected Double compute() {
        double sum = 0;
        if((start-end)<thresholder){
            for (int i=start;i<end;i++){
                sum += data[i];
            }
        }
        else{
            int middle = (start-end) / 2;
            Sum subTask1 = new Sum(data,start,middle);
            Sum subTask2 = new Sum(data,middle,end);

            subTask1.fork();
            subTask2.fork();

            sum = subTask1.join() + subTask2.join();
        }
        return sum;
    }
}
