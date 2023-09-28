package ThreadCreation;

import java.sql.SQLOutput;

public class Method1 {

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Thread Started..");
            System.out.println("Thread Stopped..");
        }
    }
    public static void main(String[] args) {
        Thread thread1 = new MyThread();
        thread1.start();
    }


}
