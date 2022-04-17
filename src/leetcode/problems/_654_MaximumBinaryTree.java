package leetcode.problems;


import java.util.Arrays;

/*
    Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

    The root is the maximum number in the array.
    The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
    The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
    Construct the maximum tree by the given array and output the root node of this tree.

    Example 1:

    Input: [3,2,1,6,0,5]

    Output: return the tree root node representing the following tree:

          6
        /   \
       3     5
        \    /
         2  0
           \
            1

    Note:

    The size of the given array will be in the range [1,1000].
*/
public class _654_MaximumBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static TreeNode solve(int left, int right, int[] nums) {
        if (right < left) {
            return null;
        }

        if (left == right) {
            return new TreeNode(nums[left]);
        }

        int maxIndex = getMax(left, right, nums);

        TreeNode root = new TreeNode(nums[maxIndex]);

        root.left = solve(left, maxIndex - 1, nums);
        root.right = solve(maxIndex + 1, right, nums);

        return root;
    }

    public static int getMax(int left, int right, int[] nums) {
        int maxIndex = left;
        int max = nums[left];
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /*
        Time: O(N ^ 2) because of getMax()
        Memory: O(N)
    */

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return solve(0, nums.length - 1, nums);
    }


    public static void main(String[] args) {
        constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }
}