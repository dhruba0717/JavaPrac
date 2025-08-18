package Java8NewFeatures;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicatePractice {

    // predicate is a func interface with only one boolean method - test

    public static void main(String[] args) {
        Predicate<Integer> isEven = x -> x%2 == 0;
        Predicate<String> isStartingWithA = s -> s.startsWith("A");
        Predicate<String> isEndWitht = s -> s.endsWith("t");
        // joining 2 predicates
        Predicate<String> startWIthAEndWithT = isStartingWithA.and(isEndWitht);
        System.out.println(isEven.test(42));
        System.out.println(isStartingWithA.test("Aryan"));
        System.out.println(startWIthAEndWithT.test("Ankit"));
        System.out.println(startWIthAEndWithT.test("TTnkit"));

        // Bi predicate to take 2 arguments
//        BiPredicate<Integer,Integer>

    }




}
