package cracking.the.coding.interview.problems;

import data.structures.implementations.linked.list.LinkedList;
import data.structures.implementations.linked.list.Node;



/*
    2.3
    Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
    the first and last node, not necessarily the exact middle) of a singly linked list,
    given only access to that node.

    EXAMPLE
    Input: the node c from the linked list a -> b-> c -> d -> e -> f
    Result: nothing is returned, but the new linked list looks like a -> b -> d -> e -> f
*/

public class _2_3_DeleteMiddleNode {

    /*
        Time: O(1)
        Memory: O(1)
    */

    public static void deleteMiddleNode(Node n) {
        n.data = n.next.data;
        n.next = n.next.next;
    }


    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.print();

        Node n = list.head;
        int k = 3;

        for (int i = 1; i < k; i++) {
            n = n.next;
        }

        deleteMiddleNode(n);

        list.print();
    }
}
