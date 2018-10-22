import java.util.*;


/*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    Example:

    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,

    return [0, 1].
*/

public class _1_TwoSum {


    /*
        Time: O(t) t: the time taken from the cpu to process the tasks
        Memory: O(1) The memory will not exceed O(26)
    */

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int secondNum = 0;
        for (int i = 0; i < nums.length; i++) {
            secondNum = target - nums[i];

            if (map.containsKey(secondNum)) {
                return new int[]{map.get(secondNum), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }


    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};

        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
