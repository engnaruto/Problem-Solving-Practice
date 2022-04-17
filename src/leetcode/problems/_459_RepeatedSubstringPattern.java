package leetcode.problems;


/*
    Given a non-empty string check if it can be constructed by taking a substring of it
    and appending multiple copies of the substring together. You may assume the given string
    consists of lowercase English letters only and its length will not exceed 10000.

    Example 1:

    Input: "abab"
    Output: True
    Explanation: It's the substring "ab" twice.
    Example 2:

    Input: "aba"
    Output: False
    Example 3:

    Input: "abcabcabcabc"
    Output: True
    Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
*/

public class _459_RepeatedSubstringPattern {


    public static boolean checkChar(String s, int index, char c, int interval) {
        if (index >= s.length()) {
            return true;
        }

        if (s.charAt(index) != c) {
            return false;
        }

        return checkChar(s, index + interval, c, interval);
    }

    public static boolean repeatedSubstringPattern(String s) {

        boolean check;

        int interval;
        for (int divide = 2; divide <= s.length(); divide++) {
            interval = s.length() / divide;
            check = false;
            if (s.length() % divide == 0) {
                check = true;
                for (int i = 0; i < interval; i++) {
                    check = checkChar(s, i + interval, s.charAt(i), interval);
                    if (!check) {
                        break;
                    }
                }
            }

            if (check) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abab";
        System.out.println(repeatedSubstringPattern(s));

        s = "aba";
        System.out.println(repeatedSubstringPattern(s));

        s = "abcabcabcabc";
        System.out.println(repeatedSubstringPattern(s));


        s = "abcxabcabcabcx";
        System.out.println(repeatedSubstringPattern(s));


        s = "xaxaxaxa";
        System.out.println(repeatedSubstringPattern(s));

        s = "bb";
        System.out.println(repeatedSubstringPattern(s));
    }
}
