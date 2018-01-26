/*
Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:
Input:
	Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7
Output:
Merged tree:
	     3
	    / \
	   4   5
	  / \   \
	 5   4   7
Note: The merging process must start from the root nodes of both trees.
*/

/*
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class _617_MergeTwoBinaryTrees {

    /*
        Time: O(max(nodes(t1),nodes(t2)))
        Memory: O(max(nodes(t1),nodes(t2)))
    */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static TreeNode merge(TreeNode t1, TreeNode t2, TreeNode t3) {
        if (t1 == null && t2 == null) {
            return null;
        }
        int t1Value = 0;
        int t2Value = 0;

        if (t1 != null) {
            t1Value = t1.val;
        }
        if (t2 != null) {
            t2Value = t2.val;
        }

        t3 = new TreeNode(t1Value + t2Value);
        t3.left = new TreeNode(-1);
        t3.right = new TreeNode(-1);

        if (t1 != null && t2 != null) {
            t3.left = merge(t1.left, t2.left, t3.left);
            t3.right = merge(t1.right, t2.right, t3.right);
        } else if (t1 == null) {
            t3.left = merge(null, t2.left, t3.left);
            t3.right = merge(null, t2.right, t3.right);
        } else {
            t3.left = merge(t1.left, null, t3.left);
            t3.right = merge(t1.right, null, t3.right);
        }
        return t3;
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode t3 = new TreeNode(5);
        t3 = merge(t1, t2, t3);
        return t3;
    }

    public static void dfs(TreeNode t) {
        if (t == null) {
            return;
        }

        System.out.println(t.val);
        dfs(t.left);
        dfs(t.right);
    }

    public static void main(String[] args) {
        TreeNode t11 = new TreeNode(1);
        TreeNode t12 = new TreeNode(3);
        TreeNode t13 = new TreeNode(2);
        TreeNode t14 = new TreeNode(5);

        t11.left = t12;
        t11.right = t13;
        t12.left = t14;

        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(1);
        TreeNode t23 = new TreeNode(3);
        TreeNode t24 = new TreeNode(4);
        TreeNode t25 = new TreeNode(7);

        t21.left = t22;
        t21.right = t23;
        t22.right = t24;
        t23.right = t25;


        TreeNode[][] tests = {
                {t11, t21}
        };

        for (TreeNode[] test : tests) {
            dfs(mergeTrees(test[0], test[1]));
        }
    }
}
