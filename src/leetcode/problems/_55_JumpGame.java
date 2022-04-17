package leetcode.problems;

/*
    Given an array of non-negative integers, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Determine if you are able to reach the last index.

    Example 1:

    Input: [2,3,1,1,4]

    Output: true

    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

    Example 2:

    Input: [3,2,1,0,4]

    Output: false

    Explanation: You will always arrive at index 3 no matter what. Its maximum
                 jump length is 0, which makes it impossible to reach the last index.
*/

public class _55_JumpGame {

    public static boolean solve1(int[] nums, int i) {
        if (i >= nums.length - 1) {
            return true;
        }

        for (int k = nums[i]; k > 0; k--) {
            if (solve1(nums, i + k)) {
                return true;
            }
        }
        return false;
    }

    public static boolean solve2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                int interval;
                boolean passed = false;
                for (int j = i - 1; j >= 0; j--) {
                    interval = i - j;
                    if (nums[j] > interval) {
                        passed = true;
                        break;
                    }
                }
                if (!passed) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean solve(int[] nums) {
        int i = 0;

        while (i < nums.length - 1) {
            if (nums[i] == 0) {
                int interval;
                boolean passed = false;
                int j = i - 1;
                for (; j >= 0; j--) {
                    interval = i - j;
                    if (nums[j] > interval) {
                        passed = true;
                        break;
                    }
                }
                if (!passed) {
                    return false;
                }
                i = j + nums[j];
            } else {
                i += nums[i];
            }
        }
        return true;
    }

    public static boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }

        return solve(nums);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        System.out.println(canJump(nums));

        nums = new int[]{3, 2, 1, 0, 4};

        System.out.println(canJump(nums));

        nums = new int[]{3, 0, 0, 0};

        System.out.println(canJump(nums));

        nums = new int[]{2, 2, 0, 2, 0, 2, 0, 0, 2, 0};

        System.out.println(canJump(nums));
    }
}
