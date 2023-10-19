package CompareAndSet;

import java.util.concurrent.atomic.AtomicLong;

public class OptimisticLockExample {

    public static void main(String[] args) {
        OptimisticLockExample optimisticLockExample = new OptimisticLockExample();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10000; i++){
                    optimisticLockExample.inc();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10000; i++){
                    optimisticLockExample.inc();
                }
            }
        });

        thread1.start();
        thread2.start();

    }
    private AtomicLong count = new AtomicLong();

    public void inc(){
        boolean isSuccessful = false;
        long newValue = 0;
        while(!isSuccessful){
            long value = getCount();
            newValue = value + 1;
            isSuccessful = this.count.compareAndSet(value, newValue);
        }
        System.out.println("Set the new value to " + newValue + " by thread " + Thread.currentThread().getName());
    }

    public long getCount(){
        return this.count.get();
    }
}
