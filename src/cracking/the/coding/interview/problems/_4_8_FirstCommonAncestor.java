package cracking.the.coding.interview.problems;


import data.structures.implementations.binary.search.tree.BSTree;
import data.structures.implementations.binary.search.tree.Node;

import static cracking.the.coding.interview.problems._4_2_MinimalTree.minimalTree;

/*
    4.8
    First Common Ancestor: Design an algorithm and write code to find the first common ancestor
    of two nodes in a binary tree. Avoid storing additional nodes in a data structure.
    NOTE: This is not necessarily a binary search tree.
*/

public class _4_8_FirstCommonAncestor {

    public static class Wrapper {
        Node node;
        boolean found;

        Wrapper(Node node, boolean found) {
            this.node = node;
            this.found = found;
        }

        @Override
        public String toString() {
            return node + " - " + found;
        }
    }


    /*
       Time: O(N)
    */

    public static Wrapper firstCommonAncestor(Node root, Node n, Node nn) {
        if (root == null) {
            return null;
        }

        if (root == n && root == nn) {
            return new Wrapper(root, true);
        }

        Wrapper left = firstCommonAncestor(root.left, n, nn);
        Wrapper right = firstCommonAncestor(root.right, n, nn);

        if (root == n || root == nn) {
            if ((left != null && left.found) || (right != null && right.found)) { // A node is an ancestor of the other one -> return the higher one
                return new Wrapper(root, true);
            } else {
                return new Wrapper(null, true);
            }
        }

        if (right != null && left != null && right.found && left.found) {
            return new Wrapper(root, true);
        }

        if (right != null && right.found) {
            return right;
        } else if (left != null && left.found) {
            return left;
        }
        return null;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        BSTree tree = minimalTree(arr);


//        Node n = new Node(2);
//        Node n = tree.root.right.left.right;
        Node n = tree.root.left;
        Node nn = tree.root.right.left.right;

        System.out.println(firstCommonAncestor(tree.root, n, nn));

    }
}
