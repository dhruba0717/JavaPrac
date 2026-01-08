package StreamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// filter - filter out things
// map - do something

public class StreamProblems {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Double> doubles = Arrays.asList(1.0,2.0,3.0,4.0,5.0);

        // 1. Find the sum of all even numbers in a list of integers.

        System.out.println(nums.stream()
                .filter(i -> i%2 ==0 )
                .mapToInt(Integer::intValue)
                .sum());

        List<String> names = Arrays.asList("Dhrubaj","raj","ruma","shree","bapi");
        // 2. Find and print the count of strings that have length greater than 4.
            // to count -> use count
        System.out.println(names.stream()
                .filter(s -> s.length() > 4)
                .toList()
        );

        // 3. Implement a function that takes a list of integers as input and returns a new list containing the square of each element.
        System.out.println(nums.stream()
                .map(n -> n*n)
                .toList()
        );

        // 4. Find the maximum element in a list of integers.
        System.out.println(nums.stream()
                .max((o1, o2) -> o1-o2).get()
        );

        // or

        System.out.println(nums.stream()
                .mapToInt(Integer::intValue)
                .min().getAsInt()
        );

        //5. Concatenate all the strings in a list into a single string.

        System.out.println(names.stream()
                .reduce("", (a, b) -> a + b)
        );

        // 6. Convert each string to uppercase and then sort them in alphabetical order.

        System.out.println(names.stream().map(String::toUpperCase).sorted().collect(Collectors.toList()));

        // 7. Find the average of all the numbers in a list of doubles using Streams.
        System.out.println(doubles.stream()
                .mapToDouble(Double::doubleValue)
                .average().getAsDouble()
        );







    }
}
