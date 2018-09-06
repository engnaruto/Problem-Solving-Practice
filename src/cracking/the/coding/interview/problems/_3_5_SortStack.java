package cracking.the.coding.interview.problems;

import java.util.Stack;

/*
    3.5
    Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
    an additional temporary stack, but you may not copy the elements into any other data structure
    (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.
*/

public class _3_5_SortStack {

    /*
        Time: O((N * (N-1)) / 2) = O(N^2) 
        Memory: O(N)
    */

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        int current = 0;
        int counter = 0;
        int n = 0;

        boolean isSorted = false;

        while (!isSorted) {
            current = stack.pop();

            if (!temp.isEmpty() && current < temp.peek()) {
                while (temp.peek() > current) {
                    stack.push(temp.pop());
                    counter++;
                }
                temp.push(current);
                while (counter != 0) {
                    temp.push(stack.pop());
                    counter--;
                }
            } else {
                while (!stack.isEmpty() && stack.peek() <= current) {
                    temp.push(stack.pop());
                }
                temp.push(current);
            }

            System.out.println("Stack: " + stack.toString());
            System.out.println("Temp: " + temp.toString());
            System.out.println(n + " ****************");

            if (stack.isEmpty()) {
                isSorted = true;

                while (!temp.isEmpty()) {
                    if (!temp.isEmpty() && !stack.isEmpty() && stack.peek() < temp.peek()) {
                        isSorted = false;
                    }
                    stack.push(temp.pop());
                }
            }
            n++;
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }


    /*
        Time: O(N^2) 
        Memory: O(N)
    */

    public static void sort(Stack<Integer> stack) {

        Stack<Integer> temp = new Stack<Integer>();
        int n = 0;
        while (!stack.isEmpty()) {

            /* Insert each element in s in sorted order into r. */

            int tmp = stack.pop();

            while (!temp.isEmpty() && temp.peek() > tmp) {
                stack.push(temp.pop());
            }
            temp.push(tmp);

            System.out.println("Stack: " + stack.toString());
            System.out.println("Temp: " + temp.toString());
            System.out.println(n + " ****************");
            n++;
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);

        // sortStack(stack);
        sort(stack);

        System.out.println(stack.toString());
    }

}
