package data.structures.implementations.stack;

import data.structures.implementations.linked.list.Node;

public class Stack {

    Node head;


    public void push(int n) {
        if (head == null) {
            head = new Node(n);
        } else {
            Node node = new Node(n);
            node.next = head;
            head = node;
        }
    }

    public int pop() {
        if (head == null) {
            return Integer.MIN_VALUE;
        }

        Node n = head;
        head = head.next;
        n.next = null;
        return n.data;
    }

    public int peek() {
        if (head == null) {
            return Integer.MIN_VALUE;
        }
        return head.data;
    }


    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        Node n = head;
        if (n == null) {
            System.out.println("null");
            return;
        }
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(2);
//        queue.inqueue(3);
//        queue.inqueue(4);
//        queue.inqueue(5);
//        queue.inqueue(6);
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        stack.print();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.print();
        System.out.println(stack.peek());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        stack.pop();
        stack.pop();
        stack.print();


    }

}
