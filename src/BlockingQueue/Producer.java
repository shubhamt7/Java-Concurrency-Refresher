package BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(true){
            long time = System.currentTimeMillis();
            try {
                blockingQueue.put("" + time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
