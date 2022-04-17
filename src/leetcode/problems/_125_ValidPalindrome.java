package leetcode.problems;


/*
    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

    Note: For the purpose of this problem, we define empty string as valid palindrome.

    Example 1:

    Input: "A man, a plan, a canal: Panama"
    Output: true
    Example 2:

    Input: "race a car"
    Output: false
*/

public class _125_ValidPalindrome {

    /*
        Time: O(N)
        Memory: O(1)
    */

    public static boolean isPalindrome(String s) {

        int first = 0;
        int last = s.length() - 1;

        while (first <= last) {
            while (first < s.length() && !Character.isLetterOrDigit(s.charAt(first))) {
                first++;
            }

            while (last >= 0 && !Character.isLetterOrDigit(s.charAt(last))) {
                last--;
            }

            if (first < s.length() && last >= 0 && Character.toLowerCase(s.charAt(first)) != Character.toLowerCase(s.charAt(last))) {
                return false;
            }
            first++;
            last--;
        }
        return true;
    }


    public static void main(String[] args) {

        String s = "";
        System.out.println(isPalindrome(s));

        s = "race a car";
        System.out.println(isPalindrome(s));

        s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

        s = "::::::";
        System.out.println(isPalindrome(s));

        s = "s::::::";
        System.out.println(isPalindrome(s));

        s = "::s::::s";
        System.out.println(isPalindrome(s));

        s = "s::b::::d";
        System.out.println(isPalindrome(s));

        s = "0P";
        System.out.println(isPalindrome(s));

    }
}
