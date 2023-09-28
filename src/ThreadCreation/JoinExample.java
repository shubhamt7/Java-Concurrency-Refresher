package ThreadCreation;

/*The join method blocks the calling thread until the execution of the thread whose join method has been called finishes execution.
 */
public class JoinExample{
    public static void main(String[] args) {
        Runnable runnable = ()->{
            int t = 5;
            while(t > 0){
                sleep(1000);
                System.out.println("Running..");
                t--;
            }
        };
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sleep(int milliSeconds) {
        try{
            Thread.sleep(milliSeconds);
        }catch (InterruptedException ex){
            System.out.println("Exception occurred");
        }
    }
}
