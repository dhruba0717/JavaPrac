package practicev3;

public class ThreadPrintOddEven {

    private static final Object lock = new Object();
    private static int number = 1;
    private static final int MAX = 100;

    public static void main(String[] args) {

        Thread oddThread = new Thread(() -> {
            synchronized (lock) {
                while (number < MAX) {
                    while (number % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(number);
                    number++;
                    lock.notify();
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            synchronized (lock) {
                while (number < MAX) {
                    while (number % 2 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(number);
                    number++;
                    lock.notify();
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
