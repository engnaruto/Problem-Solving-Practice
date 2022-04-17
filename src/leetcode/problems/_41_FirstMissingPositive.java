package leetcode.problems;


import java.util.HashSet;


/*
    Given an unsorted integer array, find the smallest missing positive integer.

    Example 1:

    Input: [1,2,0]

    Output: 3

    Example 2:

    Input: [3,4,-1,1]

    Output: 2

    Example 3:

    Input: [7,8,9,11,12]

    Output: 1

    Note:

    Your algorithm should run in O(n) time and uses constant extra space.
*/


public class _41_FirstMissingPositive {

    /*
        Time: O(N)
        Memory: O(N)
    */

    public static int firstMissingPositiveUsingSet(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        int counter = 1;
        while (true) {
            if (!set.contains(counter)) {
                return counter;
            }
            counter++;
        }
    }


    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /*
        Time: O(N)
        Memory: O(1)
    */

    public static int firstMissingPositive(int[] nums) {

        if (nums.length == 0) {
            return 1;
        }

        int index;

        for (int i = 0; i < nums.length; i++) {
            index = nums[i];

            if (index > 0 && index < nums.length && nums[index - 1] != index) {
                swap(nums, index - 1, i);
                i--;
            }
        }


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums[nums.length - 1] + 1;
    }

    public static void main(String[] args) {
//        int[] nums = {7, 8, 9, 1, 12};
//        int[] nums = {3, 4, -1, 1};
//        int[] nums = {1, 2, 0};
        int[] nums = {-1, 4, 2, 1, 9, 10};

        System.out.println(firstMissingPositive(nums));
    }
}
