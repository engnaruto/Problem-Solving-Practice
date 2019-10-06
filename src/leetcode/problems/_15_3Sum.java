package leetcode.problems;


import java.util.*;


/*
    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
    Find all unique triplets in the array which gives the sum of zero.

    Note:

    The solution set must not contain duplicate triplets.

    Example:

    Given array nums = [-1, 0, 1, 2, -1, -4],

    A solution set is:
    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]
*/


public class _15_3Sum {

    /*
        Time: O(N ^ 3)
        Memory: O(1)
    */

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);

                        result.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }


    /*
        Time: O(N ^ 2 * Log(N))
        Memory: O(1)
    */

    public static List<List<Integer>> threeSumUsingBinarySearch(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        int n = 0;
        int index = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                n = -(nums[i] + nums[j]);

                index = Arrays.binarySearch(nums, j + 1, nums.length, n);
                if (index >= 0) {
                    ArrayList<Integer> triples = new ArrayList<>();
                    triples.add(nums[i]);
                    triples.add(nums[j]);
                    triples.add(n);
                    result.add(triples);
                }
            }
        }
        return result;
    }


    /*
        Time: O(N ^ 2)
        Memory: O(N)
    */

    public static List<List<Integer>> threeSumUsingTwoPointers(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        int left, right;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            left = i + 1;
            right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] == -nums[i]) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);

                    left++;
                    right--;

                    while (left < nums.length && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (right > 0 && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] > -nums[i]) {
                    right--;
//                    while (right > 0 && nums[right] == nums[right + 1]) {
//                        right--;
//                    }
                } else {
                    left++;
//                    while (left < nums.length && nums[left] == nums[left - 1]) {
//                        left++;
//                    }
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, -2, -1};
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[]{0, 0, 0, 0};

        for (List<Integer> list : threeSum(nums)) {
            System.out.println(list.toString());
        }
        System.out.println("**********************");
        for (List<Integer> list : threeSumUsingBinarySearch(nums)) {
            System.out.println(list.toString());
        }

        System.out.println("**********************");
        for (List<Integer> list : threeSumUsingTwoPointers(nums)) {
            System.out.println(list.toString());
        }
    }
}

