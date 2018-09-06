package data.structures.implementations.linked.list;

public class LinkedList {
    public Node head;


    public void add(int data) {
        if (head != null) {
            Node node = new Node(data);
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        } else {
            head = new Node(data);
        }
    }

    public void add(Node node) {
        if (head != null) {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        } else {
            head = node;
        }
    }

    public void addToHead(int data) {
        if (head != null) {
            Node node = new Node(data);
            node.next = head;
            head = node;
        } else {
            head = new Node(data);
        }
    }

    public void removeValue(int value) {
        Node current = head;

        while (current.next.next != null) {
            if (current.next.data == value) {
                Node node = current.next;
                current.next = current.next.next;
                node.next = null;
                return;
            }
            current = current.next;
        }
        if (current.next.data == value) {
            current.next = null;
        }
    }

    public void deleteNode(int position) {
        int currentPosition = 0;
        Node current = head;

        if (position == 0) {
            Node node = head;
            if (head.next != null) {
                head = head.next;
                node.next = null;
            } else {
                head = null;
            }
            return;
        }

        while (currentPosition != position - 1 && current.next != null) {
            current = current.next;
            currentPosition++;
        }

        if (currentPosition == position - 1) {
            Node node = current.next;
            if (node != null) {
                current.next = node.next;
                node.next = null;
            }
        }

    }

    public void print() {
        Node current = head;

        while (current != null && current.next != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(current != null ? current.data : "null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.print();

        list.addToHead(10);
        list.add(11);

        list.addToHead(12);
        list.print();

        list.removeValue(5);
        list.print();

        list.removeValue(11);
        list.print();

        list.deleteNode(2);
        list.print();

        list.deleteNode(5);
        list.print();

        list.deleteNode(0);
        list.print();

        list.deleteNode(1);
        list.print();

        list.deleteNode(0);
        list.print();

        list.deleteNode(0);
        list.print();

        list.deleteNode(0);
        list.print();

    }
}
