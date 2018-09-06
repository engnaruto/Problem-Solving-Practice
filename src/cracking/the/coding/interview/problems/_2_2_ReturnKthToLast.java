package cracking.the.coding.interview.problems;

import data.structures.implementations.hash.map.Pair;
import data.structures.implementations.linked.list.LinkedList;
import data.structures.implementations.linked.list.Node;

import java.util.HashMap;


/*
    2.2
    Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
*/


public class _2_2_ReturnKthToLast {


    /*
        Time: O(N)
        Memory: O(1)
    */

    public static int returnKthToLast(LinkedList list, int k) {
        Node node = list.head;
        Node last = list.head;
        int counter = 0;
        while (last != null) {
            last = last.next;
            counter++;
        }
        int index = counter - k;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.data;

    }

    /*
        Time: O(N) but it doesn't have the additional iteration
        Memory: O(N)
    */

    public static int returnKthToLastUsingHashMap(LinkedList list, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        Node current = list.head;
        int counter = 1;

        while (current != null) {
            map.put(counter++, current.data);
            current = current.next;
        }

        int index = counter - k;
        return map.get(index);
    }


    /*
        Time: O(N)
        Memory: O(N) because of the stack of recursion
    */

    public static int returnKthToLastRecursive(Node node, Pair p, int i, int k) {
        if (node == null) {
            return 0;
        }

        p.key++;
        int n = returnKthToLastRecursive(node.next, p, i + 1, k);
//        System.out.println("*** p: " + p.key + ", i: " + i + ", p-i: " + (p.key - i));


        if (p.key - i == k) {
            return node.data;
        }

        return n;

    }

     /*
        Time: O(N)
        Memory: O(1)
    */

    public static int returnKthToLastUsingOneIteration(LinkedList list, int k) {
        Node p1 = list.head;
        Node p2 = list.head;

        int counter = 1;

        while (counter != k) {
            if (p1.next == null) {
                return -1;
            }
            p1 = p1.next;
            counter++;
        }

        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2.data;
    }


    public static void main(String[] args) {
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
        int k = 2;
        System.out.println(returnKthToLast(list, k));
        System.out.println(returnKthToLastUsingHashMap(list, k));
        System.out.println(returnKthToLastRecursive(list.head, new Pair(1, 0), 1, k));
        System.out.println(returnKthToLastUsingOneIteration(list, k));

    }


}
