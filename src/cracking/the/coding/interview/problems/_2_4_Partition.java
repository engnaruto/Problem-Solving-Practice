package cracking.the.coding.interview.problems;

import data.structures.implementations.linked.list.LinkedList;
import data.structures.implementations.linked.list.Node;


/*
    2.4
    Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
    before all nodes greater than or equal to x. If x is contained within the list the values of x only need
    to be after the elements less than x (see below). The partition element x can appear anywhere in the
    "right partition"; it does not need to appear between the left and right partitions.

    EXAMPLE
    Input:  3 -> 5 -> 8 -> 5  -> 10 -> 2 -> 1 [partition = 5]
    Output: 3 -> 1 -> 2 -> 10 -> 5  -> 5 -> 8
*/

public class _2_4_Partition {

    private static void swap(Node p1, Node p2) {
        int tmp = p1.data;
        p1.data = p2.data;
        p2.data = tmp;
    }

    /*
        Time: O(N^2)
        Memory: O(1)
    */
    public static void partition(LinkedList list, int k) {
        Node p1 = list.head;
        Node p2;
        while (p1 != null && p1.next != null) {

            if (p1.data < k) {
                p1 = p1.next;
                continue;
            }
            p2 = p1.next;
            while (p2 != null) {
                if (p1.data >= k && p2.data < k) {
                    swap(p1, p2);
                    break;
                }
                p2 = p2.next;
            }
            p1 = p1.next;
        }
    }


    /*
        Time: O(N)
        Memory: O(N)
    */
    public static void partitionUsingTwoLinkedLists(LinkedList list, int k) {
        LinkedList less = new LinkedList();
        LinkedList bigger = new LinkedList();

        Node p = list.head;

        while (p != null) {
            if (p.data < k) {
                less.add(p.data);
            } else {
                bigger.add(p.data);
            }
            p = p.next;
        }

        p = list.head;

        Node n = less.head;

        while (n != null) {
            p.data = n.data;
            n = n.next;
            p = p.next;
        }

        n = bigger.head;
        while (n != null) {
            p.data = n.data;
            n = n.next;
            p = p.next;
        }
    }


    /*
        Time: O(N)
        Memory: O(N)
    */

    public static void partitionUsingHeadAndTailNodes(LinkedList list, int k) {
        LinkedList l = new LinkedList();

        Node p = list.head;

        while (p != null) {
            if (p.data < k) {
                l.addToHead(p.data);
            } else {
                l.add(p.data);
            }
            p = p.next;
        }
        list.head = l.head;
    }


    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.add(3);
        list.add(5);
        list.add(8);
        list.add(5);
        list.add(10);
        list.add(1);
        list.add(2);

        list.print();

//        partition(list, 5);
//        partitionUsingTwoLinkedLists(list, 5);
        partitionUsingHeadAndTailNodes(list, 5);

        list.print();
    }
}
