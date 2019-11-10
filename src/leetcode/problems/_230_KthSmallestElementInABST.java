package leetcode.problems;


/*
    Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

    Note:

    You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

    Example 1:

    Input: root = [3,1,4,null,2], k = 1

       3
      / \
     1   4
      \
       2

    Output: 1

    Example 2:

    Input: root = [5,3,6,2,4,null,null,1], k = 3

           5
          / \
         3   6
        / \
       2   4
      /
     1

    Output: 3

    Follow up:

    What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
    How would you optimize the kthSmallest routine?
 */

public class _230_KthSmallestElementInABST {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static boolean found = false;
    public static int index = 0;

    /*
        Time: O(N)
        Memory: O(H)
    */

    public static int kthSmallest(TreeNode root, int k) {
        found = false;
        index = 0;
        return dfs(root, k);
    }

    public static int dfs(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        int val = dfs(root.left, k);

        if (found) {
            return val;
        }

        index++;
        if (index == k) {
            found = true;
            return root.val;
        }

        val = dfs(root.right, k);
        return val;
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(1);
        n.left.right = new TreeNode(2);
        n.right = new TreeNode(4);

        System.out.println(kthSmallest(n, 3));

        n = new TreeNode(5);
        n.left = new TreeNode(3);
        n.left.left = new TreeNode(2);
        n.left.right = new TreeNode(20);
        n.left.left.left = new TreeNode(1);
        n.right = new TreeNode(60);

        System.out.println(kthSmallest(n, 2));
    }
}
