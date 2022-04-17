package leetcode.problems;


import java.util.ArrayList;
import java.util.List;


/*
    Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

    Find all the elements of [1, n] inclusive that do not appear in this array.

    Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

    Example:

    Input:
    [4,3,2,7,8,2,3,1]

    Output:
    [5,6]
*/

public class _448_FindAllNumbersDisappearedInAnArray {

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /*
        Time: O(N)
        Memory: O(1)
    */

    public static List<Integer> findDuplicates(int[] nums) {

        int i = 0;
        int current = 0;
        int correctIndex;
        List<Integer> list = new ArrayList<>();

        while (i < nums.length) {

            current = nums[i];
            correctIndex = nums[current - 1];

            if (current == i + 1) {
                i++;
            } else {
                if (current != correctIndex) {
                    swap(nums, i, current - 1);
                } else {
                    i++;
                }
            }
        }

        for (i = 0; i < nums.length; i++) {

            if (nums[i] != i + 1) {
                list.add(i + 1);
            }
        }

        return list;
    }


    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        System.out.println(findDuplicates(nums));
    }
}