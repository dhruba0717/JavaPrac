package CompleteMultithreading;

public class SynchronizedExample {

    int c = 0;
    public synchronized void increment() {  // synchronized to avoid race condition
        c++;
    }

    // if a shared resource is used by both Thread -> Race condition
    public static void main(String[] args) throws InterruptedException {
        SynchronizedExample example = new SynchronizedExample();
        IncrementThread t1 = new IncrementThread(example);
        IncrementThread t2 = new IncrementThread(example);

        t1.start();
        t2.start();


        // waiting for both to finish
        t1.join();
        t2.join();

        System.out.println("Value of c after both incremented 1000 times "+ example.c);
    }

}

class IncrementThread extends Thread{
    private final SynchronizedExample example;

    public IncrementThread(SynchronizedExample example) {
        this.example = example;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 1000 ; i++) {
            example.increment();
        }
    }
}
