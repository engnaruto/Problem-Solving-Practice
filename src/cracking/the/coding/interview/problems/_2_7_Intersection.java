package cracking.the.coding.interview.problems;

import data.structures.implementations.linked.list.LinkedList;
import data.structures.implementations.linked.list.Node;

import java.util.HashSet;


/*
    2.7
    Intersection: Given two (singly) linked lists, determine if the two lists intersect.
    Return the intersecting node.

    Note that the intersection is defined based on reference, not value. That is, if the kth
    node of the first linked list is the exact same node (by reference) as the jth node of the second
    linked list, then they are intersecting.
*/

public class _2_7_Intersection {


    /*
         Time: O(l1.length + l2.length)
         Memory: O(max(l1.length, l2.length))
    */

    public static Node intersection(LinkedList l1, LinkedList l2) {

        HashSet<Node> set = new HashSet<>();

        Node node = l1.head;

        while (node != null) {
            set.add(node);
            node = node.next;
        }

        System.out.println(set.toString());

        node = l2.head;

        while (node != null) {
            if (set.contains(node)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }


    /*
         Time: O(l1.length * l2.length)
         Memory: O(1)
    */

    public static Node intersectionWithoutUsingSet(LinkedList l1, LinkedList l2) {
        Node n = l1.head;
        Node nn;

        while (n != null) {
            nn = l2.head;
            while (nn != null) {
                if (n == nn) {
                    return nn;
                }
                nn = nn.next;
            }
            n = n.next;
        }
        return null;
    }


    public static int length(LinkedList list) {
        int counter = 0;
        Node n = list.head;

        while (n != null) {
            counter++;
            n = n.next;
        }
        return counter;
    }

    /*
         Time: O(l1.length + l2.length)
         Memory: O(1)
    */

    public static Node intersectionUsingChoppingList(LinkedList l1, LinkedList l2) {
        int counter1 = length(l1);
        int counter2 = length(l2);

        int diff = counter1 - counter2;

        Node nLong = diff >= 0 ? l1.head : l2.head;
        Node nShort = diff < 0 ? l1.head : l2.head;

        diff = Math.abs(diff);

        while (diff != 0) {
            nLong = nLong.next;
            diff--;
        }

        while (nLong != null) {
            if (nLong == nShort) {
                return nLong;
            }
            nLong = nLong.next;
            nShort = nShort.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        Node x = new Node(9);
        list.add(x);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        LinkedList list2 = new LinkedList();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(3);
        list2.add(2);
        list2.add(x);
        list2.add(1);

        System.out.println(intersection(list, list2));
        System.out.println(intersectionWithoutUsingSet(list, list2));
        System.out.println(intersectionUsingChoppingList(list, list2));
    }


}
