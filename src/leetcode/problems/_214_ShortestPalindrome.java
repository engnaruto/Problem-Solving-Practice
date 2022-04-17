package leetcode.problems;


/*
    Given a string s, you are allowed to convert it to a palindrome by adding characters
    in front of it. Find and return the shortest palindrome you can find by performing
    this transformation.

    Example 1:

    Input: "aacecaaa"

    Output: "aaacecaaa"

    Example 2:

    Input: "abcd"

    Output: "dcbabcd"
*/
public class _214_ShortestPalindrome {

    /*
        Time: O(N ^ 2)
        Memory: O(N)
    */

    public static String shortestPalindrome(String s) {

        boolean isCompleted;
        int k, i;
        for (i = s.length() - 1; i >= 0; i--) {
            isCompleted = true;

            k = 0;
            for (int j = i; j >= 0 && j >= k; j--) {

                if (s.charAt(j) != s.charAt(k)) {
                    isCompleted = false;
                    break;
                }
                k++;
            }

            if (isCompleted) {
                break;
            }
        }

        StringBuilder builder = new StringBuilder(s);

        for (i = i + 1; i < s.length(); i++) {
            builder.insert(0, s.charAt(i));
        }

        return builder.toString();
    }

    public static void main(String[] args){

        String s = "aacecaaa";
        System.out.println(shortestPalindrome(s));

        s = "abcd";
        System.out.println(shortestPalindrome(s));

        s = "";
        System.out.println(shortestPalindrome(s));

        s = "a";
        System.out.println(shortestPalindrome(s));

        s = "aa";
        System.out.println(shortestPalindrome(s));

        s = "ab";
        System.out.println(shortestPalindrome(s));

        s = "abb";
        System.out.println(shortestPalindrome(s));

        s = "abba";
        System.out.println(shortestPalindrome(s));

        s = "abbc";
        System.out.println(shortestPalindrome(s));
    }
}
