package cracking.the.coding.interview.problems;

import java.util.Stack;

/*
    3.4
    Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
*/

public class _3_4_QueueViaStacks {

    public static class MyQueue {
        private Stack<Integer> s1;
        private Stack<Integer> s2;
        private boolean isInqueuing = true;

        MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }


        /*
          Time: O(N)
        */

        public void inqueue(int value) {

            if (!isInqueuing) {
                isInqueuing = true;
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }
            s1.push(value);
        }


        /*
          Time: O(N)
        */

        public int dequeue() {
            print();
            if (s1.isEmpty() && s2.isEmpty()) {
                return Integer.MIN_VALUE;
            } else if (isInqueuing) {
                isInqueuing = false;
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        public void print() {
            System.out.println(s1.toString());
            System.out.println(s2.toString());
            System.out.println("*********************");
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        q.inqueue(1);
        q.inqueue(2);
        q.inqueue(3);
        q.print();
        System.out.println(q.dequeue());
        q.inqueue(4);
        q.inqueue(5);
        q.inqueue(6);
        System.out.println(q.dequeue());
        q.print();
        q.inqueue(7);
        System.out.println(q.dequeue());
        q.print();



    }
}
