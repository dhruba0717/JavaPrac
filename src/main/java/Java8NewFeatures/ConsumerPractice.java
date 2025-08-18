package Java8NewFeatures;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerPractice {

    // Consumer is a func interface takes but does not return
    // void accept(T t);
    public static void main(String[] args) {

        // write a consumer to print from 1 to n


        Consumer<Integer> printNums = n -> {
            for (int i = 0; i < n; i++) {
                System.out.println(i);
            }
        };

        printNums.accept(20);

        BiConsumer<Integer, Integer> powerOf = (a,b) -> System.out.println(Math.pow(a,b));
        powerOf.accept(3,2);

    }




}



