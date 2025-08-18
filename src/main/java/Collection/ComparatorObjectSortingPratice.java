package Collection;

import java.util.ArrayList;
import java.util.Comparator;

class Student{

    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name "+name+" age "+age;
    }
}

class StudentComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
    }

}


public class ComparatorObjectSortingPratice {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Dhrubajoyti", 26));
        students.add(new Student("Srijani", 24));
        students.add(new Student("Senjuti", 24));
        students.add(new Student("Trrr", 62));
        students.add(new Student("Zrrr", 62));


//        students.sort(null);    doesnt know how to sort so write logic
        // write logic to sort based on less age
//        students.sort(new StudentComparator());
//        for(Student s: students){
//            System.out.println(s.toString());
//        }


        // write logic using lambda to sort based on Name length - small name first
//        students.sort((a,b) -> a.name.length() - b.name.length());
//        for(Student s: students){
//            System.out.println(s.toString());
//        }

        // write same logic using Collection comparing - age descending then if age same then name asending

        students.sort(Comparator.comparing(Student::getAge).reversed().thenComparing(Student::getName));
        for(Student s: students){
            System.out.println(s.toString());
        }
    }




}
