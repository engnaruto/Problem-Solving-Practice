package leetcode.problems;


import java.util.ArrayList;
import java.util.List;


/*
    The gray code is a binary numeral system where two successive values differ in only one bit.

    Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
    A gray code sequence must begin with 0.

    Example 1:

    Input: 2

    Output: [0,1,3,2]

    Explanation:
    00 - 0
    01 - 1
    11 - 3
    10 - 2

    For a given n, a gray code sequence may not be uniquely defined.
    For example, [0,2,3,1] is also a valid gray code sequence.

    00 - 0
    10 - 2
    11 - 3
    01 - 1

    Example 2:

    Input: 0

    Output: [0]

    Explanation: We define the gray code sequence to begin with 0.
                 A gray code sequence of n has size = 2^n, which for n = 0 the size is 2^0 = 1.
                 Therefore, for n = 0 the gray code sequence is [0].
*/

public class _89_GrayCode {

    /*
        Time: O(2 ^ N)
        Memory: O(1) If we didn't calculate the size of the result list.
    */

    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n == 0) {
            result.add(0);
            return result;
        }
        int finalLength = (int) Math.pow(2, n);
        result.add(0);
        result.add(1);
        int i = 1;
        while (result.size() != finalLength) {
            for (int k = result.size() - 1; k >= 0; k--) {
                result.add(result.get(k) | (1 << i));
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {

        for (int i : grayCode(3)) {
            System.out.println(Integer.toBinaryString(i));
        }
    }
}
