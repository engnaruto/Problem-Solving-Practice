
/*
    Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

    Note:
    The given integer is guaranteed to fit within the range of a 32-bit signed integer.
    You could assume no leading zero bit in the integer’s binary representation.

    Example 1:
    Input: 5
    Output: 2
    Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

    Example 2:
    Input: 1
    Output: 0
    Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
*/

public class _476_NumberComplement {
    /*
        Note: Nice trick in this solution: https://leetcode.com/problems/number-complement/discuss/95992/Java-1-line-bit-manipulation-solution
        Time: O(N)
        Memory: O(1)
    */

    public static int findComplementInOneLine(int num) {
        return ~num & (Integer.highestOneBit(num) - 1);
    }

    /*
        Time: O(N)
        Memory: O(1)
    */

    public static int findComplement(int num) {
        if (num == 0) {
            return 1;
        }

        int complement = 0;
        int numm = num;

        int i = 0;

        while (numm != 0) {
            i++;
            numm >>= 1;
        }


        while (i != 0) {
            i--;
            int bit = num & (1 << i);

            if (bit == 0) {
                complement |= (1 << i);
            }
        }
        return complement;
    }


    public static void main(String[] args) {

        int[] tests = {5, 7, 1, 10, 17};

        for (int test : tests) {
            System.out.println(findComplement(test));
            System.out.println(findComplementInOneLine(test));
        }
    }
}
