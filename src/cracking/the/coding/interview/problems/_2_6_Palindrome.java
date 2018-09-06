package cracking.the.coding.interview.problems;


import data.structures.implementations.linked.list.LinkedList;
import data.structures.implementations.linked.list.Node;

import java.util.Stack;


/*
    2.6
    Palindrome: Implement a function to check if a linked list is a palindrome.
*/
public class _2_6_Palindrome {

    /*
        Time: O(N)
        Memory: O(N)
    */

    public static boolean isPalindrome(LinkedList list) {
        LinkedList list2 = new LinkedList();
        int counter = 1;
        Node n = list.head;

        while (n != null) {
            list2.addToHead(n.data);
            n = n.next;
            counter++;
        }

        n = list.head;
        Node nn = list2.head;

        for (int i = 0; i < counter / 2; i++) {
            if (n.data != nn.data) {
                return false;
            }
            n = n.next;
            nn = nn.next;
        }
        return true;
    }

    static class Wrapper {
        Node node;

        Wrapper(Node node) {
            this.node = node;
        }
    }


    /*
         Time: O(N)
         Memory: O(N)
    */

    public static boolean palindromeRecursion(Wrapper wrapper, int n) {
        if (n == 0 || n == 1) {
            return true;
        }

        Node current = wrapper.node;

        wrapper.node = wrapper.node.next;

        boolean booleanValue = palindromeRecursion(wrapper, n - 2);

        if (!booleanValue) {
            return false;
        }

        /*
        *   1 -> (2)-> 2 -> 1
        *   wrapper.node = wrapper.node.next; -> (2) (the second one)
        *   booleanValue = palindromeRecursion(wrapper, n - 2); -> n = 0
        *   booleanValue = wrapper.node.data == current.data; -> 2 = 2
        *   wrapper.node = wrapper.node.next; -> (1) (the second one)
        *   return booleanValue
        *
        *
        *   1 -> 2 -> (3) -> 2 -> 1
        *   wrapper.node = wrapper.node.next; -> (3) (the second one)
        *   booleanValue = palindromeRecursion(wrapper, n - 2); -> n = 1
        *   wrapper.node = wrapper.node.next; -> (2) (the second one)
        *   booleanValue = wrapper.node.data == current.data; -> 2 = 2
        *   return booleanValue
        *
        * */

        if (n % 2 == 0) {
            booleanValue = wrapper.node.data == current.data;
            wrapper.node = wrapper.node.next;
        } else {
            wrapper.node = wrapper.node.next;
            booleanValue = wrapper.node.data == current.data;
        }
        return booleanValue;
    }

    public static boolean isPalindromeRecursion(LinkedList list) {

        int counter = 0;
        Node node = list.head;

        while (node != null) {
            counter++;
            node = node.next;
        }
        return palindromeRecursion(new Wrapper(list.head), (counter));
    }

    /*
         Time: O(N)
         Memory: O(N)
    */

    public static boolean isPalindromeUsingStack(LinkedList list) {
        Node current = list.head;
        Node runner = list.head;
        Stack<Integer> stack = new Stack<>();

        while (runner != null && runner.next != null) {
            stack.add(current.data);
            runner = runner.next.next;
            current = current.next;
        }

        if (runner != null) {
            current = current.next;
        }

        while (!stack.isEmpty()) {
            if (current.data != stack.pop()) {
                return false;
            }
            current = current.next;
        }

        return true;
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        list.print();

        System.out.println(isPalindrome(list));
        System.out.println(isPalindromeRecursion(list));
        System.out.println(isPalindromeUsingStack(list));
    }


}
