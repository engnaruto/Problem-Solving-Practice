package leetcode.problems;

import java.util.HashSet;


/*
    Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

    Your algorithm should run in O(n) complexity.

    Example:

    Input: [100, 4, 200, 1, 3, 2]

    Output: 4

    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
*/

public class _128_LongestConsecutiveSequence {


    /*
        Time: O(N)
        Memory: O(N)
    */

    public static int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        int max = 0;
        int count = 0;

        for (int i : set) {
            if (!set.contains(i - 1)) {
                int x = i;

                while (set.contains(x)) {
                    x++;
                    count++;
                }
                max = Math.max(max, count);
                count = 0;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println(longestConsecutive(nums));
    }
}
