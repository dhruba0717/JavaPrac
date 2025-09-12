package CompleteMultithreading;

public class YieldJoinExample {

    public static void main(String[] args) {
        MyThreadYield t1 = new MyThreadYield();
        MyThreadYield t2 = new MyThreadYield();

        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.start();
        t2.start();
    }

}

class MyThreadYield extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " - Count: " + i);

            // Hint to scheduler to give other threads a chance
            Thread.yield();
        }
    }
}
