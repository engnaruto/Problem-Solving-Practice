package data.structures.implementations.linked.list;

import java.util.Arrays;

public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
//        return "" + data;
        return super.toString().split("\\.")[super.toString().split("\\.").length-1]+"\t" + data;
    }
}
