package data.structures.implementations.binary.search.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BSTree {
    public Node root;
    public int size = 0;

    private void insertNode(Node root, Node node) {

        if (node.value < root.value) {
            if (root.left == null) {
                root.left = node;
                node.parent = root;
            } else {
                insertNode(root.left, node);
            }
        } else {
            if (root.right == null) {
                root.right = node;
                node.parent = root;
            } else {
                insertNode(root.right, node);
            }
        }
    }

    public void insert(int value) {

        Node node = new Node(value);
        if (root == null) {
            root = node;
        } else {
            insertNode(root, node);
        }
        size++;
    }

    public void insert(Node node) {
        if (root == null) {
            root = node;
        } else {
            insertNode(root, node);
        }
        size++;
    }

    private Node search(Node root, int value) {
        if (root == null) {
            return null;
        }

        Node node;

        if (root.value == value) {
            node = root;
        } else if (root.value < value) {
            node = search(root.left, value);
        } else {
            node = search(root.right, value);
        }
        return node;
    }

    public boolean search(int value) {
        return search(root, value) != null;
    }


    public boolean delete(int value) {
        Node node = search(root, value);

//        if (node!=null){
//            node next =
//        }
        return true;
    }


    public void printBFS() {
        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            Node node = q.poll();
            System.out.println(node.value);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }

    private void printInorder(Node node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.println(node.value);
        printInorder(node.right);
    }

    public void printInorder() {
        printInorder(root);
    }

    private void printPreorder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.value);
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public void printPreorder() {
        printPreorder(root);
    }

    private void printPostorder(Node node) {
        if (node == null) {
            return;
        }

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.println(node.value);
    }

    public void printPostorder() {
        printPostorder(root);
    }


    private int getLongestBranch(Node root, int count) {

        if (root.right == null && root.left == null) {
            return count + 1;
        }

        int c = 0;

        if (root.right != null) {
            c = getLongestBranch(root.right, count + 1);
        }
        if (root.left != null) {
            c = Math.max(getLongestBranch(root.left, count + 1), c);
        }
        return c;
    }

    public int getLongestBranch() {
        return getLongestBranch(root, 0);
    }
}