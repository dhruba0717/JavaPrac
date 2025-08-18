package Java8NewFeatures;

import java.util.function.Function;

public class FunctionPractice {


    //method and function is different -> function introduced in java 8+
    public static void main(String[] args) {

        // function is a functional interface with one method that works for us
        // this function takes int and returns int
        Function<Integer, Integer> multiplyBy20 = x -> x*20;
        Function<Integer, Integer> add100 = x -> x+100;
        System.out.println(multiplyBy20.apply(11));

        // andThen method of Function
        System.out.println(multiplyBy20.andThen(add100).apply(3));

    }

}
