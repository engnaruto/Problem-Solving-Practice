package cracking.the.coding.interview.problems;

import data.structures.implementations.binary.search.tree.BSTree;
import data.structures.implementations.binary.search.tree.Node;


/*
    4.5
    Validate BST: Implement a function to check if a binary tree is a binary search tree.
*/

public class _4_5_ValidateBST {


    /*
        WRONG ANSWER
        Consider the following test case
                    20
                    /\
                   10 30
                    \
                    25 (wrong position cannot be considered using this solution)
    */

    public static boolean validateBST(Node root) {
        if (root.left == null && root.right == null) {
            return true;
        }

        boolean leftSubtree = true;
        boolean rightSubtree = true;

        if (root.left != null) {
            leftSubtree = validateBST(root.left);
            leftSubtree &= root.value > root.left.value;
        }

        if (root.right != null && leftSubtree) { // (&& leftSubtree) to truncate this subtree if the left subtree is not valid
            rightSubtree = validateBST(root.right);
            rightSubtree &= root.value <= root.right.value;
        }

        return leftSubtree && rightSubtree;
    }


    /*
        Time: O(N)
    */

    public static boolean validateBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }

        if ((min != Integer.MIN_VALUE && root.value < min) || (max != Integer.MAX_VALUE && root.value >= max)) {
            return false;
        }

        return validateBST(root.left, min, root.value) && validateBST(root.right, root.value, max);
    }


    public static void main(String[] args) {

        BSTree tree = new BSTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);
        tree.insert(70);
        tree.insert(80);

        tree.root.left = new Node(5);
        tree.root.left.right = new Node(7);
        tree.root.left.right.left = new Node(6);
        tree.root.left.right.left.right = new Node(8);

        System.out.println(validateBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));


    }


}
