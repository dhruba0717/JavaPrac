package MultithreadingPractice;
import java.util.concurrent.*;

public class ScheduledThreadExample {
    public static void main(String[] args) {

        // Scheduled Thread Pool - allows delayed and periodic task execution
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(2);

        // 1. Schedule a one-time task after a delay
        scheduledExecutor.schedule(() -> {
            System.out.println("Scheduled one-time task executed by " +
                    Thread.currentThread().getName());
        }, 2, TimeUnit.SECONDS);

        // 2. Schedule a task at a fixed rate (start every X seconds)
        scheduledExecutor.scheduleAtFixedRate(() -> {
            System.out.println("Fixed-rate task executed by " +
                    Thread.currentThread().getName() + " at " + System.currentTimeMillis());
        }, 1, 3, TimeUnit.SECONDS);

        // 3. Schedule a task with fixed delay (wait after completion)
        scheduledExecutor.scheduleWithFixedDelay(() -> {
            System.out.println("Fixed-delay task executed by " +
                    Thread.currentThread().getName() + " at " + System.currentTimeMillis());
        }, 1, 4, TimeUnit.SECONDS);

        // Let it run for some time before shutting down
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduledExecutor.shutdown();
    }
}

