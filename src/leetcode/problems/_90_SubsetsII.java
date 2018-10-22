package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
    Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

    Note: The solution set must not contain duplicate subsets.

    Example:

    Input: [1,2,2]
    Output:
    [
      [2],
      [1],
      [1,2,2],
      [2,2],
      [1,2],
      []
    ]
*/


public class _90_SubsetsII {

    public static class Pair {
        int num, count;

        Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }


    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Pair[] list = new Pair[map.size()];
        int counter = 0;
        for (int num : map.keySet()) {
            list[counter++] = new Pair(num, map.get(num));
        }

        for (int i = 0; i < nums.length; i++) {
            permutationsWithDupsUsingHashMap(list, i, 0, new ArrayList<>(), result);
        }

        return result;
    }


    /*
        Time: O(2 ^ N) This is the worst case if there is no duplicates but if the is a duplicates in the array, the order will be better than that
        Memory: O(2 ^ N)
    */

    public static void permutationsWithDupsUsingHashMap(Pair[] nums, int remaining, int index, List<Integer> list, List<List<Integer>> result) {

        if (remaining < 0) {
            result.add(new ArrayList<>(list));
            return;
        } else if (index >= nums.length) {
            return;
        }


        if (nums[index].count > 0) {
            list.add(nums[index].num);
            nums[index].count--;
            permutationsWithDupsUsingHashMap(nums, remaining - 1, index, list, result);
            nums[index].count++;
            list.remove(list.size() - 1);
        }
        permutationsWithDupsUsingHashMap(nums, remaining, index + 1, list, result);


    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 1};

        List<List<Integer>> result = subsetsWithDup(nums);
        int count = 1;
        for (List<Integer> list : result) {
            System.out.println(count++ + "\t" + list.toString());
        }
    }
}
