package StreamPractice;

import java.util.*;

public class ComparatorComparablePractice {
    public static void main(String[] args) {
        List<Student> l = new ArrayList<>();
        l.add(new Student(2,"Shree",87.56));
        l.add(new Student(1,"Dhruba",45.56));
        l.add(new Student(3,"Joj",99.89));

        Collections.sort(l);
        System.out.println(l);

        // to sort with comparator
        Comparator<Student> comparator = Comparator.comparing(o -> o.marks);

    }
}

class Student implements Comparable<Student>{
    int id;
    String name;
    double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }


    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }
}
