package Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/*

Synchronized block and locks -

1. Synchronized blocks must be contained within a single method, whereas lock can span across multiple methods,
where we acquire a lock in one method and then unlock it in some other method, going through a chain of methods.

2. lock.lock() and lock.unlock() provide the same visibility and 'happens before' guarantees as entering and exiting
a synchronized block.

3. Synchronized blocks do not guarantee fairness. Locks can.

4. A thread holding a lock can call lock.lock() again, but it has to call lock.unlock() as many times as it calls
lock.lock() previously.
 */

public class LockDemo2 {
    public static void main(String[] args) {
        lockBasics();
    }
    private static void lockBasics(){
        Lock lock = new ReentrantLock();
        Runnable runnable = () -> {lockSleepUnlock(lock);};
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void lockSleepUnlock(Lock lock){
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " holds lock..");
        }finally {
            lock.unlock();
        }
    }
}
