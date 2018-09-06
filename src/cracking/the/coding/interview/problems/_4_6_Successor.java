package cracking.the.coding.interview.problems;


import data.structures.implementations.binary.search.tree.BSTree;
import data.structures.implementations.binary.search.tree.Node;


/*
    4.6
    Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
    binary search tree. You may assume that each node has a link to its parent.
*/


public class _4_6_Successor {

    public static class Wrapper {
        Node n;
        boolean isFound;

        Wrapper(Node n, boolean isFound) {
            this.n = n;
            this.isFound = isFound;
        }

        @Override
        public String toString() {
            return n + " - " + isFound;
        }
    }

    public static Wrapper wrapper;


    /*
       Time: O(N) This is the solution when there is no link from the children to their parent
    */

    public static void successor(Node root, Node node) {

        if (root == null) {
            return;
        }

        successor(root.left, node);

        if (root == node) {
            wrapper = new Wrapper(root, false);
        } else if (wrapper != null && !wrapper.isFound) {
            wrapper = new Wrapper(root, true);
        }
        successor(root.right, node);
    }

    /*
        Time: O(Log N)
    */
    public static Node successorUsingParentLink(Node node) {

        if (node == null) {
            return null;
        }

        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else if (node.parent != null && node.parent.left == node) {
            return node.parent;
        } else if (node.parent != null && node.parent.right == node) {

            while (node.parent != null) {
                if (node.parent.left == node) {
                    return node.parent;
                }
                node = node.parent;
            }

            if (node.parent == null) {
                return null;
            }
            return node;
        }
        return null;
    }


    /*
        Time: O(Log N) Book's solution
    */

    public static Node inorderSucc(Node n) {
        if (n == null) return null;
        /* Found right children -> return leftmost node of right subtree. */
        if (n.right != null) {
            return leftMostChild(n.right);
        } else {
            Node q = n;
            Node x = q.parent;
            // Go up until we're on left instead of right
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    public static Node leftMostChild(Node n) {
        if (n == null) {
            return null;
        }

        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        BSTree tree = _4_2_MinimalTree.minimalTree(arr);

//        BSTree tree = new BSTree();
//        tree.insert(5);
//        tree.insert(1);
//        tree.insert(2);
//        tree.insert(3);
//        tree.insert(4);

        Node n = tree.root.left.left;

//        tree.printPreorder();
//        tree.printBFS();
        successor(tree.root, n);

        System.out.println(wrapper);

        System.out.println(successorUsingParentLink(n));
        System.out.println(inorderSucc(n));
    }


}
