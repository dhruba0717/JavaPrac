package MultithreadingPractice;

public class OddEvenWithThread {
    private static final Object lock = new Object();
    private static boolean isOddTurn = true;
    public static void main(String[] args) {
        Runnable oddThread = () -> {
            for (int i = 1; i < 100; i+=2) {
                synchronized (lock){
                    while (!isOddTurn){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("odd -> "+i);
                    isOddTurn = false;
                    lock.notify();
                }

            }
        };

        Runnable evenThread = () -> {
            for (int i = 2; i < 100; i+=2) {
                synchronized (lock){
                    while (isOddTurn){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("even -> "+i);
                    isOddTurn = true;
                    lock.notify();
                }

            }
        };

        new Thread(oddThread).start();
        new Thread(evenThread).start();
    }

}
