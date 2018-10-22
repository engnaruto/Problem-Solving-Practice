package leetcode.problems;


import java.util.Arrays;


/*
    You are given coins of different denominations and a total amount of money amount.
    Write a function to compute the fewest number of coins that you need to make up that amount.
    If that amount of money cannot be made up by any combination of the coins, return -1.

    Example 1:

    Input: coins = [1, 2, 5], amount = 11

    Output: 3

    Explanation: 11 = 5 + 5 + 1

    Example 2:

    Input: coins = [2], amount = 3

    Output: -1

    Note:

    You may assume that you have an infinite number of each kind of coin.
*/


public class _322_CoinChange {


    public static int[][] dp;


    /*
        Time: O(N * A) N: Number of coins, A: Amount
        Memory: O(N * A)
    */

    public static int coinChange(int[] coins, int amount) {

        dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -5);
        }
        Arrays.sort(coins);
        int result = coinChange(coins, 0, amount);

        return result >= Integer.MAX_VALUE / 3 ? -1 : result;

    }


    public static int coinChange(int[] coins, int index, int amount) {

        if (amount == 0) {
            return 0;
        } else if (index >= coins.length) {
            return Integer.MAX_VALUE / 2;
        }

        if (dp[index][amount] != -5) {
            return dp[index][amount];
        }
        int choose = Integer.MAX_VALUE / 2;


        if (amount >= coins[index]) {
            choose = coinChange(coins, index, amount - coins[index]) + 1;
        }

        choose = Math.min(choose, coinChange(coins, index + 1, amount));

        return dp[index][amount] = choose;
    }


    public static void main(String[] args) {
        int[] coins = {484, 395, 346, 103, 329};

        System.out.println(coinChange(coins, 4259));
    }
}
