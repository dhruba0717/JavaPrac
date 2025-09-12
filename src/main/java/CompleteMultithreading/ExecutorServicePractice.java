package CompleteMultithreading;

import java.util.concurrent.*;

// create pools of threads to do tasks
//
public class ExecutorServicePractice {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        // taking fixed pool of 3 threads to do tasks
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            executor.submit(() -> {
                long result = factorial(finalI);
                System.out.println(result);
            });

        }
        executor.shutdown();
        try {

            if (!executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
                System.out.println("Timeout reached before termination");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // waitinf for executor termination before printing this
        System.out.println("Total time " + (System.currentTimeMillis() - startTime));


        // FUTURE
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> future = executorService.submit(() -> System.out.println("Hello")); // runnable parameter
        System.out.println(future.get()); // blocking call ( null )
        if(future.isDone()){
            System.out.println("Task is done !");
        }
        executorService.shutdown();
    }

    private static long factorial(int n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

}
