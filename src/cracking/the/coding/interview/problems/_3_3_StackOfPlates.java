package cracking.the.coding.interview.problems;

import java.util.ArrayList;
import java.util.Stack;


/*
    3.3
    Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
    Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
    threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
    composed of several stacks and should create a new stack once the previous one exceeds capacity.
    SetOfStacks. push () and SetOfStacks. pop () should behave identically to a single stack
    (that is, pop ( ) should return the same values as it would if there were just a single stack).

    FOLLOW UP

    Implement a function popAt (int index) which performs a pop operation on a specific sub-stack.
*/

public class _3_3_StackOfPlates {

    public static class SetOfStacks {
        private int capacity;
        private int index;
        private ArrayList<Stack<Integer>> stackList;

        SetOfStacks(int capacity) {
            this.capacity = capacity;
            stackList = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            stackList.add(stack);
            index = 0;
        }

        private boolean isFull() {
            return stackList.get(index).size() == capacity;
        }

        private boolean isEmpty() {
            return stackList.get(index).isEmpty();
        }


        /*
          Time: O(1)
        */

        public void push(int value) {
            if (isFull()) {
                index++;
                Stack<Integer> stack = new Stack<>();
                stackList.add(stack);
            }
            stackList.get(index).push(value);
        }


        /*
          Time: O(1)
        */

        public int pop() {
            if (index == 0 && isEmpty()) {
                try {
                    throw new Exception("Stack is Empty");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (isEmpty()) {
                stackList.remove(index);
                index--;
            }
            return stackList.get(index).pop();
        }


        /*
         Time: O(1)
       */

        public int popAt(int index) {
            if (index > this.index || index < 0) {
                try {
                    throw new Exception("Index is not in range");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            int value = stackList.get(index).pop();
            if (stackList.get(index).isEmpty()) {
                stackList.remove(index);
            }
            return value;
        }


        public void print() {
            for (Stack<Integer> stack : stackList) {
                System.out.println(stack);
            }
            System.out.println("***************");
        }
    }


    public static void main(String[] args) {
        SetOfStacks stack = new SetOfStacks(3);


        stack.push(0);
//        stack.print();
//        System.out.println(stack.pop());
//        stack.print();
//        System.out.println(stack.pop());
//        stack.print();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();

        System.out.println(stack.popAt(1));
        stack.print();
        System.out.println(stack.popAt(1));
        stack.print();
        System.out.println(stack.popAt(1));
        stack.print();
        System.out.println(stack.popAt(1));
        stack.print();
    }

}
