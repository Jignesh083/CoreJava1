package ConcurrancyProgram.ExecutorsConcurrencyEx;

import java.util.concurrent.*;

public class CallableInterfaceEx {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(3);
        System.out.println("Starting...");

        Future<Integer> sum = ex.submit(new Sum(10));
        Future<Double> squareRoot = ex.submit(new SquareRoot(16));
        Future<Integer> fact = ex.submit(new Factorial(5));

        System.out.println(sum.get());
        System.out.println(squareRoot.get());
        System.out.println(fact.get());

        ex.shutdown();
        System.out.println("Completed.");
    }
}

//find sum

class Sum implements Callable<Integer>{
    int stop;

    Sum(int v){
        stop = v;
    }

    public Integer call(){  //This is a generic Type so using Integer wrapper class
        int sum = 0;
        for (int i=0;i<=stop;i++){
            sum += i;
        }
        return sum;
    }
}

//square root


class SquareRoot implements Callable<Double> {
    double num;

    SquareRoot(double num){
        this.num = num;
    }

    public Double call() {
        return Math.sqrt(num);
    }
}

//factorial

class Factorial implements Callable<Integer>{
    int stop;

    Factorial(int v){
        this.stop = v;
    }

    public Integer call() {
        int fact = 1;
        for (int i=2;i<=stop;i++){
            fact *= i;
        }
        return fact;
    }
}
