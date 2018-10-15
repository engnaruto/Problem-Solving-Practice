package other.implementations;

import java.util.Arrays;

public class LIS {

    public static int[] dp;


    /*
        Time: O(N)
        Memory: O(N)
    */

    public static int lIS(int[] arr, int index) {

        if (index == arr.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int res = 0;

        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] >= arr[index])
                res = Math.max(res, lIS(arr, i));
        }
        ++res;
        return dp[index] = res;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4, 7, 5, 6, 9};
        dp = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(lIS(arr, 0));
    }
}
