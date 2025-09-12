package BasicConcepts;

public class StringBuilderNonThreadSafeDemo {

    public static void main(String[] args) throws InterruptedException {
        StringBuilder sb = new StringBuilder("Start");

        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                sb.append("X"); // not threadSafe
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final StringBuilder: " + sb);     // inconsistentResult
    }
    }
