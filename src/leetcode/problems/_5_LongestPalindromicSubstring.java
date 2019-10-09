package leetcode.problems;


import java.util.Arrays;

/*
    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

    Example 1:

    Input: "babad"

    Output: "bab"

    Note: "aba" is also a valid answer.

    Example 2:

    Input: "cbbd"

    Output: "bb"
*/

public class _5_LongestPalindromicSubstring {

    /*
        Time: O(N ^ 2)
        Memory: O(N ^ 2)
    */

    public static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }

        int[][] dp = new int[s.length() + 1][s.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j + 1] + 2;
                    }
                } else {
                    dp[i][j] = Integer.MIN_VALUE / 10;
                }
            }
        }

        int maxPalindrome = 0;
        int maxI = 0;
        int maxJ = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (maxPalindrome < dp[i][j]) {
                    maxPalindrome = dp[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        return s.substring(maxJ, maxI + 1);
    }

    /*
        Time: O(N ^ 2)
        Memory: O(N ^ 2)
    */

    public static String longestPalindromeRecursive(String s) {

        if (s.isEmpty()) {
            return "";
        }

        int[][] dp = new int[s.length() + 1][s.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    longestPalindromeRecursive(dp, s, i, j);
                }
            }
        }

        int maxPalindrome = 0;
        int maxI = 0;
        int maxJ = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (maxPalindrome < dp[i][j]) {
                    maxPalindrome = dp[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        return s.substring(maxI, maxJ + 1);
    }

    public static int longestPalindromeRecursive(int[][] dp, String s, int i, int j) {

        if (i > j) {
            return dp[i][j] = Integer.MIN_VALUE / 10;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            if (i == j) {
                return dp[i][j] = 1;
            } else if (j - i == 1) {
                return dp[i][j] = 2;
            }
            return dp[i][j] = longestPalindromeRecursive(dp, s, i + 1, j - 1) + 2;
        }

        return dp[i][j] = Integer.MIN_VALUE / 10;
    }


    public static void main(String[] args) {

        System.out.println(longestPalindrome("abcda"));
        System.out.println(longestPalindrome("abb"));
        System.out.println(longestPalindrome("abbabbacxcabb"));

        System.out.println(longestPalindromeRecursive("abcda"));
        System.out.println(longestPalindromeRecursive("abb"));
        System.out.println(longestPalindromeRecursive("abbabbacxcabb"));
    }
}
