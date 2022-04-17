package leetcode.problems;


import java.util.ArrayList;
import java.util.List;


/*
    Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

    Example:

    Input: 3

    Output:

    [
      [1,null,3,2],
      [3,2,null,1],
      [3,1,null,null,2],
      [2,1,3],
      [1,null,2,null,3]
    ]

    Explanation:

    The above output corresponds to the 5 unique BST's shown below:

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
*/

public class _95_UniqueBinarySearchTreesII {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    public static List<TreeNode> generateTrees(int low, int high) {
        List<TreeNode> result = new ArrayList<>();

        if (low > high) {
            result.add(null);
            return result;
        }

        for (int i = low; i <= high; i++) {
            List<TreeNode> leftSubTrees = generateTrees(low, i - 1);
            List<TreeNode> rightSubTrees = generateTrees(i + 1, high);

            for (TreeNode leftTreeNode : leftSubTrees) {
                for (TreeNode rightTreeNode : rightSubTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTreeNode;
                    root.right = rightTreeNode;
                    result.add(root);
                }
            }
        }
        return result;
    }

    public static void dfs(TreeNode root, ArrayList<String> list) {
        if (root == null) {
            list.add("null");
            return;
        }

        list.add(root.val + "");
        if (root.left == null && root.right == null) {
            return;
        }
        dfs(root.left, list);
        dfs(root.right, list);
    }

    public static void main(String[] args) {
        generateTrees(3).forEach(e -> {
            ArrayList<String> list = new ArrayList<>();
            dfs(e, list);
            System.out.println(list.toString());
        });
        generateTrees(4).forEach(e -> {
            ArrayList<String> list = new ArrayList<>();
            dfs(e, list);
            System.out.println(list.toString());
        });
    }
}
