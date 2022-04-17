package leetcode.problems;

/*
    Given a string, your task is to count how many palindromic substrings in this string.

    The substrings with different start indexes or end indexes are counted as different substrings even
    they consist of same characters.

    Example 1:
    Input: "abc"
    Output: 3
    Explanation: Three palindromic strings: "a", "b", "c".

    Example 2:
    Input: "aaa"
    Output: 6
    Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

    Note:
    The input string length won't exceed 1000.
*/

import java.util.Arrays;

public class _647_PalindromicSubstrings {

    public static int[][] dp = new int[1000][1000];

    public static int isPalindrome(String s, int start, int end) {
        if (start > end || start < 0 || end < 0) {
            return 0;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        if (start == end) {
            return dp[start][end] = 1;
        } else if ((isPalindrome(s, start + 1, end - 1) == 1 || ((start - end == -1) && (end - 1) >= 0)) && s.charAt(start) == s.charAt(end)) {
            return dp[start][end] = 1;
        }

        return dp[start][end] = 0;
    }


    public static int countSubstrings(String s) {

        if (s.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (isPalindrome(s, i, j) == 1) {
                    count += isPalindrome(s, i, j);
//                    System.out.println(i + " - " + j + " => " + s.substring(i, j + 1));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        String s = "abcba";

        System.out.println(countSubstrings(s));
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));


    }
}
