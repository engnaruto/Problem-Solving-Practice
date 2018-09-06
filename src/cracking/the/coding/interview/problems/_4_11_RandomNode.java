package cracking.the.coding.interview.problems;


import data.structures.implementations.binary.search.tree.Node;

import java.util.ArrayList;
import java.util.Random;


/*
    4.11
    Random Node: You are implementing a binary search tree class from scratch, which, in addition
    to insert, find, and delete, has a method getRandomNode() which returns a random node
    from the tree. All nodes should be equally likely to be chosen. Design and implement an algorithm
    for getRandomNode, and explain how you would implement the rest of the methods.
*/

public class _4_11_RandomNode {
    public static class Node {
        int size = 1;

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

    public static class BSTree {

        ArrayList<Node> list = new ArrayList<>();


        public Node root;
        public int size = 0;

        private void insertNode(Node root, Node node) {
            root.size++;

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


        public boolean delete(int value) {
            list.remove(new Node(value));
//            return super.delete(value);
            return true;
        }

        public void insert(int value) {

            Node node = new Node(value);
            list.add(node);

            if (root == null) {
                root = node;
            } else {
                insertNode(root, node);
            }
            size++;
        }


        /*
            Time: O(N)
            Memory: O(N)
        */

        public Node getRandomNode() {
            Random rand = new Random();
            int randomNum = rand.nextInt(size);
            System.out.println("randomNum: " + randomNum);
            return list.get(randomNum);
        }


        public static int randomNum;


        /*
            Time: O(N)
            Memory: O(Log(N)) Max stack size
        */

        public Node getRandomNodeUsingTraversal() {

            Random rand = new Random();

            System.out.println("Size: " + size);
            randomNum = rand.nextInt(size);

            System.out.println("randomNum: " + randomNum);
            return dfs(root);
        }

        private Node dfs(Node root) {
            randomNum--;
            if (randomNum < 0 || root == null) {
                return root;
            }

            Node node = null;
            if (root.left != null) {
                node = dfs(root.left);
            }

            if (randomNum >= 0 && root.right != null) {
                node = dfs(root.right);
            }
            return node;
        }


        public Node getRandomNodeInLogN() {
            if (root == null) {
                return null;
            }
            Random rand = new Random();

            int randomNum = rand.nextInt(size) + 1;
            System.out.println("randoNum: " + randomNum);

            return getIthNode(root, randomNum);
        }


        /*
            Time: O(Log(N))
            Memory: O(Log(N)) Max stack size
        */

        private Node getIthNode(Node root, int randomNum) {

            int leftSize = root.left != null ? root.left.size : 0;

            if (root.size == randomNum) {
                return root;
            } else if (leftSize >= randomNum && leftSize != 0) {
                System.out.println(root + " - Go Left" + " - randomNum: " + randomNum);
                return getIthNode(root.left, randomNum);
            } else {
                System.out.println(root + " - Go Right" + " - randomNum: " + (randomNum - (leftSize)) + " - leftSize: " + leftSize);
                return getIthNode(root.right, randomNum - (leftSize));
            }
        }
    }

    public static void main(String[] args) {

        BSTree tree = new BSTree();
        tree.insert(5);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(4);
        tree.insert(8);
        tree.insert(6);
        tree.insert(7);
        tree.insert(9);
        tree.insert(10);

//        System.out.println(tree.getRandomNodeUsingTraversal());
//        System.out.println(tree.getRandomNode());
        System.out.println(tree.getRandomNodeInLogN());


    }

}
