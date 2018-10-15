package cracking.the.coding.interview.problems;


/*
    10.10
    Rank from Stream: Imagine you are reading in a stream of integers. Periodically, you wish
    to be able to look up the rank of a number x (the number of values less than or equal to x).
    Implement the data structures and algorithms to support these operations. That is, implement
    the method track(int x), which is called when each number is generated, and the method
    getRankOfNumber(int x), which returns the number of values less than or equal to x
    (not including x itself).

    EXAMPLE

    Stream(in order of appearance):5, 1, 4, 4, 5, 9, 7, 13, 3
    getRankOfNumber(1) = 0
    getRankOfNumber(3) = 1
    getRankOfNumber(4) = 3
*/

public class _10_10_RankFromStream {

    public static class Node {
        public int value;
        public int rank = 0;

        public Node left, right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }

    public static class BSTree {
        public Node root;
        public int size = 0;

        private void insertNode(Node root, Node node) {

            if (node.value == root.value) {
                root.rank++;
            } else if (node.value > root.value) {
                if (root.right == null) {
                    node.rank = root.rank + 1;
                    root.right = node;
                } else {
                    node.rank++;
                    insertNode(root.right, node);
                }
            } else {
                root.rank++;
                if (root.left == null) {
                    root.left = node;
                } else {
                    updateRightNodes(root.right);
                    insertNode(root.left, node);
                }
            }
        }

        private void updateRightNodes(Node root) {
            if (root == null) {
                return;
            }

            root.rank++;
            updateRightNodes(root.left);
            updateRightNodes(root.right);
        }


        /*
            Time: O(N)
            Memory: O(1)
        */

        public void track(int value) {

            Node node = new Node(value);
            if (root == null) {
                root = node;
            } else {
                insertNode(root, node);
            }
            size++;
        }

        private int search(Node root, int value) {
            if (root == null) {
                return -1;
            }

            int rank;

            if (root.value == value) {
                rank = root.rank;
            } else if (root.value > value) {
                rank = search(root.left, value);
            } else {
                rank = search(root.right, value);
            }
            return rank;
        }


        /*
            Time: O(Log(N))
            Memory: O(1)
        */

        public int getRankOfNumber(int value) {
            return search(root, value);
        }
    }


    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 4, 5, 9, 7, 13, 3};

        BSTree tree = new BSTree();

        for (int i : arr) {
            tree.track(i);
        }

        System.out.println(tree.getRankOfNumber(1));
        System.out.println(tree.getRankOfNumber(3));
        System.out.println(tree.getRankOfNumber(4));
        System.out.println(tree.getRankOfNumber(5));
        System.out.println(tree.getRankOfNumber(9));
        System.out.println(tree.getRankOfNumber(13));
        System.out.println(tree.getRankOfNumber(14));
    }
}
