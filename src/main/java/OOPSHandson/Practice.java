package OOPSHandson;

public class Practice {
    private static final Object lock = new Object();
    static boolean isOddTurn = true;
    public static void main(String[] args) {
        // print even odd with thread
        Thread even = new Thread(() -> {
            synchronized (lock){
                while (!isOddTurn){
                    for (int i = 0; i < 100; i += 2) {
                        System.out.println("Even -> " + i);
                    }
                }
            }


        });

        Thread odd = new Thread(() -> {
            for (int i = 1; i < 100; i+=2) {
                System.out.println("odd ->"+i);
            }
        });

        even.start();
        odd.start();


    }

}
