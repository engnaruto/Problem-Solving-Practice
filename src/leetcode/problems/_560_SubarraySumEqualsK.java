package leetcode.problems;


import java.util.HashMap;

/*
    Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

    Example 1:
    Input:nums = [1,1,1], k = 2
    Output: 2
    Note:
    The length of the array is in range [1, 20,000].
    The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
*/

public class _560_SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0, 1);
        for (int i : nums) {
            sum += i;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{-1, -1, 1}, 0));

        System.out.println(subarraySum(new int[]{1}, 0));

        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));

        System.out.println(subarraySum(new int[]{10, 5, 2, 7, 1, 9}, 10));
    }
}