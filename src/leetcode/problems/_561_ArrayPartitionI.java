import java.util.*;

/*
    Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn)
    which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

    Example 1:
    Input: [1,4,3,2]

    Output: 4

    Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).

    Note:
    - n is a positive integer, which is in the range of [1, 10000].
    - All the integers in the array will be in the range of [-10000, 10000].
*/

public class _561_ArrayPartitionI {

    /*
        Note: I understood this solution from this link: https://leetcode.com/problems/array-partition-i/discuss/102170/Java-Solution-Sorting.-And-rough-proof-of-algorithm, The problem can have redundant numbers.
        Time: O(N)
        Memory: O(1) Constant fot all test cases
    */

    public static int arrayPairSumWithoutSorting(int[] nums) {

        int[] isUsed = new int[20001];

        for (int i : nums) {
            isUsed[i + 10000]++;
        }

        boolean isOdd = true;
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < isUsed.length && n > 0; i++) {
            if (isUsed[i] != 0) {
                while (isUsed[i] != 0) {
                    if (isOdd) {
                        sum += i - 10000;
                    }
                    isOdd = !isOdd;
                    isUsed[i]--;
                    n--;
                }
            }
        }
        return sum;
    }

    /*
        Time: O(NLog(N))
        Memory: O(1)
    */

    public static int arrayPairSum(int[] nums) {

        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {


        int[][] tests = {
                {1, 4, 3, 2},
                {-100, -235, 5, 10, 100, 50, 0, 500, -1000, 1},
                {1, 2, 3, 2}
        };

        for (int[] test : tests) {
            System.out.println(arrayPairSum(test));
            System.out.println(arrayPairSumWithoutSorting(test));
        }
    }
}
