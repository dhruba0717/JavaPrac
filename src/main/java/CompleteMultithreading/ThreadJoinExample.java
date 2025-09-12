package CompleteMultithreading;

public class ThreadJoinExample {


    // join used when we want explicitly for one thread to end for other to start
    public static void main(String[] args) {
        MyThreadSleep t1 = new MyThreadSleep();
        MyThreadSleep t2 = new MyThreadSleep();

        t1.start(); // Start first thread
        try {
            t1.join(); // Main thread waits until t1 finishes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start(); // Starts only after t1 is done
    }

}

class MyThreadSleep extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " - Count: " + i);
            try {
                Thread.sleep(500); // Sleep for half a second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

