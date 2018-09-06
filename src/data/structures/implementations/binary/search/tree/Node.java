package data.structures.implementations.binary.search.tree;

public class Node {
    public int value;
    public Node parent, left, right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
