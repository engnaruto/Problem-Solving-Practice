package cracking.the.coding.interview.problems;



/*
    4.4
    Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
    this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
    node never differ by more than one.
*/

import data.structures.implementations.binary.search.tree.BSTree;
import data.structures.implementations.binary.search.tree.Node;

public class _4_4_CheckBalanced {

    public static boolean checkBalanced(Node root) {
        return getHeight(root) != Integer.MAX_VALUE;
    }


    /*
        Time: O(N)
    */

    private static int getHeight(Node root) {
        if (root.left == null && root.right == null) {
            return 1;
        }

        int lDepth = 0;
        int rDepth = 0;

        if (root.left != null) {
            lDepth = getHeight(root.left);
        }

        if (lDepth == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (root.right != null) {
            rDepth = getHeight(root.right);
        }

        if (root.value == 9) {
            System.out.println(lDepth);
            System.out.println(rDepth);
        }

        if (Math.abs(rDepth - lDepth) > 1) {
            return Integer.MAX_VALUE;
        } else {
            return Math.max(lDepth, rDepth) + 1;
        }
    }


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        BSTree tree = _4_2_MinimalTree.minimalTree(arr);

        tree.insert(11);
//        tree.insert(12);
//        tree.insert(0);
//        tree.insert(-1);

        System.out.println(checkBalanced(tree.root));


    }


}
