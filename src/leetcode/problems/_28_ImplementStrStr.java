package leetcode.problems;


/*
    Implement strStr().

    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    Example 1:

    Input: haystack = "hello", needle = "ll"

    Output: 2

    Example 2:

    Input: haystack = "aaaaa", needle = "bba"

    Output: -1

    Clarification:

    What should we return when needle is an empty string? This is a great question to ask during an interview.

    For the purpose of this problem, we will return 0 when needle is an empty string.
    This is consistent to C's strStr() and Java's indexOf().
*/

public class _28_ImplementStrStr {


    /*
        Time: O(NM)
        Memory: O(1)
        Node: This problem can be solved using KMP Algorithm.
    */

    public static int strStr(String haystack, String needle) {
        if (haystack.isEmpty() && needle.isEmpty()){
            return 0;
        }

        if (needle.length() > haystack.length() ) {
            return -1;
        }

        boolean found;
        for (int i = 0; i < haystack.length(); i++) {
            found = true;
            int k = i;
            for (int j = 0; j < needle.length(); j++) {
                if (k >= haystack.length() || haystack.charAt(k++) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack, needle));

        haystack = "aaaaa";
        needle = "bba";
        System.out.println(strStr(haystack, needle));

        haystack = "hello";
        needle = "he";
        System.out.println(strStr(haystack, needle));

        haystack = "hollo";
        needle = "o";
        System.out.println(strStr(haystack, needle));

        haystack = "";
        needle = "oooo";
        System.out.println(strStr(haystack, needle));

        haystack = "aaa";
        needle = "aaaa";
        System.out.println(strStr(haystack, needle));

        haystack = "mississippi";
        needle = "issipi";
        System.out.println(strStr(haystack, needle));

        haystack = "";
        needle = "";
        System.out.println(strStr(haystack, needle));


    }
}
