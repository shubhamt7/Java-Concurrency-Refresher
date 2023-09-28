package ThreadCreation;

public class Method2 {

    static class MyThread2 implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread started..");
            System.out.println("Thread stopped..");
        }
    }
    public static void main(String[] args) {
        Thread myThread = new Thread(new MyThread2());
        myThread.start();
    }
}
