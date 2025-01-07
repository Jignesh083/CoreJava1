package ConcurrancyProgram.LockEx;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultipleLockEx {
    private static final Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        acquiredLock();
    }

    public static void  acquiredLock(){
        lock.lock();
        for (int i=0;i<5;i++) {
            System.out.println("AcquiredLock");
        }
        nestedAcquiredLock();
        lock.unlock();
    }


    public static void nestedAcquiredLock() {
        lock.lock();
        for (int i=0;i<5;i++) {
            System.out.println("NestedAcquiredLock");
        }
        lock.unlock();
    }
}
