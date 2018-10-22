package leetcode.problems;


import java.util.ArrayList;
import java.util.List;


/*
    Given a set of distinct integers, nums, return all possible subsets (the power set).

    Note: The solution set must not contain duplicate subsets.

    Example:

    Input: nums = [1,2,3]

    Output:

    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]
*/

public class _78_Subsets {

    /*
        Time: O(N * (2 ^ N))
        Memory: O(2 ^ N)
    */

    public static List<List<Integer>> subsets(int[] nums) {


        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            backTracking(nums, new ArrayList<>(), result, 0, i);
        }
        return result;
    }


    private static void backTracking(int[] nums, ArrayList<Integer> list, List<List<Integer>> result, int i, int target) {

        if (target == 0) {
            ArrayList<Integer> copy = new ArrayList<>();
            copy.addAll(list);
            result.add(copy);
            return;
        } else if (i >= nums.length) {
            return;
        }

        list.add(nums[i]);
        backTracking(nums, list, result, i + 1, target - 1);
        list.remove(list.size() - 1);
        backTracking(nums, list, result, i + 1, target);
    }


    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3};

        List<List<Integer>> result = subsets(nums);

        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }
}
