package Collection;

import java.util.ArrayList;
import java.util.Comparator;

public class ComparatorPracticeLambda {


    public static void main(String[] args) {
        ArrayList<Integer> arrInt = new ArrayList<>();
        arrInt.add(6);
        arrInt.add(3);
        arrInt.add(7);
        arrInt.add(1);

        // does ascending
//        arrInt.sort(null);
        // for descending use lambda write custom logic
        arrInt.sort((a,b) -> b -a);
        System.out.println(arrInt.toString());

        ArrayList<String> arrString = new ArrayList<>();
        arrString.add("Dhruba");
        arrString.add("Joytic");
        arrString.add("srijaniBBhat");
        arrString.add("fgd");

//        arrString.sort(null);        Lexographoc Order sorting

        // if want to sort based on length of string write Logic in lambda
        arrString.sort((o1, o2) -> o2.length() - o1.length());
        System.out.println(arrString.toString());


    }


}
