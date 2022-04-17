package leetcode.problems;

/*
    Return the root node of a binary search tree that matches the given preorder traversal.

    (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left
    has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder
    traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

    Example 1:

    Input: [8,5,1,7,10,12]

    Output: [8,5,10,1,7,null,12]

    Note:

    1 <= preorder.length <= 100

    The values of preorder are distinct.
*/

public class _1008_ConstructBinarySearchTreeFromPreorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int index = 0;

    public static TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        return constructBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static TreeNode constructBST(int[] preorder, int min, int max) {

        if (index >= preorder.length) {
            return null;
        }
        TreeNode root = null;
        if (preorder[index] > min && preorder[index] < max) {
            root = new TreeNode(preorder[index++]);
        }
        if (root != null) {
            root.left = constructBST(preorder, min, root.val);
            root.right = constructBST(preorder, root.val, max);
        }
        return root;
    }
}
