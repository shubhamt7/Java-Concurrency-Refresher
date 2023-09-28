package ThreadCreation;

/*The setDaemon() method of thread class is used to mark the thread either daemon thread or a user thread.
 Its life depends on the user threads i.e. when all user threads die, JVM terminates this thread automatically.
 It must be invoked before the thread is started.

 If a thread is daemon thread, JVM will not wait for it to finish execution. JVM will shut down when all the
 user threads have terminated.
 */
public class DaemonThreadExample {
    public static void main(String[] args) {
        Runnable runnable = ()->{
            while(true){
                sleep(1000);
                System.out.println("Running..");
            }
        };
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        sleep(3500);
    }

    public static void sleep(int milliSeconds) {
        try{
            Thread.sleep(milliSeconds);
        }catch (InterruptedException ex){
            System.out.println("Exception occurred");
       }
    }
}
