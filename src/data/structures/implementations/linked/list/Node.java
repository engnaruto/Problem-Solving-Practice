package data.structures.implementations.linked.list;

public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "" + data;
//        return super.toString()+"\t" + data;
    }
}
