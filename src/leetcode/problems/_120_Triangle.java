package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

    Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent
    numbers on the row below.

    For example, given the following triangle

    [
         [2],
        [3,4],
       [6,5,7],
      [4,1,8,3]
    ]

    The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

    Note:

        Bonus point if you are able to do this using only O(n) extra space,
        where n is the total number of rows in the triangle.
*/

public class _120_Triangle {


    public static int minimumTotal(int[][] dp, List<List<Integer>> triangle, int i, int j) {

        if (i >= triangle.size()) {
            return dp[i][j] = 0;
        }

        if (j >= triangle.get(i).size()) {
            return dp[i][j] = Integer.MAX_VALUE / 10;
        }

        if (dp[i][j] != Integer.MAX_VALUE / 10) {
            return dp[i][j];
        }

        int choose1 = minimumTotal(dp, triangle, i + 1, j) + triangle.get(i).get(j);
        int choose2 = minimumTotal(dp, triangle, i + 1, j + 1) + triangle.get(i).get(j);

        return dp[i][j] = Math.min(choose1, choose2);
    }

    public static int minimumTotal2(List<List<Integer>> triangle) {

        int[] dp = new int[triangle.size()];

        for (int i = triangle.size()- 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i] = triangle.get(i).get(j)+Math.min(dp[i],dp[i+1]);
            }
        }

        return dp[0];
    }

    public static int minimumTotal(List<List<Integer>> triangle) {

        int[][] dp = new int[triangle.size() + 1][triangle.get(triangle.size() - 1).size() + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 10);
        }

        return minimumTotal(dp, triangle, 0, 0);
    }

    public static void main(String[] args) {


        List<List<Integer>> triangle = new ArrayList<>();

        ArrayList<Integer> x1 = new ArrayList<>();
        x1.add(2);
        ArrayList<Integer> x2 = new ArrayList<>();
        x2.add(3);
        x2.add(4);
        ArrayList<Integer> x3 = new ArrayList<>();
        x3.add(6);
        x3.add(5);
        x3.add(7);
        ArrayList<Integer> x4 = new ArrayList<>();
        x4.add(4);
        x4.add(1);
        x4.add(8);
        x4.add(3);

        triangle.add(x1);
        triangle.add(x2);
        triangle.add(x3);
        triangle.add(x4);

        System.out.println(minimumTotal(triangle));
    }
}
