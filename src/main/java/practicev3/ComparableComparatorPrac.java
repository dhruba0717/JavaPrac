package practicev3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableComparatorPrac {

    public static void main(String[] args) {
        List<Employee> e = new ArrayList<>();
        e.add(new Employee(1,"Dhruba", 27,70000));
        e.add(new Employee(2,"Shree", 25,90000));
        e.add(new Employee(3,"jhn", 45,85000));
//        Collections.sort(e);   // natural comparing with comparable
//        System.out.println(e);

        // custom sorting
        Comparator<Employee> comparator =
                Comparator.comparing(Employee::getSalary)
                                .reversed()
                                        .thenComparing(Employee::getAge);
        Collections.sort(e,comparator);
        System.out.println(e);
    }
}

class Employee implements Comparable<Employee> {

    private int empId;
    private String name;
    private int age;
    private double salary;

    public Employee(int empId, String name, int age, double salary) {
        this.empId = empId;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return this.age - o.age;
    }
}
