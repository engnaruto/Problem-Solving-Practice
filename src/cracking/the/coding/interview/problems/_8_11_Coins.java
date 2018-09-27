package cracking.the.coding.interview.problems;


import java.util.Arrays;

/*
    8.11
    Coins: Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents),
    and pennies (1 cent), write code to calculate the number of ways of representing n cents.
*/
public class _8_11_Coins {


    public static int[] arr = {25, 10, 5, 1};
    public static int[][] dp = new int[1000][arr.length];

    /*
        Time: O(N * C) C: Number of coins
        Memory: O(N * C) C: Number of coins
    */

    public static int coins(int n, int i) {
        if (n == 0) {
            return 1;
        } else if (i == arr.length || n < 0) {
            return 0;
        }

        if (dp[n][i] != -1) {
            return dp[n][i];
        }

        int count = 0;

        count = coins(n - arr[i], i);

        count += coins(n, i + 1);

        return dp[n][i] = count;
    }


    public static void main(String[] args) {
        int n = 25;

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(coins(n, 0));


    }
}
