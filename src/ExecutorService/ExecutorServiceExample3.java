package ExecutorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample3 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Callable<String>> callables = new ArrayList<>();
        callables.add(newCallable("Task 1"));
        callables.add(newCallable("Task 2"));
        callables.add(newCallable("Task 3"));

        try{
            // Also read about invokeAny
            List<Future<String>> results = executorService.invokeAll(callables);

            for(Future future : results){
                System.out.println(future.get());
            }


        }catch(InterruptedException e){

        } catch (ExecutionException e) {
        }

        executorService.shutdown();
    }

    private static Callable newCallable(String msg){
        return new Callable() {
            @Override
            public Object call() throws Exception {
                String completeMsg = Thread.currentThread().getName() + ": " + msg;
                return completeMsg;
            }
        };
    }
}
