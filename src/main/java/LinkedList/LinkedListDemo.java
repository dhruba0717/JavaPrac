package LinkedList;

public class LinkedListDemo {

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        printlist(head);

        head = reverseLL(head);
        printlist(head);

        
    }

    private static Node reverseLL(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current!=null){      // current 10
            next = current.next;   // next 20
            current.next = prev;    // current.next was 10.next = 20 but now 10.next = null (prev)
            prev = current;         // prev = 10
            current = next;         // current 20
        }
        return prev;
    }

    private static void printlist(Node head) {

        Node current = head;
        while (current!=null){
            System.out.println(current.data +" -> ");
            current = current.next;
        }
        System.out.println("null");

    }

}

class Node{

    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }

}
