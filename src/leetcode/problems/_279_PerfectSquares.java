package leetcode.problems;


import java.util.Arrays;

/*
    Given a positive integer n, find the least number of perfect square numbers
    (for example, 1, 4, 9, 16, ...) which sum to n.

    Example 1:

    Input: n = 12

    Output: 3

    Explanation: 12 = 4 + 4 + 4.

    Example 2:

    Input: n = 13

    Output: 2

    Explanation: 13 = 4 + 9.
*/

public class _279_PerfectSquares {

    public static int numSquares(int[][] dp, int sum, int i) {

        if (i == 0 && sum != 0) {
            return dp[sum][i] = Integer.MAX_VALUE / 2;
        } else if (sum == 0) {
            return 0;
        }

        if (dp[sum][i] != -1) {
            return dp[sum][i];
        }

        int choose1 = Integer.MAX_VALUE / 2;
        int choose2 = Integer.MAX_VALUE / 2;


        if (sum >= i * i) {
            choose1 = numSquares(dp, sum - (i * i), i) + 1;
        }
        choose2 = numSquares(dp, sum, i - 1);

        return dp[sum][i] = Math.min(choose1, choose2);

    }


    public static int numSquares(int n) {
        int[][] dp = new int[n + 1][(int) Math.sqrt(n) + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return numSquares(dp, n, (int) Math.sqrt(n));
    }

    public static void main(String[] args) {

        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }
}
