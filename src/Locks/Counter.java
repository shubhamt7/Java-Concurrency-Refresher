package Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private final Lock lock = new ReentrantLock();
    int count = 0;

    public void incrementCount(){
        try{
            lock.lock();
            count++;
        }finally {
            lock.unlock();
        }
    }

    public int getCount(){
        try{
            lock.lock();
            return count;
        }finally {
            lock.unlock();
        }
    }
}
