package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListPractice {

    public static void main(String[] args) {

        // when size known
        int[] arr = new int[5];

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        // adds 4 at 2nd index
        arrayList.add(2,4);
        //modifies second element tp 22
        arrayList.set(1,22);
        System.out.println(arrayList.toString());
        System.out.println(arrayList.contains(5));

        // remove index
        arrayList.remove(3);
        System.out.println(arrayList.toString());
        // removes value 22 by making it an object
        arrayList.remove(Integer.valueOf(22));
        System.out.println(arrayList.toString());
        System.out.println(arrayList.getClass());

        List<String> list1 = Arrays.asList("hello","dhhy","zhfy"); // returns fixed size list
        System.out.println(list1.getClass());
//        list1.add("dhruu");    doesnt work as list is immutble and we cannot add delete
        list1.set(1,"chat");  // only update works
        System.out.println(list1);

        List<String> list2 = List.of("hello","dhhy","zhfy");  // returns an unmodifiable list
        System.out.println(list2.getClass());
//        list2.set(1,"chat");    // wont work as its unmodifiable list
        System.out.println(list2.toString());

        Object[] list2Obj = list2.toArray();
        System.out.println(list2Obj.getClass());
        System.out.println(Arrays.toString(list2Obj));


        Collections.sort(arrayList);     // sort based on comparator
        System.out.println(arrayList);


    }


}
