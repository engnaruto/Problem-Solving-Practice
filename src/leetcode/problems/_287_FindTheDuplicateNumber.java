package leetcode.problems;

/*
    Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
    prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
    find the duplicate one.

    Example 1:

    Input: [1,3,4,2,2]
    Output: 2

    Example 2:

    Input: [3,1,3,4,2]
    Output: 3

    Note:

        You must not modify the array (assume the array is read only).
        You must use only constant, O(1) extra space.
        Your runtime complexity should be less than O(n ^ 2).
        There is only one duplicate number in the array, but it could be repeated more than once.
*/

import java.util.HashSet;

public class _287_FindTheDuplicateNumber {

    /*
        Time: O(N)
        Memory: O(N)
    */

    public static int findDuplicateUsingSet(int[] nums) {
       HashSet<Integer> set = new HashSet<>();
       for (int i : nums){
           if (set.contains(i)){
               return i;
           }else{
               set.add(i);
           }
       }

       return -1;
    }


    /*
        Time: O(N)
        Memory: O(1)
    */

    public static int findDuplicate(int[] nums) {

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 3, 2};
//        int[] nums = {3, 1, 3, 4, 2};

        System.out.println(findDuplicateUsingSet(nums));
    }
}
