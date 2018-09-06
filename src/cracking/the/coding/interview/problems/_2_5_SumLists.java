package cracking.the.coding.interview.problems;


import data.structures.implementations.linked.list.LinkedList;
import data.structures.implementations.linked.list.Node;


/*
    2.5
    Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit.
    The digits are stored in reverse order, such that the 1 's digit is at the head of the list.
    Write a function that adds the two numbers and returns the sum as a linked list.

    EXAMPLE

    Input: (7-> 1 -> 6) + (5 -> 9 -> 2) .That is,617 + 295.
    Output: 2 -> 1 -> 9. That is, 912.

    FOLLOW UP

    Suppose the digits are stored in forward order. Repeat the above problem.

    EXAMPLE

    Input: (6 -> 1 -> 7) + (2 -> 9 -> 5) . That is,617 + 295 .
    Output: 9 -> 1 -> 2. That is, 912.
*/


public class _2_5_SumLists {

    /*
        Time: O(N)
        Memory: O(N)
    */

    public static LinkedList sumListsForward(LinkedList l1, LinkedList l2) {
        Node p1 = l1.head;
        Node p2 = l2.head;
        LinkedList list = new LinkedList();
        int sum = 0;
        while (p1 != null && p2 != null) {
            sum += p1.data + p2.data;
            list.add(sum % 10);
            sum /= 10;
            p1 = p1.next;
            p2 = p2.next;
        }

        if (p1 == null) {
            while (p2 != null) {
                sum += p2.data;
                list.add(sum % 10);
                sum /= 10;
                p2 = p2.next;
            }
        } else {
            while (p1 != null) {
                sum += p1.data;
                list.add(sum % 10);
                sum /= 10;
                p1 = p1.next;
            }
        }

        if (sum != 0) {
            list.add(sum);
        }

        return list;
    }


    public static class Wrapper {
        LinkedList list;
        int sum;
    }


    /*
       Time: O(max(l1, l2))
       Memory: O(max(l1, l2))
   */
    public static Wrapper sumListsReverse(Node n1, Node n2, int i, int j) {

        Wrapper wrapper = new Wrapper();
        if (i == 1 && j == 1) {
            wrapper.list = new LinkedList();
            wrapper.sum += n1.data + n2.data;
            wrapper.list.addToHead(wrapper.sum % 10);
            wrapper.sum /= 10;
            return wrapper;
        } else if (i != 1 && j != 1 && i == j) {
            wrapper = sumListsReverse(n1.next, n2.next, i - 1, j - 1);
        } else if (i != 1 && i > j) {
            wrapper = sumListsReverse(n1.next, n2, i - 1, j);
        } else if (j != 1 && i < j) {
            wrapper = sumListsReverse(n1, n2.next, i, j - 1);
        }

        if (i > j) {
            wrapper.sum += n1.data;
        } else if (i < j) {
            wrapper.sum += n2.data;
        } else {
            wrapper.sum += n1.data + n2.data;
        }

        wrapper.list.addToHead(wrapper.sum % 10);
        wrapper.sum /= 10;

        return wrapper;
    }

    public static void main(String[] args) {

        LinkedList l1 = new LinkedList();
        l1.add(7);
        l1.add(7);
        l1.add(1);
        l1.add(9);
        l1.add(9);

        l1.print();

        LinkedList l2 = new LinkedList();

        l2.add(9);
        l2.add(5);
        l2.add(5);

        l2.print();
        int i = 0;
        int j = 0;
        Node n = l1.head;
        while (n != null) {
            i++;
            n = n.next;
        }
        n = l2.head;
        while (n != null) {
            j++;
            n = n.next;
        }

        Wrapper wrapper = sumListsReverse(l1.head, l2.head, i, j);

        if (wrapper.sum != 0) {
            wrapper.list.addToHead(wrapper.sum);
        }
        wrapper.list.print();
    }

}
