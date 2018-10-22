package leetcode.problems;


/*
    Given a column title as appear in an Excel sheet, return its corresponding column number.

    For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...

    Example 1:

    Input: "A"

    Output: 1

    Example 2:

    Input: "AB"

    Output: 28

    Example 3:

    Input: "ZY"

    Output: 701
*/

public class _171_ExcelSheetColumnNumber {

    /*
        Time: O(N) N: Number of characters in the string
        Memory: O(1)
    */

    public static int titleToNumber(String s) {

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            sum += num * Math.pow(26, s.length() - i - 1);
        }
        return sum;
    }


    public static void main(String[] args) {
        String s = "A";

        System.out.println(titleToNumber(s));

        s = "AB";

        System.out.println(titleToNumber(s));

        s = "ZY";

        System.out.println(titleToNumber(s));
    }
}
