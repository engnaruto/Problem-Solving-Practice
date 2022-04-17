package leetcode.problems;

/*
    Given an input string (s) and a pattern (p), implement regular expression matching with support
    for '.' and '*'.

    '.' Matches any single character.
    '*' Matches zero or more of the preceding element.
    The matching should cover the entire input string (not partial).

    Note:

    s could be empty and contains only lowercase letters a-z.
    p could be empty and contains only lowercase letters a-z, and characters like . or *.

    Example 1:

    Input:
    s = "aa"
    p = "a"

    Output: false

    Explanation: "a" does not match the entire string "aa".

    Example 2:

    Input:
    s = "aa"
    p = "a*"

    Output: true

    Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once,
                 it becomes "aa".

    Example 3:

    Input:
    s = "ab"
    p = ".*"

    Output: true

    Explanation: ".*" means "zero or more (*) of any character (.)".

    Example 4:

    Input:
    s = "aab"
    p = "c*a*b"

    Output: true

    Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".

    Example 5:

    Input:
    s = "mississippi"
    p = "mis*is*p*."
    Output: false
*/

public class _10_RegularExpressionMatching {


    public static boolean isMatch(String s, String p) {

        if (s.isEmpty() && (p.matches("\\*"))) {
            return true;
        }

        char currentS;
        char currentP;

        int i = 0;
        int j = 0;

        while (i < s.length() && j < p.length()) {
            currentS = s.charAt(i);
            currentP = p.charAt(j);

            if (currentP == '.') {
                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    return true;
                }
                currentP = currentS;
            }

            if (currentP == '*') {
                j++;
                continue;
            }

            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {

                while (currentS == currentP) {
                    i++;
                    if (i < s.length()) {
                        currentS = s.charAt(i);
                    } else {
                        break;
                    }
                }

                j += 2;
            } else {
                if (currentS != currentP) {
                    return false;
                }
                i++;
                j++;
            }
        }

        if (i < s.length() || j < p.length()) {
            return false;
        }

        return true;
    }


    public static void main(String[] args) {
        String s = "aa";
        String p = "a";
        System.out.println(isMatch(s, p) + "\t-> false");

        s = "aab";
        p = "a*ab";
        System.out.println(isMatch(s, p) + "\t-> true");
//
//        s = "ab";
//        p = ".*";
//        System.out.println(isMatch(s, p) + "\t-> true");
//
//        s = "aab";
//        p = "c*a*b";
//        System.out.println(isMatch(s, p) + "\t-> true");
//
//        s = "mississippi";
//        p = "mis*is*p*.";
//        System.out.println(isMatch(s, p) + "\t-> false");
//
//        s = "";
//        p = "c*";
//        System.out.println(isMatch(s, p));
//
//        System.out.println("".matches(".*"));
    }
}
