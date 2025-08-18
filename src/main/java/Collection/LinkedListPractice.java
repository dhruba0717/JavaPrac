package Collection;

import java.util.LinkedList;

public class LinkedListPractice {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5);
        linkedList.add(2);
        linkedList.add(7);

        linkedList.addLast(33);     // o(1) no need to shift
        linkedList.addFirst(11);

        System.out.println(linkedList.get(4));    // has to iterate all elenents o(1)

        System.out.println(linkedList);


        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList);





    }





}
