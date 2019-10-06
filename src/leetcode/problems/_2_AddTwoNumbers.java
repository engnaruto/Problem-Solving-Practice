package leetcode.problems;

/*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example:

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)

    Output: 7 -> 0 -> 8

    Explanation: 342 + 465 = 807.

*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class _2_AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*
        Time: O(N) N: Number of digits in the longest number
        Memory: O(N) N: Number of digits in the longest number
    */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int firstList = 0;
        int secondList = 0;

        ListNode node = l1;
        while (node != null) {
            firstList++;
            node = node.next;
        }
        node = l2;
        while (node != null) {
            secondList++;
            node = node.next;
        }

        ListNode longerList = firstList > secondList ? l1 : l2;
        ListNode shorterList = firstList > secondList ? l2 : l1;


        ListNode l = null;
        int reminder = 0;
        int sum = 0;

        boolean firstTime = false;

        while (shorterList != null) {
            sum = longerList.val + shorterList.val + reminder;
            reminder = sum / 10;

            if (!firstTime) {
                firstTime = true;
                l = new ListNode(sum % 10);
                node = l;
            } else {
                l.next = new ListNode(sum % 10);
                l = l.next;
            }

            shorterList = shorterList.next;
            longerList = longerList.next;
        }

        while (longerList != null) {
            sum = longerList.val + reminder;
            l.next = new ListNode(sum % 10);
            reminder = sum / 10;
            l = l.next;
            longerList = longerList.next;
        }
        if (reminder != 0) {
            l.next = new ListNode(1);
        }
        return node;
    }

    /*
        Time: O(N) N: Number of digits in the longest number
        Memory: O(N) N: Number of digits in the longest number
    */

    public static ListNode addTwoNumbersSimplified(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode l = dummy;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }

            l.next = new ListNode(carry % 10);
            l = l.next;
            carry /= 10;

            if (l1 == null && l2 == null && carry != 0) {
                l.next = new ListNode(1);
                carry = 0;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(3);

        ListNode l = addTwoNumbers(l1, l2);

        while (l != null) {
            System.out.print(l.val + " -> ");
            l = l.next;
        }

        System.out.println();

        l = addTwoNumbersSimplified(l1, l2);

        while (l != null) {
            System.out.print(l.val + " -> ");
            l = l.next;
        }

    }
}
