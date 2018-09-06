package cracking.the.coding.interview.problems;

import data.structures.implementations.binary.search.tree.BSTree;
import data.structures.implementations.binary.search.tree.Node;

import static cracking.the.coding.interview.problems._4_2_MinimalTree.minimalTree;


/*
    4.10
    Check Subtree: T1 and T2 are two very large binary trees, with T1 much bigger than T2.
    Create an algorithm to determine if T2 is a subtree of T1.

    A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2.
    That is, if you cut off the tree at node n, the two trees would be identical.
*/


public class _4_10_CheckSubtree {

    /*
        Time: O(N + K * M) where K is the number of nodes that its value = the root of T2
        Memory: O(Log(N) + Log(M))
    */

    public static boolean checkSubtree(Node t1, Node t2) {
        if (t1 != null && t2 == null) {
            return true;
        }
        return checkSubtree1(t1, t2);
    }

    public static boolean checkSubtree1(Node t1, Node t2) {
        if ((t1 == null && t2 != null) || (t1 != null && t2 == null)) {
//                System.out.println("CCCCC");
            return false;
        }
        if (t1 == null && t2 == null) {
//            System.out.println("XXXXX");
            return true;
        }

        boolean value = false;
        if (t1.value == t2.value) {
            value = checkSubtree1(t1.left, t2.left) && checkSubtree1(t1.right, t2.right);
        }

        return value || checkSubtree1(t1.left, t2) || checkSubtree1(t1.right, t2);
    }


    /*
        Time: O(N + M)
        Memory: O(N + M)
    */

    public static boolean checkSubtreeUsingStrings(Node t1, Node t2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        treeToString(t1, s1);
        treeToString(t2, s2);
        return s1.toString().contains(s2.toString());
    }

    private static void treeToString(Node root, StringBuilder s) {

        if (root == null) {
            s.append("X");
            return;
        }

        s.append(root.value);
        treeToString(root.left, s);
        treeToString(root.right, s);
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        BSTree tree = minimalTree(arr);

//        Node node = null;
        Node node = new Node(2);
        node.left = new Node(1);
        node.right = new Node(3);
        node.right.right = new Node(4);


        System.out.println(checkSubtree(tree.root, node));
        System.out.println(checkSubtreeUsingStrings(tree.root, node));
    }


}
