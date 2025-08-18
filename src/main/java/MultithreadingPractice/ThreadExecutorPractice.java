package MultithreadingPractice;

import java.util.concurrent.*;

public class ThreadExecutorPractice {
    // Thread executor - tasks performed by application can be assigned to many threads we can specify the
    // number of threads we want
    public static void main(String[] args) {
        // Single thread executor - only one thread will pick tasks
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            final int taskId = 1;
            singleThreadExecutor.execute(() -> {
                System.out.println("Single thread task : "+taskId+" executed by "+Thread.currentThread().getName());
            });
        }

        // shutdown after execution -> after shutdown it will not pick new tasks

        // Fixed thread executor - we will specify hpw many threads will be required to do tasks
        ExecutorService fixedThreadExecutor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            final int taskId = 1;
            fixedThreadExecutor.execute(() -> {
                System.out.println("Fixed thread task : "+taskId+" executed by "+Thread.currentThread().getName());
            });
        }
        fixedThreadExecutor.shutdown();

        // Cached thread executor - dynamic number of threads
        ExecutorService cachedThreadExecutor = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            final int taskId = 1;
            cachedThreadExecutor.execute(() -> {
                System.out.println("Cached thread task : "+taskId+" executed by "+Thread.currentThread().getName());
            });
        }
        cachedThreadExecutor.shutdown();


        // scheduled Thread pool - we can add delay to thread
        // Thread pool executor

        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(1,5,0L,
                TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(2));

        // we pass the pool size , maxmimum thread , keep alive etc - and LinkedBlockingQueue
        // when pool size 1 ius exceeded and queue size execeeded it will create new thread automatically
        // once task done it will delete them after keep alive time


    }


}
