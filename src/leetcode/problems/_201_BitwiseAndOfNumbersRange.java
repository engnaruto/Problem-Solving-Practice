package leetcode.problems;


/*
    Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

    Example 1:

    Input: [5,7]
    Output: 4
    Example 2:

    Input: [0,1]
    Output: 0
*/
public class _201_BitwiseAndOfNumbersRange {

    /*
        Time: O(1)
        Memory: O(1)
    */

    public static int rangeBitwiseAnd(int m, int n) {
        int i = 0;

        while (m != n) {
            n >>= 1;
            m >>= 1;
            i++;
        }
        return m << i;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(rangeBitwiseAnd(5,7)));
        System.out.println(Integer.toBinaryString(rangeBitwiseAnd(0,1)));
        System.out.println(Integer.toBinaryString(rangeBitwiseAnd(26,30)));
    }
}
