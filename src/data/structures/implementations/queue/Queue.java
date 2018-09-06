package data.structures.implementations.queue;

import data.structures.implementations.linked.list.Node;

public class Queue {
    private Node head;
    private Node tail;

    public void inqueue(int value) {
        if (head == null) {
            head = new Node(value);
            tail = head;
        } else {
            Node node = new Node(value);
            tail.next = node;
            tail = node;
        }
    }

    public int dequeue() {
        if (head != null) {
            Node n = head;
            head = head.next;
            n.next = null;
            if (head == tail) {
                head = null;
            }
            return n.data;
        }
        return Integer.MIN_VALUE;
    }

    public int peek() {
        if (head != null) {
            return head.data;
        }
        return Integer.MIN_VALUE;
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
        Queue queue = new Queue();
        System.out.println(queue.isEmpty());
        queue.inqueue(1);
        queue.inqueue(2);
//        queue.inqueue(3);
//        queue.inqueue(4);
//        queue.inqueue(5);
//        queue.inqueue(6);
        queue.print();
        System.out.println(queue.dequeue());
        queue.print();
        System.out.println(queue.isEmpty());
        System.out.println(queue.dequeue());
        queue.print();
        queue.inqueue(3);
        queue.inqueue(4);
        queue.inqueue(5);
        queue.print();
        System.out.println(queue.peek());
        queue.print();


    }

}
