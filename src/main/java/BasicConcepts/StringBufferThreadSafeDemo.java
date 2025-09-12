package BasicConcepts;

public class StringBufferThreadSafeDemo {

    public static void main(String[] args) throws InterruptedException {
        StringBuffer sb = new StringBuffer("Start");

        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                sb.append("X"); // synchronized → thread-safe
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final StringBuffer: " + sb);  // always 10x
    }
    }
