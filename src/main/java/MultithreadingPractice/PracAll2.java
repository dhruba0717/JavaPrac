package MultithreadingPractice;

import java.util.concurrent.*;

// executorService
// practice callable / future / completable future
// runnable only when run something not get (for get use callable
public class PracAll2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // runnable
        Runnable r = new Thread(() -> System.out.println("do something"));
        // callable doesnt work with thread only work with executor service
//        Callable<Integer> c = new Thread(() -> System.out.println("do something"));
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Integer> task = () -> {
            System.out.println(Thread.currentThread().getName() + " is executing...");
            int sum = 0;
            for (int i = 1; i <= 5; i++) {
                sum += i;
            }
            return sum;  // returning value
        };

        Future<Integer> future = executor.submit(task);

        System.out.println("Doing other work in main thread...");

        Integer result = future.get();  // waits for completion and gets result
        System.out.println("Result = " + result);

        executor.shutdown();

    }

}
