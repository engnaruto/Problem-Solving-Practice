package leetcode.problems;


import java.util.Arrays;

/*
    Given a string s and a string t, check if s is subsequence of t.

    You may assume that there is only lower case English letters in both s and t.
    t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

    A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
    of the characters without disturbing the relative positions of the remaining characters.
    (ie, "ace" is a subsequence of "abcde" while "aec" is not).

    Example 1:

    s = "abc", t = "ahbgdc"

    Return true.

    Example 2:

    s = "axc", t = "ahbgdc"

    Return false.

    Follow up:

    If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one
    to see if T has its subsequence. In this scenario, how would you change your code?

*/


public class _392_IsSubsequence {

    public static int[][] dp;

    private static int solve(String s, String t, int i, int j) {

        if (i >= s.length()) {
            return 1;
        }

        if (j >= t.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = solve(s, t, i + 1, j + 1);
        } else {
            return dp[i][j] = solve(s, t, i, j + 1);
        }
    }

    /*
        Time: O(N)
        Memory: O(N)
    */

    public static boolean isSubsequence(String s, String t) {
        dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(s, t, 0, 0) == 1;
    }

    /*
         Time: O(N)
         Memory: O(1)
    */

    public static boolean isSubsequenceWithoutDP(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == s.length();
    }


    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));

        System.out.println(isSubsequenceWithoutDP("abc", "ahbgdc"));
        System.out.println(isSubsequenceWithoutDP("axc", "ahbgdc"));
    }
}
