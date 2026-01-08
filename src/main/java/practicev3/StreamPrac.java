package practicev3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPrac {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(5, 2, 8, 3, 1, 6);

        System.out.println(nums.stream()
                .filter(i -> i%2==0)
                        .sorted()
                .toList());

        List<String> s  = Arrays.asList("Apple", "banana", "Avocado", "apricot", "Berry");
        System.out.println(s.stream()
                .filter(i -> i.toLowerCase().startsWith("a  "))
                .count()
        );

        List<Integer> evens = IntStream.iterate(2, n -> n+2 )
                .limit(5)
                .boxed()
                .toList();
        System.out.println(evens);

        List<Integer> odds = IntStream.iterate(1, n -> n+2 )
                .limit(5)
                .boxed()
                .toList();
        System.out.println(odds);

    }


}
