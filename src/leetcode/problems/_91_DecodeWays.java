package leetcode.problems;


/*
    A message containing letters from A-Z is being encoded to numbers using the following mapping:

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
    Given a non-empty string containing only digits, determine the total number of ways to decode it.

    Example 1:

    Input: "12"

    Output: 2

    Explanation: It could be decoded as "AB" (1 2) or "L" (12).

    Example 2:

    Input: "226"

    Output: 3

    Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
*/
public class _91_DecodeWays {

    public static int solve(String s, int index) {
        if (index >= s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        int count = 0;

        if (s.charAt(index) == '2') {
            if (index < s.length() - 1 && s.charAt(index + 1) < '7') {
                count += solve(s, index + 2);
            }
        } else if (s.charAt(index) == '1') {
            if (index < s.length() - 1) {
                count += solve(s, index + 2);
            }
        }
        count += solve(s, index + 1);

        return count;
    }


    public static int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        return solve(s, 0);
    }


    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings(""));
        System.out.println(numDecodings("929"));
        System.out.println(numDecodings("919"));
        System.out.println(numDecodings("219"));
        System.out.println(numDecodings("10"));
        System.out.println(numDecodings("010"));
    }
}
