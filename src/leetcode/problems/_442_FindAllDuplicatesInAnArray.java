package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/*
    Given an array of integers, 1 <= a[i] <= n (n = size of array), some elements appear twice and others
    appear once.

    Find all the elements that appear twice in this array.

    Could you do it without extra space and in O(n) runtime?
    Input:
    [4,3,2,7,8,2,3,1]
    Output:
    [2,3]
*/

public class _442_FindAllDuplicatesInAnArray {

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
        int current;
        int correctIndex;

        HashSet<Integer> set = new HashSet<>();

        while (i < nums.length) {
            current = nums[i];
            correctIndex = nums[current - 1];

            if (current == i + 1) {
                i++;
            } else {
                if (correctIndex == current) {
                    set.add(current);
                    i++;
                } else {
                    swap(nums, i, current - 1);
                }
            }
        }

        return new ArrayList<>(set);
    }


    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1, 1, 5, 8};

        System.out.println(findDuplicates(nums).toString());
    }
}
