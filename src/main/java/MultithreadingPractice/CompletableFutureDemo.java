package MultithreadingPractice;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) {

        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> {
                            // Step 1: Run async task & return value
                            System.out.println("Fetching user...");
                            return "dhrubajoyti";
                        })
                        .thenApply(name -> {
                            // Step 2: Transform result
                            return name.toUpperCase();
                        })
                        .thenCombine(
                                CompletableFuture.supplyAsync(() -> " from India"),
                                (name, location) -> name + location // combine results
                        )
                        .exceptionally(ex -> {
                            // Step 3: Handle errors (if any)
                            System.out.println("Error: " + ex.getMessage());
                            return "Unknown User";
                        });

        // Step 4: Wait & print output
        System.out.println("Result: " + future.join());
    }
}
