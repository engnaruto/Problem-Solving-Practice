package cracking.the.coding.interview.problems;

import data.structures.implementations.linked.list.LinkedList;
import data.structures.implementations.linked.list.Node;

import java.util.HashSet;

/*
    2.1
    Remove Dups: Write code to remove duplicates from an unsorted linked list.
    FOLLOW UP
    How would you solve this problem if a temporary buffer is not allowed?
*/
public class _2_1_RemoveDups {


    /*
        Time: O(N)
        Memory: O(N)
    */
    public static void removeDups(LinkedList list) {
        HashSet<Integer> s = new HashSet<>();
        Node current = list.head;
        s.add(current.data);

        while (current != null && current.next != null) {
            if (s.contains(current.next.data)) {
                current.next = current.next.next;
            } else {
                s.add(current.next.data);
                current = current.next;
            }
        }
    }

    /*
        Time: O(N^2)
        Memory: O(1)
    */
    public static void removeDupsWithoutBuffer(LinkedList list) {
        Node current = list.head;
        Node next;
        while (current.next != null) {
            next = current;
            while (next != null && next.next != null) {
                if (current.data == next.next.data) {
                    next.next = next.next.next;
                }
                next = next.next;
            }
            current = current.next;
        }
    }

    public static void main(String args[]) {

        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(1);

        list.print();
        removeDups(list);
//        removeDupsWithoutBuffer(list);
        list.print();

    }

}
