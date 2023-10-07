public class Playground {

    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(() -> {
            try {
                Thread.sleep(9000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Finished execution 1");
        });
        Thread myThread2 = new Thread(() -> {
            try {
                Thread.sleep(9000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Finished execution 2");
        });

        myThread.setDaemon(true); // Set myThread as a daemon thread
        myThread2.setDaemon(true); // Set myThread2 as a daemon thread

        myThread.start();
        myThread2.start();
        System.out.println("Main last statement");

    }
}
