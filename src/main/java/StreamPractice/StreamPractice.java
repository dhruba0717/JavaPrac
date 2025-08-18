package StreamPractice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {


    // inside stream write lambda expression -> has predicate connsumer etc
    // stream works onn list
    public static void main(String[] args) {

        List<Employee> employees = EmployeeDataBase.getAllEmployees();
        
        // forEach - iterates over a list (takes lambda exp or method reference)
//        employees.forEach(e-> System.out.println(e.getName() +" : "+e.getSalary()));

        // print those employees only whose deparment is Development
        // filter takes predicate - true false
        // collect -> collects into list set map
        List<Employee> devList = employees.stream()
                        .filter(e -> e.getDept().equals("Development") && e.getSalary() > 80000)
                        .collect(Collectors.toList());
        Set<Employee> devListSet = employees.stream()
                .filter(e -> e.getDept().equals("Development") && e.getSalary() > 80000)
                .collect(Collectors.toSet());
        // toMap -> collect only name and id
        Map<Integer,String> employeeMap = employees.stream()
                .filter(e -> e.getDept().equals("Development") && e.getSalary() > 80000)
                        .collect(Collectors.toMap(Employee::getId, Employee::getName));
//        System.out.println(employeeMap);


        // print all the departments
        // map : takes function and does something
        List<String> deptList = employees.stream()
                .map(Employee::getDept)
                .distinct()
                .collect(Collectors.toList());

//        System.out.println(deptList);

        // print all the project Names - nested class
//       List<Stream<String>> employeeProjects =
//               employees.stream()
//                .map(e -> e.getProjects()
//                        .stream().map(p -> p.getName()))
//                        .collect(Collectors.toList());
//
//        System.out.println(employeeProjects);

        // whenever a class there inside there another class (nested class)
        // use flatMap dont use the above method

        List<String> projectNames = employees.stream()
                .flatMap(e -> e.getProjects().stream())
                .map(p -> p.getName())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(projectNames);

        // print employee sort on basis of salary
        // sorted (takes comparatorr where we can pass on whats basis t sort)
        System.out.println(employees.stream()
                .sorted(Comparator.comparing(e -> e.getSalary()))
                .collect(Collectors.toList()));

        // reverseOrder

        System.out.println(employees.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Employee::getSalary)))
                .collect(Collectors.toList())


        );


        // max min print employee with maxSalary
        System.out.println(employees.stream()
                .max(Comparator.comparing(Employee::getSalary)));
        System.out.println(employees.stream()
                .min(Comparator.comparing(Employee::getSalary)));


        // groupingBy -> returns map takes function
        // group emoloyee based on gender
        Map<String, List<Employee>> employeeAndGender = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender));
        System.out.println(employeeAndGender);

        // this returns gender -> lsi of employee
        // if we want gender and name then
        // Collectors.mapping
        Map<String, List<String>> employeeNameAndGender = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.mapping(Employee::getName,Collectors.toList())
                        ));
        System.out.println(employeeNameAndGender);

        // if we want to see how many male or female
        // Collectors.counting()
        Map<String, Long> employeeNameAndGenderCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.counting()));
        System.out.println(employeeNameAndGenderCount);



        // find first -> returns optional
        // findthe first employee who is from development
        //  throw exception if not found
        Optional<Employee> developmentEmployeeFirst = employees.stream()
                .filter(e -> e.getDept().equals("Development"))
                .findFirst();

        // returns optional so can be null -> check through ifPresent so that no null pointer exception
        developmentEmployeeFirst.ifPresent(e -> System.out.println(e.getName()));

        // trhow exception if not present
        Employee developmentEmployeeFirstException = employees.stream()
                .filter(e -> e.getDept().equals("Development"))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        System.out.println(developmentEmployeeFirstException);

        // findAny -> same as find first
        // anyMatch , allMatch , noneMatch -> takes predicate

        boolean isAnyDev = employees.stream()
                .anyMatch(e -> e.getDept().equals("Development"));
        System.out.println(isAnyDev);


        // limit()
        // top 3 highest paid employee

        List<String> top3Employees = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(e -> e.getName())
                .limit(3).toList();
        System.out.println(top3Employees);
//        top3Employees.forEach(e -> System.out.println(e.getName() + " "+e.getSalary()));

        //skip(5) -> skip first 5 elements -> used for pagination

    }
}
