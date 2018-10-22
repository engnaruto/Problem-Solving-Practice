package leetcode.problems;

import java.util.*;


/*
    Given a non-empty array of integers, return the k most frequent elements.

    Example 1:

    Input: nums = [1,1,1,2,2,3], k = 2

    Output: [1,2]

    Example 2:

    Input: nums = [1], k = 1

    Output: [1]

    Note:

        - You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
        - Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/


public class _347_TopKFrequentElements {

    /*
        Time: O(N + a * Log(a), a: The number of unique elements in the array
        Memory: O(a), a: The number of unique elements in the array
        Note: There is a linear time solution using Bucket Sort
    */

    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        int[][] frequency = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            frequency[i][0] = entry.getKey();
            frequency[i][1] = entry.getValue();
            i++;
        }


        Arrays.sort(frequency, (a, b) -> b[1] - a[1]);

        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < k; j++) {
            list.add(frequency[j][0]);
        }
        return list;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 3, 3, 3};
        int k = 2;

        System.out.println(topKFrequent(nums, k).toString());
    }
}
