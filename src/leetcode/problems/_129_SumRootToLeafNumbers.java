package leetcode.problems;

/*
    Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

    An example is the root-to-leaf path 1->2->3 which represents the number 123.

    Find the total sum of all root-to-leaf numbers.

    Note: A leaf is a node with no children.

    Example:

    Input: [1,2,3]
        1
       / \
      2   3

    Output: 25

    Explanation:

    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.
    Therefore, sum = 12 + 13 = 25.

    Example 2:

    Input: [4,9,0,5,1]
        4
       / \
      9   0
     / \
    5   1

    Output: 1026

    Explanation:

    The root-to-leaf path 4->9->5 represents the number 495.
    The root-to-leaf path 4->9->1 represents the number 491.
    The root-to-leaf path 4->0 represents the number 40.
    Therefore, sum = 495 + 491 + 40 = 1026.
*/

import com.sun.source.tree.Tree;

public class _129_SumRootToLeafNumbers {

    //  Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
        Time: O(N)
        Memory: O(N)
    */

    public static int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public static int sumNumbers(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int currentSum = sum * 10 + root.val;

        if (root.left == null && root.right == null) { // leaf
            return currentSum;
        }

        int result = 0;

        result += sumNumbers(root.left, currentSum);
        result += sumNumbers(root.right, currentSum);

        return result;
    }

    public static void main(String[] args) {

        TreeNode n = new TreeNode(4);
        n.left = new TreeNode(9);
        n.left.left = new TreeNode(5);
        n.left.right = new TreeNode(1);
        n.right = new TreeNode(0);

        System.out.println(sumNumbers(n));
    }
}
