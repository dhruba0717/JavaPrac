package Java8NewFeatures;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamPractice {

    public static void main(String[] args) {

        // Stream is also a func interface which works with collection makes easy operations
        // source / intermediate operation / terminal operation
        // func programming

        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7);

        // write to count num of even
        // traditional method
//        int c = 0;
//        for (int i: nums){
//            if(i%2 == 0){
//                c++;
//            }
//        }
//
//        System.out.println(c);



        //using stream
        System.out.println(nums.stream().filter(x -> x%2 == 0).count());

        List<Integer> list = Arrays.asList(5, 2, 9, 1, 6);


        // squaring and sorting
        // use map to take something and perform operation
        System.out.println(list.stream().map(x -> x*x).sorted().toList());

        // Summing values
        // use reduce becuase only oe value return
        // Integer::sum -> Binary operator
        System.out.println(list.stream().reduce(Integer::sum).get());


    }


}
