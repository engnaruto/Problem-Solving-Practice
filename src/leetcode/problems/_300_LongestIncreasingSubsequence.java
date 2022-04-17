package leetcode.problems;


/*
    Given an unsorted array of integers, find the length of longest increasing subsequence.

    Example:

    Input: [10,9,2,5,3,7,101,18]

    Output: 4

    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

    Note:

     - There may be more than one LIS combination, it is only necessary for you to return the length.

     - Your algorithm should run in O(n ^ 2) complexity.

    Follow up: Could you improve it to O(n log n) time complexity?
*/

import java.util.Arrays;

public class _300_LongestIncreasingSubsequence {


    public static int[][] dp;

    public static int lengthOfLIS(int[] nums) {


        dp = new int[nums.length + 1][nums.length + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return lengthOfLIS(nums, 0, -1);
    }


    public static int lengthOfLIS(int[] nums, int index, int prev) {

        if (index >= nums.length) {
            return 0;
        }


        if (prev != -1 && dp[index][prev] != -1) {
            return dp[index][prev];
        }
        int choose = 0;
        int choose2 = 0;

        if (prev != -1 && nums[index] > nums[prev]) {
            choose = lengthOfLIS(nums, index + 1, index) + 1;
        }

        if (prev == -1) {
            choose = lengthOfLIS(nums, index + 1, index) + 1;
            choose2 = lengthOfLIS(nums, index + 1, -1);
        } else {
            choose2 = lengthOfLIS(nums, index + 1, prev);
        }

        if (prev == -1) {
            return dp[index][index] = Math.max(choose, choose2);
        } else {
            return dp[index][prev] = Math.max(choose, choose2);
        }
    }


    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(lengthOfLIS(nums));
    }


}
