package SynchronizedAndVolatile;

public class SynchronizedVisibility2 {
    private Object monitor1 = new Object();
    private Object monitor2 = new Object();

    private int counter1 = 0;
    private int counter2 = 0;
    private int counter3 = 0;
    private int counter4 = 0;

    /*

    The below two methods are synced on two different monitor objects, which means that if one thread is executing incCounter1,
    other thread can execute incCounter2 at the same time.

    */

    // synced on obj monitor1
    public void incCounter1(){
        synchronized (monitor1){
            this.counter1++;
        }
    }


    // synced on obj monitor2
    public void incCounter2(){
        synchronized (monitor2){
            this.counter2++;
        }
    }


    /*

    The following two methods are synced on the same monitor object i.e. this.
    So, if a thread is executing incCounter3, no other thread can execute incCounter4 at
    the same time on the same instance, because both of them are synced on the same monitor object i.e. the instance.

    */

    public synchronized void intCounter3(){
        this.counter3++;
    }

    public synchronized void intCounter4(){
        this.counter4++;
    }
}
