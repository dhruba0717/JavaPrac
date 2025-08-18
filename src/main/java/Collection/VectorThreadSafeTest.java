package Collection;

import java.util.ArrayList;
import java.util.Vector;

public class VectorThreadSafeTest {

    public static void main(String[] args) throws InterruptedException {


        // in case of array list both trying to add at same time hence incosistent
//        ArrayList<Integer> list = new ArrayList<>();
        Vector<Integer> list = new Vector<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(list.size());




    }


}
