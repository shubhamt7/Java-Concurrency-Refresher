package BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/*

Producer Consumer Pattern use cases:

1. Reduce foreground thread latency - Many applications have a foreground or UI or main thread whose main purpose is to accept
user events and then quickly be available for receiving the next events, and not remain blocked until the first event has
been processed. In such applications, the main thread accepts the user events, puts them into a task queue (blocking queue in
our example), from where the worker threads (consumers) pick one at a time and execute. This way, the foreground thread latency,
that is the time difference between accepting one user event, and being available to accept the next event, is reduced.

2. Load balance between worker threads - for example, sending notifications or emails to huge number of users. Producer threads
can create one task for each user id and put it in the queue. Consumer threads will pick one task and send the notification to
the corresponding user.

3. Backpressure management - Events being produced or the data being fed to the queue can be slowed down or geared up based on the
current size of the queue, or the current average time taken by threads to execute the tasks.


 */
public class ProducerConsumerExample {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        Thread producerThread = new Thread(new Producer(blockingQueue));
        Thread consumerThread = new Thread(new Consumer(blockingQueue));

        producerThread.start();
        consumerThread.start();
    }

}
