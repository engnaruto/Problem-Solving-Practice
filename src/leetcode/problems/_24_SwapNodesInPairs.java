package leetcode.problems;

/*
     Given a linked list, swap every two adjacent nodes and return its head.

     You may not modify the values in the list's nodes, only nodes itself may be changed.

     Example:

     Given 1->2->3->4, you should return the list as 2->1->4->3.
 */

public class _24_SwapNodesInPairs {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*
        Time: O(N)
        Memory: O(1)
    */

    public static ListNode swapPairs(ListNode head) {
        ListNode n1;
        ListNode n2;
        ListNode lastNode;

        if (head == null || head.next == null) {
            return head;
        }

        n1 = head.next;
        n2 = head;
        head = n1;

        n2.next = n1.next;
        n1.next = n2;

        if (n2.next == null) {
            return head;
        }

        lastNode = n2;

        n1 = n2.next.next;
        n2 = n2.next;

        while (n1 != null) {

            n2.next = n1.next;
            n1.next = n2;

            lastNode.next = n1;
            lastNode = n2;

            if (n2.next == null) {
                break;
            }


            n1 = n2.next.next;
            n2 = n2.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node = new ListNode(3, node);
        node = new ListNode(2, node);
        node = new ListNode(1, node);

        node = swapPairs(node);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

        node = new ListNode(5);
        node = new ListNode(4, node);
        node = new ListNode(3, node);
        node = new ListNode(2, node);
        node = new ListNode(1, node);

        node = swapPairs(node);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
