import java.util.*;

/*
    8.1
    Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps,
    or 3 steps at a time. Implement a method to count how many possible ways the child can run up the
    stairs.
*/

public class _8_1_TripleStep {

    public static int[] dp = new int[1000];


    /*
        Time: O(N)
        Memory: O(N)
    */

    public static int tripleStep(int n) {
        if (n == 0) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int counter = 0;
        for (int i = 1; i <= 3; i++) {
            if (n - i >= 0) {
                counter += tripleStep(n - i);
            }
        }
        return dp[n] = counter;
    }

    public static void main(String[] args) {
        Arrays.fill(dp, -1);
        System.out.println(tripleStep(2));
    }

}
