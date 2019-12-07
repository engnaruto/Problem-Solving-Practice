package leetcode.problems;

import java.util.Arrays;

/*
    You are climbing a stair case. It takes n steps to reach to the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    Note: Given n will be a positive integer.

    Example 1:

    Input: 2

    Output: 2

    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps

    Example 2:

    Input: 3

    Output: 3

    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step
*/

public class _70_ClimbingStairs {

    public static int[] dp;

    private static int solve(int i, int n) {
        if (i > n - 1) {
            return 0;
        }
        if (i == n - 1) {
            return 1;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        return dp[i] = solve(i + 1, n) + solve(i + 2, n);
    }


    /*
        Time: O(N)
        Memory: O(N)
    */

    public static int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, n) + solve(1, n);
    }


    /*
        Time: O(N)
        Memory: O(N)
    */

    public static int climbStairsIterative(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] dp = new int[n];
        dp[n - 1] = 1;
        dp[n - 2] = 1;

        for (int i = n - 3; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }

        return dp[0] + dp[1];
    }


    /*
        Time: O(N)
        Memory: O(1)
    */

    public static int climbStairsIterativeWithoutUsingMemory(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int b1 = 1;
        int b2 = 1;

        int current = 0;

        for (int i = n - 2; i >= 0; i--) {
            current = b1 + b2;

            b1 = b2;
            b2 = current;
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(0));
        System.out.println(climbStairsIterative(0));
        System.out.println(climbStairsIterativeWithoutUsingMemory(0));

        System.out.println(climbStairs(2));
        System.out.println(climbStairsIterative(2));
        System.out.println(climbStairsIterativeWithoutUsingMemory(2));

        System.out.println(climbStairs(3));
        System.out.println(climbStairsIterative(3));
        System.out.println(climbStairs(3));

        System.out.println(climbStairs(20));
        System.out.println(climbStairsIterative(20));
        System.out.println(climbStairsIterativeWithoutUsingMemory(20));

    }
}

