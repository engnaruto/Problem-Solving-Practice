package other.implementations;

import java.util.Arrays;
import java.util.HashMap;

public class longestSubstringWithoutRepeatingCharacters {

    public static int[] dp;
    public static char[] arr;


    /*
        Time: O(N ^ 2)
        Memory: O(N)
    */

    public static int solve(int index) {
        if (index >= arr.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int counter = solve(index + 1);
        int charIndex = find(arr[index], index + 1, counter);

        if (charIndex == -1) {
            return dp[index] = counter + 1;
        } else {
            return dp[index] = charIndex - index;
        }
    }


    /*
        Time: O(N ^ 2)
        Memory: O(N)
    */

    public static int solve() {
        if (arr.length == 0) {
            return 0;
        }

        dp[arr.length - 1] = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int index = find(arr[i], i + 1, dp[i + 1]);

            if (index == -1) {
                dp[i] = dp[i + 1] + 1;
            } else {
                dp[i] = index - i;
            }
        }

        int max = 0;

        for (int i : dp) {
            max = Math.max(max, i);
        }
        return max;
    }


    /*
        Time: O(N ^ 2)
        Memory: O(1)
    */

    public static int solveWithoutUsingDPArray() {
        int dp = 0;
        int max = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = find(arr[i], i + 1, dp);

            if (index == -1) {
                dp++;
            } else {
                max = Math.max(max, dp);
                dp = index - i;
            }
        }
        return Math.max(max, dp);
    }


    /*
        Time: O(N)
        Memory: O(1)
    */

    public static int solveUsingHashing() {
        HashMap<Character, Integer> map = new HashMap<>();
        int dp = 0;
        int max = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = map.getOrDefault(arr[i], -1);

            if (index == -1 || index > i + dp) {
                dp++;
            } else {
                max = Math.max(max, dp);
                dp = index - i;
            }
            map.put(arr[i], i);
        }
        return Math.max(max, dp);
    }

    private static int find(char c, int index, int interval) {
        for (int i = index; i < index + interval; i++) {
            if (arr[i] == c) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String s = "asadfax";

        arr = s.toCharArray();

        dp = new int[arr.length];

        Arrays.fill(dp, -1);
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, solve(i));
        }

        System.out.println(max);

        arr = s.toCharArray();
        dp = new int[arr.length];
        Arrays.fill(dp, -1);

        System.out.println(solve());


        arr = s.toCharArray();
        dp = new int[arr.length];
        Arrays.fill(dp, -1);

        System.out.println(solveWithoutUsingDPArray());

        arr = s.toCharArray();
        dp = new int[arr.length];
        Arrays.fill(dp, -1);

        System.out.println(solveUsingHashing());
    }
}
