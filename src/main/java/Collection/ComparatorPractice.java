package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class CustomDescending implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        // if -ve then o1,o2
        // if 0 then same
        // if +ve then o2 ,o1

        // as we need descending so o2 should be before o1 so +ve
        return o2 - o1;
    }
}

class CustomSizeString implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        // length of o2 if big shoould come first
        return o2.length() - o1.length();
    }
}

public class ComparatorPractice {


    public static void main(String[] args) {
        ArrayList<Integer> arrInt = new ArrayList<>();
        arrInt.add(6);
        arrInt.add(3);
        arrInt.add(7);
        arrInt.add(1);

        // does ascending
//        arrInt.sort(null);
        // for descending use comparatot write custom logic
        arrInt.sort(new CustomDescending());
        System.out.println(arrInt.toString());

        ArrayList<String> arrString = new ArrayList<>();
        arrString.add("Dhruba");
        arrString.add("Joytic");
        arrString.add("srijaniBBhat");
        arrString.add("fgd");

//        arrString.sort(null);        Lexographoc Order sorting

        // if want to sort based on length of string write Logic
        arrString.sort(new CustomSizeString());
        System.out.println(arrString.toString());


    }


}
