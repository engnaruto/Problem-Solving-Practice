package leetcode.problems;


/*
    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum
    and return its sum.

    Example:

    Input: [-2,1,-3,4,-1,2,1,-5,4],

    Output: 6

    Explanation: [4,-1,2,1] has the largest sum = 6.

    Follow up:

    If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
    which is more subtle.
*/

public class _53_MaximumSubarray {


    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0];
        int lastSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            lastSum = Math.max(nums[i], nums[i] + lastSum);
            maxSum = Math.max(maxSum, lastSum);
        }
        return maxSum;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArray(nums));
    }
}
