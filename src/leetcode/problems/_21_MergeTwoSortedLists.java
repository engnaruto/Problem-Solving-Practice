package leetcode.problems;

/*
    Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together
    the nodes of the first two lists.

    Example:

    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4
*/


import java.util.HashSet;

public class _21_MergeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*
        Time: O(N + M)
        Memory: O(N + M)
    */

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode merged = new ListNode(0);
        head.next = merged;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                merged.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                merged.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            merged = merged.next;
        }

        while (l1 != null) {
            merged.next = new ListNode(l1.val);
            l1 = l1.next;
            merged = merged.next;
        }

        while (l2 != null) {
            merged.next = new ListNode(l2.val);
            l2 = l2.next;
            merged = merged.next;
        }

        return head.next.next;
    }

    /*
        Time: O(N + M)
        Memory: O(N + M)
    */

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null) {
            tail.next = l1;
        }

        if (l2 != null) {
            tail.next = l2;
        }

        return head.next;
    }

    /*
       Time: O(N + M)
       Memory: O(N + M)
    */

    public static ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            head.next = mergeTwoLists2(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists2(l1, l2.next);
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);

        ListNode result = mergeTwoListsRecursive(l1, l2);

        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }
}
