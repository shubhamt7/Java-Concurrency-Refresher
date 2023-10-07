package Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.incrementCount();
        counter.incrementCount();
        System.out.println(counter.getCount());

        Thread myThread1 = new Thread(() -> {
            counter.incrementCount();
            System.out.println(counter.getCount());
        });
        myThread1.start();
    };
}
