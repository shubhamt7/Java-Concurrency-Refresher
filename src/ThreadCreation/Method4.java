package ThreadCreation;

public class Method4 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Thread started..");
            System.out.println("Thread stopped..");
        };
        Thread myThread = new Thread(runnable);
        myThread.start();
    }
}
