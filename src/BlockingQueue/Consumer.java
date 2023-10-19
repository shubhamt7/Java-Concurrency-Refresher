package BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(true){
            long time = System.currentTimeMillis();
            String item = null;
            try {
                item = blockingQueue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Consumed: " + item);
        }
    }
}
