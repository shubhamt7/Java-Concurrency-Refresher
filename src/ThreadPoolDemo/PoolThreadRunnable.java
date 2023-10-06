package ThreadPoolDemo;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;


/*

PoolThreadRunnable is just the functionality of the threads of ThreadPool. Each thread of the ThreadPool
executes the run() of a PoolThreadRunnable, which is nothing but taking the tasks out of the queue and
executing them.

 */
public class PoolThreadRunnable implements Runnable{
    private Thread thread = null;
    private BlockingQueue taskQueue = null;
    private boolean isStopped = false;

    public PoolThreadRunnable(BlockingQueue taskQueue){
        this.taskQueue = taskQueue;
    }

    public void run(){
        this.thread = Thread.currentThread();
        while(!isStopped()){
            try{
                Runnable runnable = (Runnable) taskQueue.take();
                runnable.run();
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public synchronized void doStop(){
        isStopped = true;
        this.thread.interrupt();
    }

    public synchronized boolean isStopped(){
        return isStopped;
    }
}
