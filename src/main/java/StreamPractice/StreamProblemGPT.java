package StreamPractice;

import com.google.common.collect.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamProblemGPT {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        //Task:
        //Using Java Streams:
        //Filter out names that have less than 5 characters.
        //Convert the remaining names to uppercase
        //Collect the result into a new List<String>.

        List<String> namesAns = names.stream().filter(s -> s.length() >=5).map(String::toUpperCase)
                .toList();
        System.out.println(namesAns) ;

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//        Task:
//
//        Find the sum of all even numbers using Streams.

        System.out.println(numbers.stream().filter(s -> s%2 ==0)
                .reduce(0,Integer::sum));

        List<String> fruits = Arrays.asList("Apple", "Banana", "Avocado", "Blueberry", "Apricot");

        //Count how many strings start with "A".

        System.out.println(fruits.stream().filter(s -> s.startsWith("A")).count());

        List<String> words = Arrays.asList("cat", "elephant", "dog", "hippopotamus", "ant");

//        Find the longest string using Streams.

        System.out.println(words.stream().max(Comparator.comparingInt(String::length)).get());

        List<String> names1 = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

//        Group the names by their length into a Map<Integer, List<String>>.
//        Example output:
//        {
//            3=[Bob, Eve],
//            5=[Alice, David],
//            7=[Charlie]
//        }

        Map<Integer,List<String>> map = names1.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(map);

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        //Task:
        //Partition the numbers into even and odd using Streams.
        //Result should be a Map<Boolean, List<Integer>> where true = even, false = odd.

        Map<Boolean,List<Integer>> map1 = nums.stream().collect(Collectors.partitioningBy(s-> s%2 == 0));
        System.out.println(map1);

        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"),
                Arrays.asList("e")
        );

        //Task:
        //Using Java Streams, flatten this nested list into a single list:
        //["a", "b", "c", "d", "e"]

        List<String> ansNest = nestedList.stream().flatMap(l -> l.stream() ).toList();
        System.out.println(ansNest);

        List<String> words1 = Arrays.asList("cat", "elephant", "dog", "hippopotamus", "ant","hippopotalok");

//        Find all strings that have the maximum length.
//        Output should be a List<String>, because there could be more than one string with the same max length.
//        Example Output (if there were multiple max-length strings):

        System.out.println(words1.stream().filter(s ->
                s.length() == words1.stream().max(Comparator.comparing(String::length)).get().length()).toList());

        List<String> words2 = Arrays.asList("aa", "aaa", "aaaa", "aaaaa", "aaaaaaaa", "giraaaaaaaaaaffe");

        //Find the top 3 longest strings in the list.Collect them into a List<String>, sorted from longest to shortest.

//        System.out.println(words2.stream().sorted(Comparator.comparingInt(String::length).reversed()).skip(3).toList());
        System.out.println(words2.stream().sorted(Comparator.comparingInt(String::length)).skip(3).toList());


        List<Integer> nums1 = Arrays.asList(1, 2, 3, 4, 5, 6);

        // sum of square of even nums

        System.out.println(nums1.stream().filter( i -> i%2 == 0).map( i -> i*i).reduce(0,Integer::sum));


        String str = "swiss";

        //Find the first non-repeated character in the string using Streams.
        //If all characters repeat, return a placeholder like '-'.

        // to work with character array use this process -> first convert to chars (unicode value of char i int stream) then map
        // unicode values to char aobject the use stream
        Map<Character, Long> freqMap = str.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        char firstNonRepeated = str.chars()
                .mapToObj(c -> (char)c)
                .filter(c -> freqMap.get(c) == 1)
                .findFirst()
                .orElse('-');

        System.out.println(firstNonRepeated);

        List<Integer> nums3 = Arrays.asList(3, 9, 12, 4, 15, 18, 21);
//        Using Streams, find the first even number greater than 10.
//        If none exist, return -1.
        System.out.println(nums3.stream().filter(i -> i%2 == 0 && i>10).findFirst().orElse(-1));


        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );

        System.out.println(listOfLists.stream().flatMap(l -> l.stream()).toList());
        List<Employee1> employees = Arrays.asList(
                new Employee1("Alice", "IT", 80000),
                new Employee1("Bob", "HR", 50000),
                new Employee1("Charlie", "IT", 95000),
                new Employee1("David", "Finance", 70000),
                new Employee1("Eve", "HR", 55000)
        );

        // Find the average salary per department using Streams.
        System.out.println(employees.stream().
                collect(Collectors.groupingBy(Employee1::getDepartment,Collectors.averagingDouble(Employee1::getSalary))));

        //Find the highest-paid employee in each department and store the result in a Map<String, Employee>
        //(where the key = department name, and value = the top-paid employee object).

        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee1::getDepartment,
                                Collectors.maxBy(Comparator.comparingDouble(Employee1::getSalary))
                        ))
        );

    }
}

class Employee1 {
    String name;
    String department;
    double salary;

    public Employee1(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    // getters
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}
