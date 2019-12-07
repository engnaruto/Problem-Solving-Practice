package leetcode.problems;

import java.util.Arrays;

/*
    On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

    Once you pay the cost, you can either climb one or two steps.
    You need to find minimum cost to reach the top of the floor,
    and you can either start from the step with index 0, or the step with index 1.

    Example 1:

    Input: cost = [10, 15, 20]

    Output: 15

    Explanation: Cheapest is start on cost[1], pay that cost and go to the top.

    Example 2:

    Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]

    Output: 6

    Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].

    Note:

        cost will have a length in the range [2, 1000].

        Every cost[i] will be an integer in the range [0, 999].
*/

public class _746_MinCostClimbingStairs {

    public static int[] dp;

    private static int solve(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        return dp[i] = Math.min(solve(cost, i + 1), solve(cost, i + 2)) + cost[i];
    }


    /*
        Time: O(N)
        Memory: O(N)
    */

    public static int minCostClimbingStairs(int[] cost) {

        dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);

        return Math.min(solve(cost, 0), solve(cost, 1));
    }


    /*
        Time: O(N)
        Memory: O(1)
    */

    public static int minCostClimbingStairsIterative(int[] cost) {

        int b1 = cost[0];
        int b2 = cost[1];

        int current;

        for (int i = 2; i < cost.length; i++) {
            current = Math.min(b1,b2) + cost[i];
            b1 = b2;
            b2 = current;
        }

        return Math.min(b1, b2);
    }

    public static void main(String[] args) {
        int[] cost = new int[]{10, 15, 20};

        System.out.println(minCostClimbingStairs(cost));
        System.out.println(minCostClimbingStairsIterative(cost));


        cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        System.out.println(minCostClimbingStairs(cost));
        System.out.println(minCostClimbingStairsIterative(cost));
    }
}
