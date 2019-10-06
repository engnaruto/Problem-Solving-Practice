package leetcode.problems;


/*
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

        push(x) -- Push element x onto stack.
        pop() -- Removes the element on top of the stack.
        top() -- Get the top element.
        getMin() -- Retrieve the minimum element in the stack.


    Example:

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   --> Returns -3.
        minStack.pop();
        minStack.top();      --> Returns 0.
        minStack.getMin();   --> Returns -2.
*/


class MinStack {
    LinkedList list;

    /**
     * initialize your data structure here.
     */

    public MinStack() {
        list = new LinkedList();
    }

    /*
        Time: O(1)
    */

    public void push(int x) {
        list.addToTail(new LinkedList.Node(x));
    }

    /*
        Time: O(1)
    */

    public void pop() {
        list.removeTail();
    }

    /*
        Time: O(1)
    */

    public int top() {
        return list.getTailValue();
    }

    /*
        Time: O(1)
    */

    public int getMin() {
        return list.getMinValue();
    }

    static class LinkedList {

        Node tail;

        public LinkedList() {

        }

        public void addToTail(Node n) {
            if (tail == null) {
                tail = n;
                tail.min = n.value;
            } else {
                n.min = Math.min(n.value, tail.min);
                n.next = tail;
                tail = n;
            }
        }

        public void removeTail() {
            if (tail == null) {
                // throw new Exception();
            } else {
                Node dummy = tail;
                tail = tail.next;
                dummy.next = null;
            }
        }

        public int getMinValue() {
            if (tail == null) {
                return Integer.MAX_VALUE;
            } else {
                return tail.min;
            }
        }

        public int getTailValue() {
            if (tail == null) {
                return Integer.MAX_VALUE;
            } else {
                return tail.value;
            }
        }


        static class Node {
            int value;
            int min;
            Node next;

            public Node(int value) {
                this.value = value;
            }
        }
    }
}

public class _155_MinStack {
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   // Returns -3.
        minStack.pop();
        System.out.println(minStack.top());      // Returns 0.
        System.out.println(minStack.getMin());    // Returns -2.
    }
}
