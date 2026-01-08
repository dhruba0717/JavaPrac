package MultithreadingPractice;

public class PracAll3oddeven {

    // print odd even from 1-10000 (in order) using two threads and see time takes
   // odd even thread with maintaining order by lock wait notify





    // without any thread - 80 ms
//    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 10000; i++) {
//            System.out.println(i);
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("Time Taken: " + (end - start) + " ms"); // 32 ms
//    }

    //with odd even thread - 109ms
//    public static void main(String[] args) throws InterruptedException {
//        long start = System.currentTimeMillis();
//        Thread odd = new Thread(() ->
//        {
//            for (int i = 1; i < 10000; i+=2) {
//                System.out.println(i);
//            }
//        }
//                );
//        Thread even = new Thread(() ->
//        {
//            for (int i =0; i < 10000; i+=2) {
//                System.out.println(i);
//            }
//        }
//        );
//        odd.start();
//        even.start();
//        odd.join();
//        even.join();
//        long end = System.currentTimeMillis();
//        System.out.println("Time Taken: " + (end - start) + " ms");
//    }



}
