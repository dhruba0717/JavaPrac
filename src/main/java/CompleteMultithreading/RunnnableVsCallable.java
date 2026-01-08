package CompleteMultithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnnableVsCallable {

    public static void main(String[] args) throws Exception {

        Runnable r = () -> {
            System.out.println("thread runnning using runnable");
        };

        Thread runnnableTask = new Thread(r);
        runnnableTask.start();

        // same can be written as - > pass runnable inside thread
        Thread runnableTaskLamda = new Thread(() -> {
            System.out.println("thread runnning using runnable lambda" );
        });
        runnableTaskLamda.start();

        // callable must return something
        Callable<Integer> r1 = () -> {
            System.out.println("thread runnning using callable");
            return 100;
        };


//        r.run();  // just a normal call not multithreading



//        System.out.println(r1.call());  ->  // just a normal call not multithreading


//        Thread callableTask = new Thread(r1);   -> callable can only be done using executor service
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> result = service.submit(r1);
        System.out.println("Result: " + result.get());
        service.shutdown();

    }


}
