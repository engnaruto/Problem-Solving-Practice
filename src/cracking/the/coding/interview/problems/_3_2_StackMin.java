package cracking.the.coding.interview.problems;

import java.util.Stack;


/*
    3.2
    Stack Min: How would you design a stack which, in addition to push and pop, has a function min
    which returns the minimum element? Push, pop and min should all operate in 0(1) time.
*/

public class _3_2_StackMin {

    public static class StackMin {


        private Stack<Integer> stack;
        private Stack<Integer> min;

        StackMin() {
            stack = new Stack<>();
            min = new Stack<>();
        }


        /*
          Time: O(1)
        */

        public void push(int i) {
            stack.push(i);
            if (min.isEmpty() || min.peek() >= i) {
                min.push(i);
            }
        }


        /*
          Time: O(1)
        */

        public int pop() {
            int v = stack.pop();
            if (!min.isEmpty() && min.peek() == v) {
                min.pop();
            }
            return v;
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }

        /*
           Time: O(1)
           Memory: O(N)
        */

        public int min() {
            return min.isEmpty() ? Integer.MAX_VALUE : min.peek();
        }
    }


    public static void main(String[] args) {
        StackMin stack = new StackMin();

        System.out.println(stack.min);
        stack.push(5);
        System.out.println(stack.min());
        stack.push(6);
        System.out.println(stack.min());

        stack.push(4);
        System.out.println(stack.min());

        stack.push(8);
        System.out.println(stack.min());

        stack.push(0);
        System.out.println(stack.min());

        stack.pop();
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }

}
