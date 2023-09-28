package ThreadCreation;

public class Method3 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread started..");
                System.out.println("Thread stopped..");
            }
        };

        Thread myThread = new Thread(runnable);
        myThread.start();
    }
}
