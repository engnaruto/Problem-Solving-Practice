package cracking.the.coding.interview.problems;


import data.structures.implementations.linked.list.LinkedList;
import data.structures.implementations.linked.list.Node;

import java.util.HashSet;

/*
    2.8
    Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
    beginning of the loop.

    DEFINITION
    Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
    as to make a loop in the linked list.

    EXAMPLE
    Input: A -> B -> C -> D -> E -> C [the same C as earlier]
    Output: C

*/
public class _2_8_LoopDetection {


   /*
        Time: O(N)
        Memory: O(N)
   */

    public static Node loopDetection(LinkedList list) {
        HashSet<Node> set = new HashSet<>();

        Node node = list.head;
        while (node != null) {
            if (set.contains(node)) {
                return node;
            }
            set.add(node);
            node = node.next;
        }
        return null;
    }

    /*
        Time: O(LOOP_SIZE + K) = O(N)
        Memory: O(1)
   */
    public static Node loopDetectionUsingRunnerNode(LinkedList list) {
        Node slow = list.head;
        Node fast = slow;

        while (slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }

        slow = list.head;

        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Node x = new Node(90);
        list.add(x);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(x);

        System.out.println(loopDetection(list));
        System.out.println(loopDetectionUsingRunnerNode(list));


    }
}
