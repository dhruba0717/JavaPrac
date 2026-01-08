package MultithreadingPractice;

import java.util.concurrent.*;
import java.util.List;

public class CompletableFutureWithFixedExecutorService {

    // Simulated API calls
    private static String fetchUserDetails() {
        sleep(1000); // simulate API latency
        return "User{name='Ronaldo'}";
    }

    private static String fetchOrderDetails() {
        sleep(1500);
        return "Order{id=101, amount=5000}";
    }

    private static String fetchPaymentDetails() {
        sleep(1200);
        return "Payment{status='SUCCESS'}";
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {

        // 1️⃣ Create custom thread pool
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            // 2️⃣ Fire all 3 API calls in parallel
            CompletableFuture<String> userFuture =
                    CompletableFuture.supplyAsync(CompletableFutureWithFixedExecutorService::fetchUserDetails, executor);

            CompletableFuture<String> orderFuture =
                    CompletableFuture.supplyAsync(CompletableFutureWithFixedExecutorService::fetchOrderDetails, executor);

            CompletableFuture<String> paymentFuture =
                    CompletableFuture.supplyAsync(CompletableFutureWithFixedExecutorService::fetchPaymentDetails, executor);

            // 3️⃣ Wait for all of them using allOf
            CompletableFuture<Void> allFutures =
                    CompletableFuture.allOf(userFuture, orderFuture, paymentFuture);

            // 4️⃣ When all are done, combine results
            CompletableFuture<String> combinedResult = allFutures.thenApply(v -> {
                String user = userFuture.join();
                String order = orderFuture.join();
                String payment = paymentFuture.join();

                return """
                        Combined Response:
                        %s
                        %s
                        %s
                        """.formatted(user, order, payment);
            });

            // 5️⃣ Get final result (blocking)
            String result = combinedResult.join();
            System.out.println(result);

        } finally {
            executor.shutdown();
        }
    }
}
