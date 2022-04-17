package leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/*
    Given a binary tree, determine if it is a complete binary tree.

    Definition of a complete binary tree from Wikipedia:
    In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last
    level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

    Example 1:

    Input: [1,2,3,4,5,6]

    Output: true

    Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes
    in the last level ({4, 5, 6}) are as far left as possible.

    Example 2:

    Input: [1,2,3,4,5,null,7]

    Output: false

    Explanation: The node with value 7 isn't as far left as possible.
*/

public class _958_CheckCompletenessOfABinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static boolean isCompleteTree(TreeNode root) {
        int count = countNodes(root);
        return checkCompleteness(root, 0, count);
    }

    private static boolean checkCompleteness(TreeNode root, int i, int count) {
        if (root == null) {
            if (i < count) {
                return false;
            }
            return true;
        }
        if (i >= count) {
            return false;
        }
        return checkCompleteness(root.left, 2 * i + 1, count) && checkCompleteness(root.right, 2 * i + 2, count);
    }

    public static boolean isCompleteTree2(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        boolean flag = false;

        queue.add(root);

        while (! queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                if (flag) {
                    return false;
                }else {
                    queue.add(node.left);
                }
            } else {
                flag = true;
            }
            if (node.right != null) {
                if (flag) {
                    return false;
                }else {
                    queue.add(node.right);
                }
            } else {
                flag = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(isCompleteTree(root));
        System.out.println(isCompleteTree2(root));

        root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println(isCompleteTree(root));
        System.out.println(isCompleteTree2(root));

        root = new TreeNode(2147483647);
        System.out.println(isCompleteTree(root));
        System.out.println(isCompleteTree2(root));

        root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);

        System.out.println(isCompleteTree(root));
        System.out.println(isCompleteTree2(root));


        root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);

        System.out.println(isCompleteTree(root));
        System.out.println(isCompleteTree2(root));
    }
}
